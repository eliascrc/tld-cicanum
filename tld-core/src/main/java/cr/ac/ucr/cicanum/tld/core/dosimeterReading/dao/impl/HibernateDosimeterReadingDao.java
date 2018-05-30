package cr.ac.ucr.cicanum.tld.core.dosimeterReading.dao.impl;

import cr.ac.ucr.cicanum.tld.core.dosimeterReading.dao.DosimeterReadingDao;
import cr.ac.ucr.cicanum.tld.model.DosimeterReading;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.dosimeterReading.dao.DosimeterReadingDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("dosimeterReadingDao")
public class HibernateDosimeterReadingDao extends HibernateCrudDao<DosimeterReading,String> implements DosimeterReadingDao {

    @Autowired
    public HibernateDosimeterReadingDao(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
