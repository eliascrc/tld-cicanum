package cr.ac.ucr.cicanum.tld.core.security.ccss_manager.dao;

import cr.ac.ucr.cicanum.tld.model.CcssManager;
import cr.ac.ucr.cicanum.tld.support.dao.CrudDao;

/**
 * Data access object for all the {@link cr.ac.ucr.cicanum.tld.model.CcssManager} related operations.
 *
 * @author Elías Calderón
 */
public interface CcssManagerDao extends CrudDao<CcssManager, String> {

    /**
     * Finds a {@link CcssManager} by its username
     * @param username The manager's username
     * @return The related ccss manager.
     */
    CcssManager findCcssManagerByUsername(String username);

}
