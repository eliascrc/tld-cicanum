package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a canton where a Service is located.
 *
 * @author Elías Calderón
 */
@Entity
@Table(name="canton")
public class Canton extends BasicEntity {

    /**
     * The id of the canton
     */
    @Id
    @Column(name = "id_canton")
    private int cantonId;

    /**
     * The name of the canton
     */
    @Column(name = "nombre")
    private String name;

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Canton){
            Canton canton = (Canton) o;
            result = this.cantonId == canton.getCantonId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 59;
        result = prime * result + this.cantonId;
        return result;
    }

    public int getCantonId() {
        return cantonId;
    }

    public void setCantonId(int cantonId) {
        this.cantonId = cantonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
