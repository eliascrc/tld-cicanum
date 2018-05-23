package cr.ac.ucr.cicanum.tld.ws.rest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
@Scope("request")
@Path("/hello")
public class TestResource {

    @GET
    public Response test() {
        String testString = "Hello this is the TLD test!";
        return Response.status(200).entity(testString).build();
    }

}
