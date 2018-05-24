package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a piece of equipment used to perform readings in the TLD Laboratory.
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="equipo")
public class Equipment extends BasicEntity{

    /**
     * Unique identifier for the equipment.
     */
    @Id
    @Column(name = "id_equipo")
    private int equipmentId;

    /**
     * The equipment's description.
     */
    @Column(name = "descripcion")
    private String description;

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Equipment){
            Equipment equipment = (Equipment) o;
            result = this.equipmentId == equipment.getEquipmentId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 23;
        result = prime * result + this.equipmentId;
        return result;
    }

    public Equipment () {}

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
