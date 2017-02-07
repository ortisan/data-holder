package filters;

import holder.DataHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by marcelo on 06/02/17.
 */
@WebFilter
public class DataHolderFactoryFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try (DataHolder dataHolder = new DataHolder((HttpServletRequest) request)) {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
