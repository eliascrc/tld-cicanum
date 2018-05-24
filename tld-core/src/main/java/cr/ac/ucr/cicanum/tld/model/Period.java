package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

/**
 * Represents a period during which readings were performed.
 *
 * It contains all the period information and the information inherited from
 * {@link cr.ac.ucr.cicanum.tld.model.BasicEntity}
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="periodo")
public class Period extends BasicEntity {

    @Id
    @Column(name="id_periodo")
    private int periodId;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Service service;

    @Column(name="fecha_inicio")
    private Date startDate;

    @Column(name="fecha_final")
    private Date endDate;

    @Column(name="fecha_recepcion_dosimetros")
    private Date dosimeterReceptionDate;

    @Column(name="fecha_lectura_dosimetros")
    private Date dosimeterReadingDate;

    @Column(name="periodo_completo")
    private boolean completePeriod;

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Period){
            Period period = (Period) o;
            result = this.periodId == period.getPeriodId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 43;
        result = prime * result + this.periodId;
        return result;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDosimeterReceptionDate() {
        return dosimeterReceptionDate;
    }

    public void setDosimeterReceptionDate(Date dosimeterReceptionDate) {
        this.dosimeterReceptionDate = dosimeterReceptionDate;
    }

    public Date getDosimeterReadingDate() {
        return dosimeterReadingDate;
    }

    public void setDosimeterReadingDate(Date dosimeterReadingDate) {
        this.dosimeterReadingDate = dosimeterReadingDate;
    }

    public boolean isCompletePeriod() {
        return completePeriod;
    }

    public void setCompletePeriod(boolean completePeriod) {
        this.completePeriod = completePeriod;
    }

    public int getPeriodType() {
        return periodType;
    }

    public void setPeriodType(int periodType) {
        this.periodType = periodType;
    }

    @Column(name="tipo_periodo")
    private int periodType;
}
