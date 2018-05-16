package cr.ac.ucr.cicanum.tld.support.service;

import cr.ac.ucr.cicanum.tld.model.BasicEntity;

import java.io.Serializable;
import java.util.List;

/**
 * This interface represents the basic CRUD operations that can be provided by
 * a Service
 * <p/>
 * - create <code>create</code>
 * - retrieve <code>findById</code>
 * - update <code>update</code>
 * - delete <code>remove</code>
 * <p/>
 * All Services that want to provide CRUD functionality should implement this
 * interface, it is recommended for a Service to provide CRUD methods when its
 * functionality clearly revolves around a well defined object model entity.
 *
 * @author Rodrigo A. Bartels
 */
public interface CrudService<ModelObjectType extends BasicEntity, KeyType extends Serializable> {

    /**
     * Makes <code>entity</code> persistent.
     *
     * @param entity the entity to be persisted.
     * @return the generated primary key identifier for the new persistent entity.
     */
    KeyType create(ModelObjectType entity);

    /**
     * Updates the entity data into the data store.
     *
     * @param entity the entity to be updated.
     */
    void update(ModelObjectType entity);

    /**
     * Removes the entity from the data stores (making the instance passed as
     * parameter transient).
     *
     * @param entity the entity to be removed/made transient.
     */
    void remove(ModelObjectType entity);

    /**
     * Returns all the entities of the given Service Class.
     *
     * @return the collection of entities.
     */
    List<ModelObjectType> getAll();
}
