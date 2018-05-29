package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a position a TOE can be assigned.
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="cargo")
public class Position extends BasicEntity {

    /**
     * The id of the position
     */
    @Id
    @Column(name = "id_cargo")
    private int positionId;

    /**
     * The name of the position
     */
    @Column(name = "nombre")
    private String name;

    public Position() {}

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Position){
            Position position = (Position) o;
            result = this.positionId == position.getPositionId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 31;
        result = prime * result + this.positionId;
        return result;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}