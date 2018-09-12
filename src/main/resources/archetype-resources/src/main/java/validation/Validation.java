##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.validation;

import br.ind.seat.seat.model.Envelop;
import static br.ind.seat.seat.model.Envelop.newEnvelop;
import br.ind.seat.seat.model.ErrorMessage;
import java.util.function.Predicate;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Validation {


    public Envelop isValid(Long value) {
        if (value < 0) {
            return newEnvelop().error(new ErrorMessage("Id inválido")).build();
        } else {
            return null;
        }
    }

    public Envelop isValid(T object, Predicate<T> predicate, String message) {
        if (predicate.test(object)) {
            return newEnvelop().error(new ErrorMessage(message)).build();
        } else {
            return null;
        }
    }

    public static Predicate<T> isNull() {
        return p -> p.getId() == null;
    }

    public static Predicate<T> isNotNull() {
        return p -> p.getId() != null;
    }

}
