package sample;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/resource")
@Component
public class JerseyConfig extends ResourceConfig {
    @Value("${cache.tempaltes:false}")
    boolean cacheTemplates;

    public JerseyConfig() {
        this.packages(true, "sample", "org.glassfish.jersey")
                .property(MustacheMvcFeature.CACHE_TEMPLATES, cacheTemplates)
                .register(MustacheMvcFeature.class);
    }
}
