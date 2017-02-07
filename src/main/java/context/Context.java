package context;

/**
 * Created by marcelo on 21/01/17.
 */
public interface Context {

    void settAttribute(String name, Object obj);

    Object gettAttribute(String name);

    void invalidate();
}
