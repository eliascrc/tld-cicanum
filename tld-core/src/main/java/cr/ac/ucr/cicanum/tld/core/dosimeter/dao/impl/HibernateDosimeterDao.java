package cr.ac.ucr.cicanum.tld.core.dosimeter.dao.impl;

import cr.ac.ucr.cicanum.tld.core.dosimeter.dao.DosimeterDao;
import cr.ac.ucr.cicanum.tld.model.Dosimeter;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.dosimeter.dao.DosimeterDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("dosimeterDao")
public class HibernateDosimeterDao extends HibernateCrudDao<Dosimeter,String> implements DosimeterDao {

    @Autowired
    public HibernateDosimeterDao(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
