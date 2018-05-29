package cr.ac.ucr.cicanum.tld.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a Service Manager within the TLD system.
 * It contains the reference to the user's services and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.User}
 *
 * @author Elías Calderón
 */
@Entity
@Table(name = "encargado_servicio")
public class ServiceManager extends User {

    /**
     * The public services that the manager can oversee
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "asignacion_servicio",
            joinColumns = { @JoinColumn(name = "nombre_usuario_rpr") },
            inverseJoinColumns = { @JoinColumn(name = "id_servicio") }
    )
    private Set<Service> managedServices;

    public ServiceManager () {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>(super.getAuthorities());
        if (this.enabled)
            authorities.add(new SimpleGrantedAuthority("ROLE_SERVICE_MANAGER"));
        return authorities;
    }

    public Set<Service> getManagedServices() {
        return managedServices;
    }

    public void setManagedServices(Set<Service> managedServices) {
        this.managedServices = managedServices;
    }
}
