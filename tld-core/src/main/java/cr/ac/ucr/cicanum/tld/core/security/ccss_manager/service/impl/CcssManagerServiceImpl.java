package cr.ac.ucr.cicanum.tld.core.security.ccss_manager.service.impl;

import cr.ac.ucr.cicanum.tld.core.security.ccss_manager.dao.CcssManagerDao;
import cr.ac.ucr.cicanum.tld.core.security.ccss_manager.service.CcssManagerService;
import cr.ac.ucr.cicanum.tld.core.security.user.service.UserService;
import cr.ac.ucr.cicanum.tld.model.CcssManager;
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
 * Default implementation of the {@link cr.ac.ucr.cicanum.tld.core.security.ccss_manager.service.CcssManagerService}
 *
 * @author Elías Calderón
 */
@Service("ccssManagerService")
@Transactional
public class CcssManagerServiceImpl extends CrudServiceImpl<CcssManager, String> implements CcssManagerService {

    /**
     * Data access object reference to perform CcssManager operations.
     */
    @Autowired
    private CcssManagerDao ccssManagerDao;

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
        setCrudDao(this.ccssManagerDao);
    }

    /**
     * @see CcssManagerService#getCcssManagerByUsername(String)
     */
    @Override
    public CcssManager getCcssManagerByUsername(String username) {
        return this.ccssManagerDao.findCcssManagerByUsername(username);
    }

    /**
     * Method that loads the UserDetails according to the username specified.
     * @param username String which specifies the user's username to search for.
     * @return The UserDetails of the user found or null if no user with that username was found.
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = this.ccssManagerDao.findCcssManagerByUsername((username.toLowerCase()));
        if(user == null) {
            throw new UsernameNotFoundException("The user " + username + " was not found.");
        }
        return user;
    }

    /**
     * Method that creates a Ccss Manager user by supplying the correct and necessary information
     * to the data access object.
     * @param ccssManager The instance of Ccss Manager that must be created.
     * @return The created user.
     */
    @Override
    public String create(CcssManager ccssManager) {
        if(ccssManager == null) {
            throw new IllegalArgumentException("The ccss manager to be created cannot be null.");
        }

        if(ccssManager.getUsername() == null) {
            throw new IllegalArgumentException("The ccss manager to be created cannot have a null username.");
        }

        User foundUser = this.userService.getUserByUsername((ccssManager.getUsername().toLowerCase()));
        if(foundUser != null) {
            throw new IllegalArgumentException("The user with name: " + ccssManager.getUsername() + " already exists.");
        }

        ccssManager.setUsername(ccssManager.getUsername().toLowerCase());
        SecurityUtils.validatePassword(ccssManager.getPassword());
        ccssManager.setPassword(passwordEncoder.encode(ccssManager.getPassword()));
        ccssManager.setEnabled(true);

        return super.create(ccssManager);
    }

}