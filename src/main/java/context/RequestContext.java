package context;

import javax.servlet.ServletRequest;

/**
 * Created by marcelo on 21/01/17.
 */
public class RequestContext implements Context {
    private ServletRequest request;

    public RequestContext(ServletRequest request) {
        this.request = request;
    }

    @Override
    public void settAttribute(String name, Object obj) {
        request.setAttribute(name, obj);
    }

    @Override
    public Object gettAttribute(String name) {
        return request.getAttribute(name);
    }
}
