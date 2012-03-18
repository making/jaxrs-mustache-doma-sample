package sample;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("hello")
public class Hello {

    @GET
    public ThymeleafTemplate sayHello(@QueryParam("yourName") String yourName) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("message", "Hello, " + yourName + "!");
        return new ThymeleafTemplate("hello.html", variables);
    }
}
