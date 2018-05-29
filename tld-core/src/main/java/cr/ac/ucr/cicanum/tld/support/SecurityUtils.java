package cr.ac.ucr.cicanum.tld.support;

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

}