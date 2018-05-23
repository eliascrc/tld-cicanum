package cr.ac.ucr.cicanum.tld.core.security.service_manager.dao.impl;

import cr.ac.ucr.cicanum.tld.core.security.service_manager.dao.ServiceManagerDao;
import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate data access object implementation of {@link cr.ac.ucr.cicanum.tld.model.ServiceManager}.
 *
 * @author Elías Calderón
 */
@Repository("serviceManagerDao")
public class HibernateServiceManagerDao extends HibernateCrudDao<ServiceManager, String> implements ServiceManagerDao {

    /**
     * Constructor of the HibernateServiceManager data access object which sets the HibernateCrudDao's
     * session factory to obtain session instances from.
     * @param sessionFactory The SessionFactory instance which is autowired by Spring.
     */
    @Autowired
    public HibernateServiceManagerDao(@Qualifier("sessionFactory") SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    /**
     * @see ServiceManagerDao#findServiceManagerByUsername(String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public ServiceManager findServiceManagerByUsername(String username) {

        Query query = super.getSessionFactory().getCurrentSession()
                .createQuery("from ServiceManager where username = :username");

        query.setParameter("username", username);
        List<ServiceManager> managerResult = (List<ServiceManager>)query.list();

        return DataAccessUtils.singleResult(managerResult);
    }
}
