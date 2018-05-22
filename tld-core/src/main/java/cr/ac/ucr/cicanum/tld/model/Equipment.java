package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a piece of equipment used to perform readings in the Termoluminiscencia Laboratory.
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
    private int description;

    //TODO onEquals, onHash
    @Override
    protected boolean onEquals(Object o) {
        return false;
    }

    @Override
    protected int onHashCode(int result) {
        return 0;
    }

    protected StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("equipmentId = ").append(this.getEquipmentId());
        sb.append(", description = ").append(this.getDescription());
        return sb;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
