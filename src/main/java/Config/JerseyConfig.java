package Config;

import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.packages(new String[]{"ma.JAX.Jax.rest"});
        this.register(MoxyXmlFeature.class);
        this.register(CompteListMessageBodyWriter.class);
    }
}