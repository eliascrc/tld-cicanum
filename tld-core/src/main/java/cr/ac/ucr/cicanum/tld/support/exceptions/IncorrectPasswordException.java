package cr.ac.ucr.cicanum.tld.support.exceptions;

import cr.ac.ucr.cicanum.tld.model.CicanumUser;

/***
 * Runtime exception thrown when {@link cr.ac.ucr.cicanum.tld.core.security.cicanum_user.service.impl.CicanumUserServiceImpl#resetPassword(CicanumUser, String, String)}
 * receives an incorrect current password.
 *
 * @author Fabián Roberto Leandro
 */
public class IncorrectPasswordException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public IncorrectPasswordException() {
    }

    /**
     * Creates a new exception with the specified message
     * @param message the message to display
     */
    public IncorrectPasswordException(String message) {
        super(message);
    }

    /**
     * Creates a new exception with the specified wrapped exception
     * @param cause the cause of the exception
     */
    public IncorrectPasswordException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new exception with the specified message and wrapped exception
     * @param message the message to display
     * @param cause the cause of the exception
     */
    public IncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
