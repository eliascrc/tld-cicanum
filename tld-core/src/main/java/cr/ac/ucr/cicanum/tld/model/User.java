package cr.ac.ucr.cicanum.tld.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a user within the TLD system.
 * It contains the username, password, email, flags, phone number and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.BasicEntity} class and {@link UserDetails} interface.
 */
@MappedSuperclass
public abstract class User extends BasicEntity implements UserDetails {

    /**
     * Username can't be empty, null or duplicated. It represents the user's email address.
     */
    @Id
    @Column(name = "nombre_usuario")
    protected String username;

    /**
     * The user's first name.
     */
    @Column(name = "nombre", nullable = false)
    protected String firstName;

    /**
     * The user's last name.
     */
    @Column(name = "apellido", nullable = false)
    protected String lastName;

    /**
     * User password.
     */
    @Column(name = "password", nullable = false)
    protected String password;

    /**
     * The user's phone number
     */
    @Column(name = "telefono")
    protected String phoneNumber;

    /**
     * The user's email
     */
    @Column(name = "correo_electronico")
    protected String email;

    /**
     * Indicates if the user is enabled
     */
    @Column(name = "activo", nullable = false)
    protected boolean enabled;

    /**
     * Indicates if the user needs to reset their password
     */
    @Column(name = "reset_password", nullable = false)
    protected boolean resetPassword;

    /**
     * Indicates if the user needs to update their information
     */
    @Column(name = "actualizar_datos")
    protected boolean updateInformation;

    /**
     * The login count of the user
     */
    @Column(name = "login_count", nullable = false)
    protected int login_count;

    /**
     * The last login date of the user
     */
    @Column(name = "last_login")
    protected Timestamp last_login;

    /**
     * The user type
     */
    @Enumerated
    @Column(name = "tipo_usuario", nullable = false)
    protected UserType user_type;

    public User (){}

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if (o instanceof User){
            User user = (User) o;
            result = (this.username == null ? user.getUsername() == null : this.username.equals(user.getUsername())
                    && this.password == null ? user.getPassword() == null : this.password.equals(user.getPassword()));
        }
        return result;
    }

    /**
     * Method that returns the User's authorities, in this case it assigns the USER role,
     * which both users Technical Resource and System Administrator have.
     * @return the collection of authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>();
        if (this.enabled)
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 23;
        result = prime * result + ((this.username == null)? 0 : this.username.hashCode());
        result = prime * result + ((this.password == null)? 0 : this.password.hashCode());
        return result;
    }

    /**
     * @author Rodrigo Bartels
     * @return StringBuilder
     */
    protected StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("username = ").append(this.getUsername());
        sb.append(", enabled = ").append(this.isEnabled());
        sb.append(", resetPassword = ").append(this.isResetPassword());
        return sb;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(boolean resetPassword) {
        this.resetPassword = resetPassword;
    }

    public boolean isUpdateInformation() {
        return updateInformation;
    }

    public void setUpdateInformation(boolean updateInformation) {
        this.updateInformation = updateInformation;
    }

    public int getLogin_count() {
        return login_count;
    }

    public void setLogin_count(int login_count) {
        this.login_count = login_count;
    }

    public Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(Timestamp last_login) {
        this.last_login = last_login;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }


}
