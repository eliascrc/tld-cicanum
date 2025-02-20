package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

/**
 * Represents a worker that cold be exposed to radiation dosages.
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="toe")
public class Toe extends BasicEntity {

    @Id
    @Column(name="id_toe")
    private int toeId;

    @ManyToOne
    @JoinColumn(name="id_tipo_dosimetro")
    private DosimeterType dosimeterType;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private MedicalService medicalService;

    @ManyToOne
    @JoinColumn(name="id_cargo")
    private Position position;

    @ManyToOne
    @JoinColumn(name="id_practica")
    private Practice practice;

    @Column(name="cedula")
    private String physicalId;

    @Column(name="fecha_inicio")
    private Date startDate;

    @Column(name="activo")
    private boolean active;

    @Column(name="fecha_desactividad")
    private Date dateDisabled;

    @Column(name="dosis_acumulada_hp10")
    private String accumulatedHp10Dose;

    @Column(name="dosis_acumulada_hp007")
    private String accumulatedHp007Dose;

    @Column(name="dosis_acumulada_hp3")
    private String accumulatedHp3Dose;

    @Column(name="sexo")
    private char sex;

    @Column(name="fecha_nacimiento")
    private Date birthDate;

    @Column(name="pais")
    private String country;

    public Toe() {}

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Toe){
            Toe equipment = (Toe) o;
            result = this.toeId == equipment.getToeId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 19;
        result = prime * result + this.toeId;
        return result;
    }

    public int getToeId() {
        return toeId;
    }

    public void setToeId(int toeId) {
        this.toeId = toeId;
    }

    public DosimeterType getDosimeterType() {
        return dosimeterType;
    }

    public void setDosimeterType(DosimeterType dosimeterType) {
        this.dosimeterType = dosimeterType;
    }

    public MedicalService getMedicalService() {
        return medicalService;
    }

    public void setMedicalService(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public String getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(String physicalId) {
        this.physicalId = physicalId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDateDisabled() {
        return dateDisabled;
    }

    public void setDateDisabled(Date dateDisabled) {
        this.dateDisabled = dateDisabled;
    }

    public String getAccumulatedHp10Dose() {
        return accumulatedHp10Dose;
    }

    public void setAccumulatedHp10Dose(String accumulatedHp10Dose) {
        this.accumulatedHp10Dose = accumulatedHp10Dose;
    }

    public String getAccumulatedHp007Dose() {
        return accumulatedHp007Dose;
    }

    public void setAccumulatedHp007Dose(String accumulatedHp007Dose) {
        this.accumulatedHp007Dose = accumulatedHp007Dose;
    }

    public String getAccumulatedHp3Dose() {
        return accumulatedHp3Dose;
    }

    public void setAccumulatedHp3Dose(String accumulatedHp3Dose) {
        this.accumulatedHp3Dose = accumulatedHp3Dose;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
