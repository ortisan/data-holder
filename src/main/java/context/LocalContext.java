package context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by marcelo on 21/01/17.
 */
public class LocalContext implements Context {

    // TODO TEST
    private ThreadLocal<Map<String, Object>> threadLocal;

    public LocalContext() {
        threadLocal = new ThreadLocal<>();
        Map<String, Object> mapLocal = new ConcurrentHashMap<>();
        threadLocal.set(mapLocal);
    }

    public void settAttribute(String name, Object obj) {
        Map<String, Object> mapLocal = threadLocal.get();
        mapLocal.put(name, obj);
        threadLocal.set(mapLocal);
    }

    public Object gettAttribute(String name) {
        Map<String, Object> mapLocal = threadLocal.get();
        return mapLocal.get(name);
    }
}
