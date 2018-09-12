##set( $symbol_pound = '#' )
##set( $symbol_dollar = '$' )
##set( $symbol_escape = '\' )
package ${package}.resource;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ${package}.controller.ServiceController;
import br.ind.seat.seat.model.Envelop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServiceResource<T> {

    private static final Logger logger = LogManager.getLogger(ServiceResource.class.getName());

    @Inject
    private ServiceController controller;

    @GET
    @Path("/status")
    public String status() {
        return "{status:\"ATIVO\"}";
    }

    @POST
    public Response update(T object) {
        logger.info("Atualizando %s ".format(object));

        Envelop resp = controller.update(object);

        if (resp.getError() != null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(resp).build();
        }
        return Response.ok(resp).build();
    }

    @PUT
    public Response save(T object) {
        logger.info("Salvando %s ".format(object));

        Envelop resp = controller.save(object);

        if (resp.getError() != null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(resp).build();
        }
        return Response.ok(resp).build();
    }

    @GET    
    public Response findAll() {        
        return Response.ok(controller.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") @NotNull  String id) {
        logger.info("Recebido o Id %s".format(id));
        Envelop resp = controller.findById(id);
        
        if(resp.getError() != null){
            return Response.status(Response.Status.BAD_REQUEST).entity(resp).build();
        }
        
        return Response.ok(resp).build();
    }
}
