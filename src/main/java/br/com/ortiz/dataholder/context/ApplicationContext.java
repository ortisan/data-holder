package br.com.ortiz.dataholder.context;

import javax.servlet.ServletContext;

/**
 * Created by marcelo on 21/01/17.
 */
public class ApplicationContext implements Context {

    private ServletContext application;

    public ApplicationContext(ServletContext application) {
        this.application = application;
    }

    @Override
    public void settAttribute(String name, Object obj) {
        application.setAttribute(name, obj);
    }

    @Override
    public Object gettAttribute(String name) {
        return application.getAttribute(name);
    }

    @Override
    public void invalidate() {
    }
}
