package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Represents a set of constants given by equipment and dosimeter type to perform dosage calculations.
 *
 * @author Fabián Roberto Leandro
 */
public class ProgramVariable extends BasicEntity {

    @Id
    @ManyToOne
    @JoinColumn(name="id_equipo")
    private Equipment equipment;

    @Id
    @ManyToOne
    @JoinColumn(name="id_tipo_dosimetro")
    //private DosimeterType dosimeterType;

    //TODO onEquals, onHash
    @Override
    protected boolean onEquals(Object o) {
        return false;
    }

    @Override
    protected int onHashCode(int result) {
        return 0;
    }


    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /*public DosimeterType getDosimeterType() {
        return dosimeterType;
    }

    public void setDosimeterType(DosimeterType dosimeterType) {
        this.dosimeterType = dosimeterType;
    }*/
}
