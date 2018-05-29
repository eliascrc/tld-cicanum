package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a sector of a Service.
 *
 * @author Elías Calderón
 */
@Entity
@Table(name="sector")
public class Sector extends BasicEntity {

    /**
     * The id of the sector
     */
    @Id
    @Column(name = "id_sector")
    private int sectorId;

    /**
     * The name of the sector
     */
    @Column(name = "nombre")
    private String name;

    public Sector(){}

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Sector){
            Sector sector = (Sector) o;
            result = this.sectorId == sector.getSectorId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 61;
        result = prime * result + this.sectorId;
        return result;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
