package cr.ac.ucr.cicanum.tld.core.security.service_manager.service.impl;

import cr.ac.ucr.cicanum.tld.core.security.service_manager.dao.ServiceManagerDao;
import cr.ac.ucr.cicanum.tld.core.security.service_manager.service.ServiceManagerService;
import cr.ac.ucr.cicanum.tld.core.security.user.service.UserService;
import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import cr.ac.ucr.cicanum.tld.model.User;
import cr.ac.ucr.cicanum.tld.support.SecurityUtils;
import cr.ac.ucr.cicanum.tld.support.flexjson.JSONSerializerBuilder;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implementation of the {@link ServiceManagerService}
 *
 * @author Elías Calderón
 */
@Service("serviceManagerService")
@Transactional
public class ServiceManagerServiceImpl extends CrudServiceImpl<ServiceManager, String> implements ServiceManagerService {

    /**
     * Data access object reference to perform ServiceManager operations.
     */
    @Autowired
    private ServiceManagerDao serviceManagerDao;

    @Autowired
    private UserService userService;

    /**
     * Password encoder provided by spring to cipher a user's password and store it in the database so that it can
     * be compared later when the user enters his password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Initialization method that sets the respective fields during bean instantiation.
     */
    public void init(){
        setCrudDao(this.serviceManagerDao);
    }

    /**
     * @see ServiceManagerService#getServiceManagerByUsername(String)
     */
    @Override
    public ServiceManager getServiceManagerByUsername(String username) {
        return this.serviceManagerDao.findServiceManagerByUsername(username);
    }

    /**
     * Method that loads the UserDetails according to the username specified.
     * @param username String which specifies the user's username to search for.
     * @return The UserDetails of the user found or null if no user with that username was found.
     * @throws UsernameNotFoundException when the username is not found
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = this.serviceManagerDao.findServiceManagerByUsername((username.toLowerCase()));
        if(user == null) {
            throw new UsernameNotFoundException("The user " + username + " was not found.");
        }
        return user;
    }

    /**
     * Method that creates a Service Manager user by supplying the correct and necessary information
     * to the data access object.
     * @param serviceManager The instance of Service Manager that must be created.
     * @return The created user.
     */
    @Override
    public String create(ServiceManager serviceManager) {
        if(serviceManager == null) {
            throw new IllegalArgumentException("The service manager to be created cannot be null.");
        }

        if(serviceManager.getUsername() == null) {
            throw new IllegalArgumentException("The service manager to be created cannot have a null username.");
        }

        User foundUser = this.userService.getUserByUsername((serviceManager.getUsername().toLowerCase()));
        if(foundUser != null) {
            throw new IllegalArgumentException("The user with name: " + serviceManager.getUsername() + " already exists.");
        }

        serviceManager.setUsername(serviceManager.getUsername().toLowerCase());
        SecurityUtils.validatePassword(serviceManager.getPassword());
        serviceManager.setPassword(passwordEncoder.encode(serviceManager.getPassword()));
        serviceManager.setEnabled(true);

        return super.create(serviceManager);
    }

}