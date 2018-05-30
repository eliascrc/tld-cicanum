package cr.ac.ucr.cicanum.tld.core.period.dao.impl;

import cr.ac.ucr.cicanum.tld.core.period.dao.PeriodDao;
import cr.ac.ucr.cicanum.tld.model.Period;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.period.dao.PeriodDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("periodDao")
public class HibernatePeriodDao extends HibernateCrudDao<Period,String> implements PeriodDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
