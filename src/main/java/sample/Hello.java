package sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("hello")
public class Hello {

    private MessageDao messageDao = new MessageDaoImpl();

    @GET
    @Template("hello.html")
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
