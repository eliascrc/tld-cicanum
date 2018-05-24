package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Represents a set of constants given by equipment and dosimeter type to perform dosage calculations.
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="variable_programa")
public class ProgramVariable extends BasicEntity {

    /**
     * The corresponding equipment for the rates
     */
    @Id
    @ManyToOne
    @JoinColumn(name="id_equipo")
    private Equipment equipment;

    /**
     * The corresponding type for the rates
     */
    @Id
    @ManyToOne
    @JoinColumn(name="id_tipo_dosimetro")
    private DosimeterType dosimeterType;

    /**
     * Constant used to calculate HP10 dosages.
     */
    @Column(name="tc")
    private String tc;

    /**
     * The minimum dosage that can be read for HP10
     */
    @Column(name="min")
    private String min;

    /**
     * The daily rate for HP10
     */
    @Column(name="tasa_diaria")
    private String dailyRate;

    /**
     * Constant used to calculate HP007 dosages.
     */
    @Column(name="tc_hp007")
    private String tcHp007;

    /**
     * The minimum dosage that can be read for HP007
     */
    @Column(name="min_hp007")
    private String minHp007;

    /**
     * The daily rate for HP007
     */
    @Column(name="tasa_diaria_hp007")
    private String dailyRateHp007;

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof ProgramVariable){
            ProgramVariable programVariable = (ProgramVariable) o;
            result = ((this.dosimeterType == null ? programVariable.getDosimeterType() == null : this.dosimeterType.equals(programVariable.getDosimeterType()))
                    && (this.equipment == null ? programVariable.getEquipment() == null : this.equipment.equals(programVariable.getEquipment())));
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 23;
        result = prime * result + (this.dosimeterType == null ? 0 : this.dosimeterType.hashCode());
        result = prime * result + (this.equipment == null ? 0 : this.equipment.hashCode());
        return result;
    }

    public ProgramVariable() {}

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public DosimeterType getDosimeterType() {
        return dosimeterType;
    }

    public void setDosimeterType(DosimeterType dosimeterType) {
        this.dosimeterType = dosimeterType;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(String dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getTcHp007() {
        return tcHp007;
    }

    public void setTcHp007(String tcHp007) {
        this.tcHp007 = tcHp007;
    }

    public String getMinHp007() {
        return minHp007;
    }

    public void setMinHp007(String minHp007) {
        this.minHp007 = minHp007;
    }

    public String getDailyRateHp007() {
        return dailyRateHp007;
    }

    public void setDailyRateHp007(String dailyRateHp007) {
        this.dailyRateHp007 = dailyRateHp007;
    }
}
