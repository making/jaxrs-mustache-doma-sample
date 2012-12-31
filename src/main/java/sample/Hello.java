package sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("hello")
public class Hello {

    @GET
    @Template("hello.html")
    public HelloResponse sayHello(@QueryParam("yourName") String yourName) {
        HelloResponse response = new HelloResponse();
        response.setMessage("Hello, " + yourName + "!");
        return response;
    }

    public static class HelloResponse {

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
