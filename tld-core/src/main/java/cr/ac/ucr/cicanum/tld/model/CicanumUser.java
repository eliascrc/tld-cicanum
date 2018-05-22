package cr.ac.ucr.cicanum.tld.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "usuario_cicanum")
public class CicanumUser extends User {

    //TODO implement onHashcode and onEquals

    /**
     * The user's initials.
     */
    @Column(name="iniciales")
    private String initials;

    /**
     * User password.
     */
    @Column(name="grupo")
    private int group;

    @Column(name="puede_firmar")
    private boolean canSign;

    @Override
    protected boolean onEquals(Object o) {
        return false;
    }

    @Override
    protected int onHashCode(int result) {
        return 0;
    }

    public CicanumUser() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>(super.getAuthorities());
        if (this.enabled)
            authorities.add(new SimpleGrantedAuthority("ROLE_CICANUM_USER"));
        return authorities;
    }

    public String getInitials() {
        return this.initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public boolean canSign() {
        return this.canSign;
    }

    public void setCanSign(boolean canSign) {
        this.canSign = canSign;
    }
}
