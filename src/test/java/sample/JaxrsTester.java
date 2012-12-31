package sample;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

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
        SelectorThread server = GrizzlyServerFactory.create(url, rc);
        try {
            base.evaluate();
        } finally {
            server.stopEndpoint();
        }
    }

    public String getUrl() {
        return url;
    }
}
