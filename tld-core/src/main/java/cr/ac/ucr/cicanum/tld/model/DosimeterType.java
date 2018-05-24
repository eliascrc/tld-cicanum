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
@Table(name="tipo_dosimetro")
public class DosimeterType extends BasicEntity {

    /**
     * The system generated if for the dosimeter type
     */
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

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof DosimeterType) {
            DosimeterType dosimeterType = (DosimeterType) o;
            result = this.dosimeterTypeId == dosimeterType.getDosimeterTypeId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 47;
        result = prime * result + this.dosimeterTypeId;
        return result;
    }

    public DosimeterType() {}

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
