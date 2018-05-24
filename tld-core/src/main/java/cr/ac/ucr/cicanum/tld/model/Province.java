package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a province where a Service is located.
 *
 * @author Elías Calderón
 */
@Entity
@Table(name="provincia")
public class Province extends BasicEntity {

    /**
     * The id of the province
     */
    @Id
    @Column(name = "id_provincia")
    private int provinceId;

    /**
     * The name of the province
     */
    @Column(name = "nombre")
    private String name;

    @Override
    protected boolean onEquals(Object o) {
        boolean result = false;
        if ( o instanceof Province){
            Province province = (Province) o;
            result = this.provinceId == province.getProvinceId();
        }
        return result;
    }

    @Override
    protected int onHashCode(int result) {
        final int prime = 53;
        result = prime * result + this.provinceId;
        return result;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
