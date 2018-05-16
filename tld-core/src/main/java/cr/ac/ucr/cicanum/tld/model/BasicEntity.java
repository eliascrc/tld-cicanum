package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract super class for all the entities within the application.
 *
 * @author Rodrigo A. Bartels
 */
@MappedSuperclass
public abstract class BasicEntity implements Serializable, Cloneable, Comparable {

    /**
     * Logger object to use in model classes.
     */
    protected transient final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Timestamp that marks the moment when the entity got created.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entity_creation_timestamp", updatable = false)
    protected Date entityCreationTimestamp;

    /**
     * Timestamp that marks the moment of the last update made to the entity.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_timestamp")
    private Date lastUpdatedTimestamp;

    public Date getEntityCreationTimestamp() {
        return entityCreationTimestamp;
    }

    public void setEntityCreationTimestamp(Date entityCreationTimestamp) {
        this.entityCreationTimestamp = entityCreationTimestamp;
    }

    public Date getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    protected abstract boolean onEquals(Object o);

    protected abstract int onHashCode(int result);

    @Override
    @SuppressWarnings({"CloneDoesntDeclareCloneNotSupportedException"})
    protected Object clone() throws CloneNotSupportedException {
        try {
            BasicEntity cloneEntity = (BasicEntity) super.clone();
            cloneEntity.setEntityCreationTimestamp(null);
            cloneEntity.setLastUpdatedTimestamp(null);
            return cloneEntity;
        } catch (CloneNotSupportedException e) {
            // shouldn't ever happen since this class is Cloneable and
            // a direct subclass of Object
            throw new InternalError("Unable to clone object of type [" + getClass().getName() + "]");
        }
    }

    /**
     * Returns a StringBuilder representing the toString function of the class
     * implementation. This should be overridden by all children classes using
     * <tt>super.toStringBuilder()</tt> as the base, adding properties to the
     * returned StringBuilder.
     *
     * @return a <tt>StringBuilder</tt> representing the <tt>toString</tt>
     * value of this object.
     */
    protected StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("class name = ").append(getClass().getName());
        return sb;
    }

    /**
     * Returns toStringBuilder().toString(). Declared as 'final' to require
     * subclasses to override the {@link #toStringBuilder()} method, a cleaner
     * and better performing mechanism for toString();
     *
     * @return toStringBuilder().toString()
     */
    public final String toString() {
        StringBuilder stringBuilder = toStringBuilder();
        if (stringBuilder != null)
            return toStringBuilder().insert(0, '[').append(']').toString();

        return "";
    }

    @Override
    public int compareTo(Object o) {
        return this.getEntityCreationTimestamp().compareTo(((BasicEntity) o).getEntityCreationTimestamp());
    }
}
