package sample;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class JaxrsTester extends Statement implements TestRule {

    private static final String defaultUrl = "http://localhost:8080";

    private Statement base;

    private final String url;

    private final Class<?>[] classes;

    public JaxrsTester(Class<?>... classes) {
        this(defaultUrl, classes);
    }

    public JaxrsTester(String url, Class<?>... classes) {
        this.url = url;
        this.classes = classes;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        this.base = base;
        return this;
    }

    @Override
    public void evaluate() throws Throwable {
        ResourceConfig rc = new ClassNamesResourceConfig(classes);
        HttpServer server = GrizzlyServerFactory.createHttpServer(url, rc);
        try {
            base.evaluate();
        } finally {
            server.stop();
        }
    }

    public String getUrl() {
        return url;
    }
}
