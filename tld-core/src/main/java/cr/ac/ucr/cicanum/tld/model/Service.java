package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Represents a service a TOE can work in. It contains all the service information and the
 * information inherited from {@link cr.ac.ucr.cicanum.tld.model.BasicEntity}
 *
 * @author Elías Calderón
 */
@Entity
@Table(name="servicio")
public class Service extends BasicEntity {

    @Id
    @Column(name = "id_servicio")
    private int serviceId;

    @ManyToOne
    @JoinColumn(name = "id_hospital")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "provincia")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "canton")
    private Canton canton;

    @ManyToOne
    @JoinColumn(name = "sector")
    private Sector sector;

    @Column(name = "cedula")
    private String juridicalId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono")
    private String phonenumber;

    @Column(name = "responsable")
    private String responsible;

    @Column(name = "activo")
    private boolean active;

    @Column(name = "privado")
    private boolean privateService;

    @Column(name = "director")
    private String directorName;

    @ManyToMany(mappedBy = "managedServices")
    private Set<ServiceManager> serviceManagers;

    public Service(){}

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Service){
            Service service = (Service) o;
            result = this.serviceId == service.getServiceId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 41;
        result = prime * result + this.serviceId;
        return result;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getJuridicalId() {
        return juridicalId;
    }

    public void setJuridicalId(String juridicalId) {
        this.juridicalId = juridicalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPrivateService() {
        return privateService;
    }

    public void setPrivateService(boolean privateService) {
        this.privateService = privateService;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Set<ServiceManager> getServiceManagers() {
        return serviceManagers;
    }

    public void setServiceManagers(Set<ServiceManager> serviceManagers) {
        this.serviceManagers = serviceManagers;
    }
}
