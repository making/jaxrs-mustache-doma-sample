package sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

import com.sun.jersey.api.client.Client;

public class JaxrsThymeleafTest {

    @Rule
    public JaxrsTester tester = new JaxrsTester(
        Hello.class,
        ThymeleafMessageBodyWriter.class);

    @Test
    public void test() throws Exception {
        String actual =
            Client
                .create()
                .resource(tester.getUrl())
                .path("hello")
                .queryParam("yourName", "world")
                .get(String.class);
        String expected =
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\""
                + " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "<head>\n"
                + "<title>hello</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<p>Hello, world!</p>\n"
                + "</body>\n"
                + "</html>\n";
        System.out.println(actual);
        System.out.println(expected);
        assertThat(actual, is(expected));
    }

}
