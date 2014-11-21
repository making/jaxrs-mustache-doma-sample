package sample;

import org.glassfish.jersey.server.mvc.Template;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("hello")
@Component
public class Hello {

    @Inject
    MessageDao messageDao;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Template(name = "hello")
    public HelloResponse sayHello(@QueryParam("yourName") String yourName) {
        HelloResponse response = new HelloResponse();
        Message message = messageDao.select(1L);
        response.setMessage(String.format(message.template, yourName));
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
