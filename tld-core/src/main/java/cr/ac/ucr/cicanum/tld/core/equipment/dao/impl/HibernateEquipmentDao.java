package cr.ac.ucr.cicanum.tld.core.equipment.dao.impl;

import cr.ac.ucr.cicanum.tld.core.equipment.dao.EquipmentDao;
import cr.ac.ucr.cicanum.tld.model.Equipment;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.equipment.dao.EquipmentDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("equipmentDao")
public class HibernateEquipmentDao extends HibernateCrudDao<Equipment,String> implements EquipmentDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
