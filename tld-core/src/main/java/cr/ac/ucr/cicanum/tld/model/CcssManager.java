package cr.ac.ucr.cicanum.tld.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "encargado_ccss")
public class CcssManager extends User {

    //TODO Poner referencia a Hospital

    @Override
    protected boolean onEquals(Object o) {
        return false;
    }

    @Override
    protected int onHashCode(int result) {
        return 0;
    }

    public CcssManager() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>(super.getAuthorities());
        if (this.enabled)
            authorities.add(new SimpleGrantedAuthority("ROLE_CCSS_MANAGER"));
        return authorities;
    }

}
