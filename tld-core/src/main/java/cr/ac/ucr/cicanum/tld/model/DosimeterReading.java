package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.UniqueConstraint;

/**
 * Represents a dosimeter a reading from a dosimeter assigned to a TOE, performed with the equipment
 * available in the TLD Laboratory
 * It contains all the dosimeter reading information and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.BasicEntity}
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="lectura_equipo",uniqueConstraints = {@UniqueConstraint(columnNames = { "numero_dosimetro", "id_tipo_dosimetro","id_toe" }) })
public class DosimeterReading extends BasicEntity {

    /**
     * The reading's unique identifier.
     */
    @Id
    @Column(name = "id_lectura")
    private int dosimeterReadingId;

    /**
     * The dosimeter on which the reading was performed.
     */
    // TODO FIX THIS!!!!!
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="numero_dosimetro", referencedColumnName = "numero_dosimetro", insertable = false, updatable = false ),
            @JoinColumn(name="id_tipo_dosimetro", referencedColumnName = "id_tipo_dosimetro", insertable = false, updatable = false),
            @JoinColumn(name="id_toe", referencedColumnName = "id_toe", insertable = false, updatable = false ),
    })
    private Dosimeter dosimeter;

    /**
     * The unique identifier od the period during which the reading was performed.
     */
    @ManyToOne
    @JoinColumn(name="id_periodo")
    private Period period;

    /**
     * The HP10 reading.
     */
    @Column(name="lectura_equipo_HP10")
    private String hp10Reading;

    /**
     * The HP10 dose read.
     */
    @Column(name="dosis_HP10")
    private String hp10Dose;

    /**
     * The user's accumulated HP10 dose.
     */
    @Column(name="dosis_acumulada_HP10")
    private String hp10AccumulatedDose;

    /**
     * The user's annual HP10 dose.
     */
    @Column(name="dosis_anual_HP10")
    private String hp10AnnualdDose;

    /**
     * The HP007 reading.
     */
    @Column(name="lectura_equipo_HP007")
    private String hp007Reading;

    /**
     * The HP007 dose read.
     */
    @Column(name="dosis_HP007")
    private String hp007Dose;

    /**
     * The user's accumulated HP007 dose.
     */
    @Column(name="dosis_acumulada_HP007")
    private String hp007AccumulatedDose;

    /**
     * The user's annual HP3 dose.
     */
    @Column(name="dosis_anual_HP007")
    private String hp007AnnualdDose;

    /**
     * The HP3 dose read.
     */
    @Column(name="dosis_HP3")
    private String hp3Dose;

    /**
     * The user's accumulated HP3 dose.
     */
    @Column(name="dosis_acumulada_HP3")
    private String hp3AccumulatedDose;

    /**
     * The user's annual HP3 dose.
     */
    @Column(name="dosis_anual_HP3")
    private String hp3AnnualdDose;

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof DosimeterReading){
            DosimeterReading dosimeterReading = (DosimeterReading) o;
            result = this.dosimeterReadingId == dosimeterReading.getDosimeterReadingId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 43;
        result = prime * result + this.dosimeterReadingId;
        return result;
    }

    public int getDosimeterReadingId() {
        return dosimeterReadingId;
    }

    public void setDosimeterReadingId(int dosimeterReadingId) {
        this.dosimeterReadingId = dosimeterReadingId;
    }

    public Dosimeter getDosimeter() {
        return dosimeter;
    }

    public void setDosimeter(Dosimeter dosimeter) {
        this.dosimeter = dosimeter;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getHp10Reading() {
        return hp10Reading;
    }

    public void setHp10Reading(String hp10Reading) {
        this.hp10Reading = hp10Reading;
    }

    public String getHp10Dose() {
        return hp10Dose;
    }

    public void setHp10Dose(String hp10Dose) {
        this.hp10Dose = hp10Dose;
    }

    public String getHp10AccumulatedDose() {
        return hp10AccumulatedDose;
    }

    public void setHp10AccumulatedDose(String hp10AccumulatedDose) {
        this.hp10AccumulatedDose = hp10AccumulatedDose;
    }

    public String getHp10AnnualdDose() {
        return hp10AnnualdDose;
    }

    public void setHp10AnnualdDose(String hp10AnnualdDose) {
        this.hp10AnnualdDose = hp10AnnualdDose;
    }

    public String getHp007Reading() {
        return hp007Reading;
    }

    public void setHp007Reading(String hp007Reading) {
        this.hp007Reading = hp007Reading;
    }

    public String getHp007Dose() {
        return hp007Dose;
    }

    public void setHp007Dose(String hp007Dose) {
        this.hp007Dose = hp007Dose;
    }

    public String getHp007AccumulatedDose() {
        return hp007AccumulatedDose;
    }

    public void setHp007AccumulatedDose(String hp007AccumulatedDose) {
        this.hp007AccumulatedDose = hp007AccumulatedDose;
    }

    public String getHp007AnnualdDose() {
        return hp007AnnualdDose;
    }

    public void setHp007AnnualdDose(String hp007AnnualdDose) {
        this.hp007AnnualdDose = hp007AnnualdDose;
    }

    public String getHp3Dose() {
        return hp3Dose;
    }

    public void setHp3Dose(String hp3Dose) {
        this.hp3Dose = hp3Dose;
    }

    public String getHp3AccumulatedDose() {
        return hp3AccumulatedDose;
    }

    public void setHp3AccumulatedDose(String hp3AccumulatedDose) {
        this.hp3AccumulatedDose = hp3AccumulatedDose;
    }

    public String getHp3AnnualdDose() {
        return hp3AnnualdDose;
    }

    public void setHp3AnnualdDose(String hp3AnnualdDose) {
        this.hp3AnnualdDose = hp3AnnualdDose;
    }
}
