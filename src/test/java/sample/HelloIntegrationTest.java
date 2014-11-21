package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0",
        "spring.datasource.url:jdbc:h2:mem:hello;DB_CLOSE_ON_EXIT=FALSE"})
public class HelloIntegrationTest {
    @Value("${local.server.port}")
    int port;

    @Test
    public void test() throws Exception {
        given()
                .param("yourName", "world")
                .when()
                .get("http://localhost:" + port + "/resource/hello")
                .then()
                .content(is("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<title>hello</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<p>Hello, world!</p>\n"
                        + "</body>\n"
                        + "</html>\n"));
    }
}
