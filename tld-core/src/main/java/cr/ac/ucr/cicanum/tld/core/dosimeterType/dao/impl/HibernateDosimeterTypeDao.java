package cr.ac.ucr.cicanum.tld.core.dosimeterType.dao.impl;

import cr.ac.ucr.cicanum.tld.core.dosimeterType.dao.DosimeterTypeDao;
import cr.ac.ucr.cicanum.tld.model.DosimeterType;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.dosimeterType.dao.DosimeterTypeDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("dosimeterTypeDao")
public class HibernateDosimeterTypeDao extends HibernateCrudDao<DosimeterType,String> implements DosimeterTypeDao {

    @Autowired
    public HibernateDosimeterTypeDao(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
