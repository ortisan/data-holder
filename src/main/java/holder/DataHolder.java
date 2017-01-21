package holder;

import context.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 21/01/17.
 */
public class DataHolder {

    private Map<Scope, Context> contextMap;

    // TODO MAKES WITH CDI

    public DataHolder(ServletContext application, HttpSession session, ServletRequest request) {
        this.contextMap = new HashMap<>();
        contextMap.put(Scope.APPLICATION, new ApplicationContext(application));
        contextMap.put(Scope.SESSION, new SessionContext(session));
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

}
