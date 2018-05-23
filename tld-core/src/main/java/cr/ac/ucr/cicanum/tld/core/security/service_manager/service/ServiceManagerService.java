package cr.ac.ucr.cicanum.tld.core.security.service_manager.service;

import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import cr.ac.ucr.cicanum.tld.support.service.CrudService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Provides business logic services related to {@link cr.ac.ucr.cicanum.tld.model.ServiceManager} entities.
 *
 * @author Elías Calderón
 */
public interface ServiceManagerService extends CrudService<ServiceManager, String>, UserDetailsService {

    /**
     * Finds a {@link ServiceManager} by its username
     * @param username The manager's username
     * @return The related service manager.
     */
    ServiceManager getServiceManagerByUsername(String username);

}