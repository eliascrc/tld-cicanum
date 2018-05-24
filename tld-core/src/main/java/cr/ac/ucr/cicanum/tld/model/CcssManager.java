package cr.ac.ucr.cicanum.tld.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a CCSS Manager within the TLD system.
 * It contains the reference to public hospitals and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.User}
 *
 * @author Elías Calderón
 */
@Entity
@Table(name = "encargado_ccss")
public class CcssManager extends User {

    /**
     * The public hospitals that the manager can oversee
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "supervision_hospital_ccss",
            joinColumns = { @JoinColumn(name = "nombre_usuario_ccss") },
            inverseJoinColumns = { @JoinColumn(name = "id_hospital") }
    )
    private Set<Hospital> publicHospitals;

    public CcssManager() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>(super.getAuthorities());
        if (this.enabled)
            authorities.add(new SimpleGrantedAuthority("ROLE_CCSS_MANAGER"));
        return authorities;
    }

    public Set<Hospital> getPublicHospitals() {
        return publicHospitals;
    }

    public void setPublicHospitals(Set<Hospital> publicHospitals) {
        this.publicHospitals = publicHospitals;
    }
}
