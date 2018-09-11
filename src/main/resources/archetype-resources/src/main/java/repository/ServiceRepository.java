##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.repository;

import javax.enterprise.context.RequestScoped;
import br.ind.seat.qcard.reporitory.EntityRepository;

@RequestScoped
public class ServiceRepository<T> extends EntityRepository<T>{

}
