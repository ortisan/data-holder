package br.com.ortiz.dataholder.holder;

import br.com.ortiz.dataholder.context.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 21/01/17.
 */
public class DataHolder implements AutoCloseable {

    private static ThreadLocal<DataHolder> instance = new ThreadLocal<>();

    private Map<Scope, Context> contextMap;

    public DataHolder(HttpServletRequest request) {
        contextMap = new HashMap<>();

        contextMap.put(Scope.APPLICATION, new ApplicationContext(request.getServletContext()));
        contextMap.put(Scope.SESSION, new SessionContext(request.getSession()));
        contextMap.put(Scope.REQUEST, new RequestContext(request));
        contextMap.put(Scope.LOCAL, new LocalContext());
    }

    public Object getAttribute(String name, Scope scope) {
        Context context = contextMap.get(scope);
        Object value = context.gettAttribute(name);
        return value;
    }

    public Object getAttribute(String name) {
        Object value = null;
        for (Scope scope : Scope.values()) {
            value = getAttribute(name, scope);
            if (value != null)
                break;
        }
        return value;
    }

    public void setAttribute(String name, Object value, Scope scope) {
        Context context = contextMap.get(scope);
        context.settAttribute(name, value);
    }

    @Override
    public void close() {
        for (Context context : contextMap.values()) {
            context.invalidate();
        }
        instance.remove();
    }
}
