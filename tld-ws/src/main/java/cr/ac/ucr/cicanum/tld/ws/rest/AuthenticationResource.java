package cr.ac.ucr.cicanum.tld.ws.rest;

import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import cr.ac.ucr.cicanum.tld.model.User;
import cr.ac.ucr.cicanum.tld.support.SecurityUtils;
import cr.ac.ucr.cicanum.tld.support.flexjson.JSONSerializerBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Resource with various endpoints to process requests regarding the authentication of users, such as login, logout,
 * the retrieval of the currently loggedin user's information and if there's a currently loggedin user.
 *
 * @author Elías Calderón
 */
@Component
@Scope("request")
@Path("/cicanumUser")
public class AuthenticationResource {

    /**
     * Checks if there is a currently logged in user via SecurityUtils
     *
     * @return 200 with "true" if a user is currently logged in, "false" if not
     */
    @GET
    @Path("/loggedIn")
    @Produces(MediaType.TEXT_PLAIN)
    public Response isLoggedIn() {
        if (SecurityUtils.getLoggedInUser() == null)
            return Response.ok().entity("false").build();

        return Response.ok().entity("true").build();
    }

    /**
     * Gets the currently logged-in User, checks whether it is a Cicanum user and then
     * serializes its information to JSON.
     *
     * @return 200 with the logged-in User information in JSON if there's a logged-in user
     * 401 if there is no authenticated user or is not a Cicanum User.
     */
    @GET
    @Path("/authenticated")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthenticatedCicanumUserInformation() {
       CicanumUser cicanumUser = SecurityUtils.getLoggedInCicanumUser();
       return Response.ok().entity(JSONSerializerBuilder.getCicanumUserSerializer().serialize(cicanumUser)).build();
    }

}
