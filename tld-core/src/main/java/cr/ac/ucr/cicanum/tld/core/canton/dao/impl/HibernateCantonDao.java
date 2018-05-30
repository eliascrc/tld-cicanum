package cr.ac.ucr.cicanum.tld.core.canton.dao.impl;

import cr.ac.ucr.cicanum.tld.core.canton.dao.CantonDao;
import cr.ac.ucr.cicanum.tld.model.Canton;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.canton.dao.CantonDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("cantonDao")
public class HibernateCantonDao extends HibernateCrudDao<Canton,String> implements CantonDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
