package cr.ac.ucr.cicanum.tld.core.security.cicanum_user.dao;

import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.support.dao.CrudDao;

/**
 * Data access object for all the {@link cr.ac.ucr.cicanum.tld.model.CicanumUser} related operations.
 *
 * @author Elías Calderón
 */
public interface CicanumUserDao extends CrudDao<CicanumUser, String> {

    /**
     * Finds a {@link CicanumUser} by its username
     * @param username The user's username
     * @return The related cicanum user.
     */
    CicanumUser findCicanumUserByUsername(String username);

}
