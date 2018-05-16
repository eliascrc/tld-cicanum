package cr.ac.ucr.cicanum.tld.support.dao;

import cr.ac.ucr.cicanum.tld.model.BasicEntity;

import java.util.List;

/**
 * This interface represents the basic CRUD operations that a DAO has to
 * implement
 * - create <code>create</code>
 * - retrieve <code>findById</code>
 * - update <code>update</code>
 * - delete <code>remove</code>
 * - getAll <code>getAll</code>
 * <p/>
 * All DAOs must implement this interface.
 *
 * @author Rodrigo A. Bartels
 */

public interface CrudDao<ModelObjectType extends BasicEntity, KeyType> {
    /**
     * Makes <code>entity</code> persistent.
     *
     * @param entity the entity to be persisted.
     * @return the generated primary key identifier for the new persistent
     * entity.
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
     * Searches for all the entities.
     *
     * @return the collection of entities.
     */
    List<ModelObjectType> getAll();
}