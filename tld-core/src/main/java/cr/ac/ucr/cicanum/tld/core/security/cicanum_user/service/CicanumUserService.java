package cr.ac.ucr.cicanum.tld.core.security.cicanum_user.service;

import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.support.service.CrudService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Provides business logic services related to {@link CicanumUser} entities.
 *
 * @author Elías Calderón
 */
public interface CicanumUserService extends CrudService<CicanumUser, String>, UserDetailsService {

    /**
     * Finds a {@link CicanumUser} by its username
     * @param username The user's username
     * @return The related cicanum user.
     */
    CicanumUser getCicanumUserByUsername(String username);

    /**
     * Serializes a cicanumuser
     * @param cicanumUser the user to serialize
     * @return the serialized user
     */
    String getSerializedCicanumUser(CicanumUser cicanumUser);

}