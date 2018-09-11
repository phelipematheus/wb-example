##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import br.ind.seat.qcard.annotations.Transaction;
import ${package}.repository.ServiceRepository;

@RequestScoped
public class ProjectService<T> {

    @Inject
    private ServiceRepository repository;

    @Transaction
    public T save(T object) {
        return repository.saveOrUpdate(object);
    }
    
    @Transaction
    public List<T> findAll() {
        return repository.findAll();
    }
    
    @Transaction
    public T findById(long id) {
        return repository.findById(id);
    }
}
