package cr.ac.ucr.cicanum.tld.core.security.ccss_manager.service;

import cr.ac.ucr.cicanum.tld.model.CcssManager;
import cr.ac.ucr.cicanum.tld.support.service.CrudService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Provides business logic services related to {@link cr.ac.ucr.cicanum.tld.model.CcssManager} entities.
 *
 * @author Elías Calderón
 */
public interface CcssManagerService extends CrudService<CcssManager, String>, UserDetailsService {

    /**
     * Finds a {@link CcssManager} by its username
     * @param username The manager's username
     * @return The related ccss manager.
     */
    CcssManager getCcssManagerByUsername (String username);

}