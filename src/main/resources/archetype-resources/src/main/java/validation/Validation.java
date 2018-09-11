##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.validation;

import br.ind.seat.seat.model.Envelop;
import static br.ind.seat.seat.model.Envelop.newEnvelop;
import br.ind.seat.seat.model.ErrorMessage;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Validation {

    public <T> Envelop isValid(Long value) {
        if (value < 0) {
            return newEnvelop().error(new ErrorMessage("")).build();
        } else {
            return null;
        }
    }
}
