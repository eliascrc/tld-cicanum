package cr.ac.ucr.cicanum.tld.core.security.user.service;

import cr.ac.ucr.cicanum.tld.model.User;
import cr.ac.ucr.cicanum.tld.support.service.CrudService;

/**
 * Provides business logic services related to {@link User} entities.
 *
 * @author Elías Calderón
 */
public interface UserService extends CrudService<User, String> {

    /**
     * Finds a {@link User} by its username
     * @param username The user's username
     * @return The related user.
     */
    User getUserByUsername(String username);

}
