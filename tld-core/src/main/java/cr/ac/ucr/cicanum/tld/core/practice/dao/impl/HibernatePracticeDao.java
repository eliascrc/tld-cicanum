package cr.ac.ucr.cicanum.tld.core.practice.dao.impl;

import cr.ac.ucr.cicanum.tld.core.practice.dao.PracticeDao;
import cr.ac.ucr.cicanum.tld.model.Practice;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.practice.dao.PracticeDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("practiceDao")
public class HibernatePracticeDao extends HibernateCrudDao<Practice,String> implements PracticeDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
