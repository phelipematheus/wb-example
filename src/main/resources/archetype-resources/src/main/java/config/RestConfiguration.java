##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.config;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import br.ind.seat.ConsulClient;
import br.ind.seat.qcard.util.EntityManagerProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationScoped
@ApplicationPath("/v1")
public class RestConfiguration extends Application {
    private static final Logger logger = LogManager.getLogger(RestConfiguration.class.getName());
    
    @Inject
    private EntityManagerProducer entityManagerProducer;

    public RestConfiguration() {
    }

    @PostConstruct
    public void init() {
        ConsulClient client = new ConsulClient();
        client.init();
        entityManagerProducer.config(client.getProperties());
    }

}