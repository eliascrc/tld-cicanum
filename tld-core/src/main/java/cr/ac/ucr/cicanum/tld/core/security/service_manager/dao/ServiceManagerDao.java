package cr.ac.ucr.cicanum.tld.core.security.service_manager.dao;

import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import cr.ac.ucr.cicanum.tld.support.dao.CrudDao;

/**
 * Data access object for all the {@link cr.ac.ucr.cicanum.tld.model.ServiceManager} related operations.
 *
 * @author Elías Calderón
 */
public interface ServiceManagerDao extends CrudDao<ServiceManager, String> {

    /**
     * Finds a {@link ServiceManager} by its username
     * @param username The manager's username
     * @return The related service manager.
     */
    ServiceManager findServiceManagerByUsername(String username);

}
