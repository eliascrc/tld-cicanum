package cr.ac.ucr.cicanum.tld.core.security.cicanum_user.service.impl;

import cr.ac.ucr.cicanum.tld.core.security.cicanum_user.dao.CicanumUserDao;
import cr.ac.ucr.cicanum.tld.core.security.cicanum_user.service.CicanumUserService;
import cr.ac.ucr.cicanum.tld.core.security.user.service.UserService;
import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.model.User;
import cr.ac.ucr.cicanum.tld.support.SecurityUtils;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implementation of the {@link CicanumUserService}
 *
 * @author Elías Calderón
 */
@Service("cicanumUserService")
@Transactional
public class CicanumUserServiceImpl extends CrudServiceImpl<CicanumUser, String> implements CicanumUserService {

    /**
     * Data access object reference to perform CicanumUser operations.
     */
    @Autowired
    private CicanumUserDao cicanumUserDao;

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
        setCrudDao(this.cicanumUserDao);
    }

    /**
     * @see CicanumUserService#getCicanumUserByUsername(String)
     */
    @Override
    public CicanumUser getCicanumUserByUsername(String username) {
        return this.cicanumUserDao.findCicanumUserByUsername(username);
    }

    /**
     * Method that loads the UserDetails according to the username specified.
     * @param username String which specifies the user's username to search for.
     * @return The UserDetails of the user found or null if no user with that username was found.
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = this.cicanumUserDao.findCicanumUserByUsername((username.toLowerCase()));
        if(user == null) {
            throw new UsernameNotFoundException("The user " + username + " was not found.");
        }
        return user;
    }

    /**
     * Method that creates a Cicanum User user by supplying the correct and necessary information
     * to the data access object.
     * @param cicanumUser The instance of Cicanum User that must be created.
     * @return The created user.
     */
    @Override
    public String create(CicanumUser cicanumUser) {
        if(cicanumUser == null) {
            throw new IllegalArgumentException("The cicanum user to be created cannot be null.");
        }

        if(cicanumUser.getUsername() == null) {
            throw new IllegalArgumentException("The cicanum user to be created cannot have a null username.");
        }

        User foundUser = this.userService.getUserByUsername((cicanumUser.getUsername().toLowerCase()));
        if(foundUser != null) {
            throw new IllegalArgumentException("The user with name: " + cicanumUser.getUsername() + " already exists.");
        }

        cicanumUser.setUsername(cicanumUser.getUsername().toLowerCase());
        SecurityUtils.validatePassword(cicanumUser.getPassword());
        cicanumUser.setPassword(passwordEncoder.encode(cicanumUser.getPassword()));
        cicanumUser.setEnabled(true);

        return super.create(cicanumUser);
    }

}