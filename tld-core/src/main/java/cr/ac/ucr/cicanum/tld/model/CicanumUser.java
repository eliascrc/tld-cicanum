package cr.ac.ucr.cicanum.tld.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a CICANUM user within the TLD system.
 * It contains the initials, groups, if the user can sign and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.User}
 */
@Entity
@Table(name = "usuario_cicanum")
public class CicanumUser extends User {

    /**
     * The initials of the user
     */
    @Column(name = "iniciales")
    private String initials;

    /**
     * The group of the user
     */
    @Column(name = "grupo")
    private int group;

    /**
     * Indicates if the user can sign a document
     */
    @Column(name = "puede_firmar")
    private boolean canSign;

    public CicanumUser () {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>(super.getAuthorities());
        if (this.enabled)
            authorities.add(new SimpleGrantedAuthority("ROLE_CICANUM_USER"));
        return authorities;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public boolean canSign() {
        return canSign;
    }

    public void setCanSign(boolean canSign) {
        this.canSign = canSign;
    }
}
