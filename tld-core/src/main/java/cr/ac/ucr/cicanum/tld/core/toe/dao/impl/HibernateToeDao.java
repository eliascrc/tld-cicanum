package cr.ac.ucr.cicanum.tld.core.toe.dao.impl;

import cr.ac.ucr.cicanum.tld.core.toe.dao.ToeDao;
import cr.ac.ucr.cicanum.tld.model.Toe;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.toe.dao.ToeDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("toeDao")
public class HibernateToeDao extends HibernateCrudDao<Toe,String> implements ToeDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
