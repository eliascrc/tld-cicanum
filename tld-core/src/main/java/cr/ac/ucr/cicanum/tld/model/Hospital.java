package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Hospital that hires services from the laboratory.
 * It contains all the hospital information and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.BasicEntity}
 *
 * @author Elías Calderón
 */
@Entity
@Table(name="hospital")
public class Hospital extends BasicEntity {

    /**
     * The id of hospital
     */
    @Id
    @Column(name = "id_hospital")
    private int hospitalId;

    @Column(name = "nombre_hospital")
    private String name;

    @Column(name = "activo")
    private boolean active;

    @Column(name = "privado")
    private boolean privateHospital;

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Hospital){
            Hospital hospital = (Hospital) o;
            result = this.hospitalId == hospital.getHospitalId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 43;
        result = prime * result + this.hospitalId;
        return result;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPrivateHospital() {
        return privateHospital;
    }

    public void setPrivateHospital(boolean privateHospital) {
        this.privateHospital = privateHospital;
    }
}
