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
     * Provides the business logic to reset a user's password
     *
     * @param cicanumUser       the user whose password will be updated
     * @param currentPassword   the user's current password, requested to make sure they should be authorized to change their password
     * @param newPassword       newPassword the string to be set as the user's password
     */
    void resetPassword(CicanumUser cicanumUser, String currentPassword, String newPassword);

}