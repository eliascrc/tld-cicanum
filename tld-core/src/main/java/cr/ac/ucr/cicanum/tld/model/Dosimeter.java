package cr.ac.ucr.cicanum.tld.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Represents a dosimeter assigned to a TOE, which can be read to get the radiation to which they have been exposed.
 * It contains all the dosimeter information and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.BasicEntity}
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="dosimetro_asignado")
public class Dosimeter extends BasicEntity {

    /**
     * The autogenerated system id
     */
    @Id
    @Column(name = "id_dosimetro")
    private int dosimeterId;

    /**
     * The dosimeter's number, assigned by the TLD Laboratory.
     */
    @NaturalId
    @Column(name = "numero_dosimetro", nullable = false)
    private int dosimeterNumber;

    /**
     * The dosimeter's unique identifier.
     */
    @NaturalId
    @ManyToOne
    @JoinColumn(name="id_tipo_dosimetro", nullable = false)
    private DosimeterType dosimeterType;

    /**
     * The unique identifier of the TOE to which the dosimeter is assigned.
     */
    @NaturalId
    @ManyToOne
    @JoinColumn(name="id_toe", nullable = false)
    private Toe toe;

    /**
     * Indicates if the dosimeter is active.
     */
    @Column(name = "activo", nullable = false)
    private boolean active;

    public Dosimeter(){}

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Dosimeter){
            Dosimeter dosimeter = (Dosimeter) o;
            result = this.dosimeterNumber == dosimeter.getDosimeterNumber()
            && this.dosimeterType.onEquals(dosimeter.getDosimeterType())
            && this.toe.onEquals(dosimeter.getToe());
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 43;
        result = prime * result + this.dosimeterNumber;
        result = prime * result + ((this.dosimeterType == null)? 0 : this.dosimeterType.hashCode());
        result = prime * result + ((this.toe == null)? 0 : this.toe.hashCode());
        return result;
    }

    public int getDosimeterNumber() {
        return dosimeterNumber;
    }

    public void setDosimeterNumber(int dosimeterId) {
        this.dosimeterNumber = dosimeterId;
    }

    public DosimeterType getDosimeterType() {
        return dosimeterType;
    }

    public void setDosimeterType(DosimeterType dosimeterType) {
        this.dosimeterType = dosimeterType;
    }

    public Toe getToe() {
        return toe;
    }

    public void setToe(Toe toe) {
        this.toe = toe;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getDosimeterId() {
        return dosimeterId;
    }

    public void setDosimeterId(int dosimeterId) {
        this.dosimeterId = dosimeterId;
    }
}
