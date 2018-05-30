package cr.ac.ucr.cicanum.tld.core.position.dao.impl;

import cr.ac.ucr.cicanum.tld.core.position.dao.PositionDao;
import cr.ac.ucr.cicanum.tld.model.Position;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.position.dao.PositionDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("positionDao")
public class HibernatePositionDao extends HibernateCrudDao<Position,String> implements PositionDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
