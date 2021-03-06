##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.controller;

import ${package}.converter.ServiceConverter;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import ${package}.service.ProjectService;
import ${package}.validation.Validation;
import br.ind.seat.seat.model.Envelop;
import static br.ind.seat.seat.model.Envelop.newEnvelop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RequestScoped
public class ServiceController<T> {
    private static final Logger logger = LogManager.getLogger(ServiceController.class.getName());
    
    @Inject
    private ProjectService service;
    @Inject
    private ServiceConverter converter;
    @Inject @RequestScoped
    private Validation validation;
    
    public Envelop save(T object) {
        return newEnvelop().item(service.save(object)).build();
    }

    public Envelop findAll() {
        return newEnvelop().items(service.findAll()).build();
    }
    
    public Envelop findById(String id) {
        Long num = converter.convert(id);
        Envelop resp = validation.isValid(num);

        if(resp != null){
            return resp;
        }
        return newEnvelop().item(service.findById(num)).build();
    }
    
}
