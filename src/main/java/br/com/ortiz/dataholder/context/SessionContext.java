package br.com.ortiz.dataholder.context;

import javax.servlet.http.HttpSession;

/**
 * Created by marcelo on 21/01/17.
 */
public class SessionContext implements Context {

    private HttpSession session;

    public SessionContext(HttpSession session) {
        this.session = session;
    }

    @Override
    public void settAttribute(String name, Object obj) {
        session.setAttribute(name, obj);
    }

    @Override
    public Object gettAttribute(String name) {
        return session.getAttribute(name);
    }

    @Override
    public void invalidate() {
    }
}
