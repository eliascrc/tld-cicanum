package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a practice a TOE can exercise.
 *
 * @author Fabián Roberto Leandro
 */
@Entity
@Table(name="practica")
public class Practice extends BasicEntity {

    /**
     * The id of the practice
     */
    @Id
    @Column(name = "id_practica")
    private int practiceId;

    /**
     * The name of the practice
     */
    @Column(name = "nombre")
    private String name;

    public Practice(){}

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Practice){
            Practice practice = (Practice) o;
            result = this.practiceId == practice.getPracticeId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 37;
        result = prime * result + this.practiceId;
        return result;
    }

    public int getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(int practiceId) {
        this.practiceId = practiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
