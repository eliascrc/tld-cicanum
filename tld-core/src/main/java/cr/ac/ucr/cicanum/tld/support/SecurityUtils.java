package cr.ac.ucr.cicanum.tld.support;

import cr.ac.ucr.cicanum.tld.model.CcssManager;
import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import cr.ac.ucr.cicanum.tld.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Class which provides security utils such as validating a user's password.
 *
 * @author Roberto Leandro
 */
public class SecurityUtils {

    /**
     * Method which validades a user's password by checking it is at least 5 characters long,
     * it has at least one: number, letter and symbol.
     * @param password The user's password to validate
     */
    public static void validatePassword(String password) {

        if (password.length() < 5)
            throw new IllegalArgumentException("Invalid password, the password should at least have 5 characters.");

        boolean noNumber = true;
        boolean noLetter = true;
        boolean noSymbol = true;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (noNumber)
                noNumber = !(c >= 48 && c <= 57);
            if (noLetter)
                noLetter = !((c >= 65 && c <= 90) || (c >= 97 && c <= 122));
            if (noSymbol)
                noSymbol = !((c >= 33 && c <= 47) || (c >= 58 && c <= 64));
            if (!(noNumber || noLetter || noSymbol)) break;
        }

        if (noNumber)
            throw new IllegalArgumentException("Invalid password, the password should at least have one number.");
        if (noSymbol)
            throw new IllegalArgumentException("Invalid password, the password should at least have one symbol.");
        if (noLetter)
            throw new IllegalArgumentException("Invalid password, the password should at least have one letter.");
    }

    /**
     * Gets the currently logged in User via the SecurityContext which returns a principal object that can be casted
     * to User.
     *
     * @return the User currently logged in or null if there's no currently logged in user
     */
    public static User getLoggedInUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if ((principal instanceof User))
                return (User) principal;
        }

        return null;
    }

    /**
     * Gets the currently logged in CicanumUser by casting the user returned by getLoggedInUser Method
     *
     * @return the CicanumUser currently logged in or null if there is none.
     */
    public static CicanumUser getLoggedInCicanumUser() {
        return (CicanumUser) getLoggedInUser();
    }

    /**
     * Gets the currently logged in ServiceManager by casting the user returned by getLoggedInUser Method
     *
     * @return the ServiceManager currently logged in or null if there is none.
     */
    public static ServiceManager getLoggedInServiceManager() {
        return (ServiceManager) getLoggedInUser();
    }

    /**
     * Gets the currently logged in CcssManager by casting the user returned by getLoggedInUser Method
     *
     * @return the CcssManager currently logged in or null if there is none.
     */
    public static CcssManager getLoggedInCcssManager() {
        return (CcssManager) getLoggedInUser();
    }

}