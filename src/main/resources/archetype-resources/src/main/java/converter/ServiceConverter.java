##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.converter;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author optimus
 */
@RequestScoped
public class ServiceConverter {
    
    public long convert(String value){
        return Long.valueOf(value);
    }
    
    public <T> T convert(T object){
        return object;
    }
}
