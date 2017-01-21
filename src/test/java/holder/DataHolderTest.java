package holder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by marcelo on 21/01/17.
 */

public class DataHolderTest {

    private static final String NAME_ATTRIBUTE_TO_TEST = "name";
    private static final String VALUE_ATTRIBUTE_TO_TEST = "Marcelo Ortiz";

    private DataHolder dataHolder;


    @Before
    public void initDataHolder() {
        ServletContext application = new MockServletContext();
        HttpSession session = new MockHttpSession();
        HttpServletRequest request = new MockHttpServletRequest();
        dataHolder = new DataHolder(application, session, request);
    }


    @Test
    public void testApplicationData() {

        this.dataHolder.setAttribute(NAME_ATTRIBUTE_TO_TEST, VALUE_ATTRIBUTE_TO_TEST, Scope.APPLICATION);

        String nameSession = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.SESSION);
        Assert.assertNull(nameSession);

        String nameRequest = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.REQUEST);
        Assert.assertNull(nameRequest);

        String nameLocal = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.LOCAL);
        Assert.assertNull(nameLocal);

        String nameApplication = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.APPLICATION);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameApplication);

        String nameSearchedAllScops = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameSearchedAllScops);
    }

    @Test
    public void testSessionData() {

        this.dataHolder.setAttribute(NAME_ATTRIBUTE_TO_TEST, VALUE_ATTRIBUTE_TO_TEST, Scope.SESSION);

        String nameApplication = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.APPLICATION);
        Assert.assertNull(nameApplication);

        String nameRequest = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.REQUEST);
        Assert.assertNull(nameRequest);

        String nameLocal = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.LOCAL);
        Assert.assertNull(nameLocal);

        String nameSession = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.SESSION);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameSession);

        String nameSearchedAllScops = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameSearchedAllScops);
    }

    @Test
    public void testRequestData() {
        this.dataHolder.setAttribute(NAME_ATTRIBUTE_TO_TEST, VALUE_ATTRIBUTE_TO_TEST, Scope.REQUEST);

        String nameApplication = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.APPLICATION);
        Assert.assertNull(nameApplication);

        String nameSession = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.SESSION);
        Assert.assertNull(nameSession);

        String nameLocal = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.LOCAL);
        Assert.assertNull(nameLocal);

        String nameRequest = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.REQUEST);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameRequest);

        String nameSearchedAllScops = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameSearchedAllScops);
    }

    @Test
    public void testLocalData() {
        this.dataHolder.setAttribute(NAME_ATTRIBUTE_TO_TEST, VALUE_ATTRIBUTE_TO_TEST, Scope.LOCAL);

        String nameApplication = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.APPLICATION);
        Assert.assertNull(nameApplication);

        String nameSession = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.SESSION);
        Assert.assertNull(nameSession);

        String nameRequest = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.REQUEST);
        Assert.assertNull(nameRequest);

        String nameLocal = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST, Scope.LOCAL);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameLocal);

        String nameSearchedAllScops = (String) this.dataHolder.getAttribute(NAME_ATTRIBUTE_TO_TEST);
        Assert.assertEquals(VALUE_ATTRIBUTE_TO_TEST, nameSearchedAllScops);
    }
}
