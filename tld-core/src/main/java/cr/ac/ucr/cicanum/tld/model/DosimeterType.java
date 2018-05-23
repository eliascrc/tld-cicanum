package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a type of dosimeter (e.g full body, ring, wristband)
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="dosimeter_type")
public class DosimeterType extends BasicEntity {

    @Id
    @Column(name = "id_tipo_dosimetro")
    private int dosimeterTypeId;

    /**
     * The dosimeter's type.
     */
    @Column(name="tipo_dosimetro")
    private String dosimeterType;

    /**
     * The dosimeter type's first letter.
     */
    @Column(name="inicial")
    private String initial;

    //TODO onEquals, onHash
    @Override
    protected boolean onEquals(Object o) {
        return false;
    }

    @Override
    protected int onHashCode(int result) {
        return 0;
    }

    public int getDosimeterTypeId() {
        return dosimeterTypeId;
    }

    public void setDosimeterTypeId(int dosimeterTypeId) {
        this.dosimeterTypeId = dosimeterTypeId;
    }

    public String getDosimeterType() {
        return dosimeterType;
    }

    public void setDosimeterType(String dosimeterType) {
        this.dosimeterType = dosimeterType;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

}
