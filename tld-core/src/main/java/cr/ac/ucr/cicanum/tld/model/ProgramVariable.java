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

    @Id
    @ManyToOne
    @JoinColumn(name="id_equipo")
    private Equipment equipment;

    @Id
    @ManyToOne
    @JoinColumn(name="id_tipo_dosimetro")
    private DosimeterType dosimeterType;

    /*
     * Constants used to calculate dosages.
     */
    @Column(name="tc")
    private String tc;

    @Column(name="min")
    private String min;

    @Column(name="tasa_diaria")
    private String dailyRate;

    @Column(name="tc_hp007")
    private String tcHp007;

    @Column(name="min_hp007")
    private String minHp007;

    @Column(name="tasa_diaria_hp007")
    private String dailyRateHp007;

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
