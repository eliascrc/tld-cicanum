package cr.ac.ucr.cicanum.tld.core.security.user.service.impl;

import cr.ac.ucr.cicanum.tld.core.security.ccss_manager.service.CcssManagerService;
import cr.ac.ucr.cicanum.tld.core.security.cicanum_user.service.CicanumUserService;
import cr.ac.ucr.cicanum.tld.core.security.service_manager.service.ServiceManagerService;
import cr.ac.ucr.cicanum.tld.core.security.user.service.UserService;
import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.model.CcssManager;
import cr.ac.ucr.cicanum.tld.model.User;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implementation of the {@link User}
 *
 * @author Elías Calderón
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends CrudServiceImpl<User, String> implements UserService {

    /**
     * Data access object reference to perform {@link CicanumUser} operations.
     */
    @Autowired
    private CicanumUserService cicanumUserService;

    /**
     * Data access object reference to perform {@link ServiceManager} operations.
     */
    @Autowired
    private ServiceManagerService serviceManagerService;

    /**
     * Data access object reference to perform {@link CcssManager} operations.
     */
    @Autowired
    private CcssManagerService ccssManagerService;

    @Override
    public User getUserByUsername(String username) {

        User foundUser;

        foundUser = cicanumUserService.getCicanumUserByUsername(username);
        if (foundUser != null) {
            return foundUser;
        }

        foundUser = serviceManagerService.getServiceManagerByUsername(username);
        if (foundUser != null) {
            return foundUser;
        }

        foundUser = ccssManagerService.getCcssManagerByUsername(username);
        return foundUser;

    }
}
