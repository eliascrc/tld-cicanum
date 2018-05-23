package cr.ac.ucr.cicanum.tld.core.security.ccss_manager.dao.impl;

import cr.ac.ucr.cicanum.tld.core.security.ccss_manager.dao.CcssManagerDao;
import cr.ac.ucr.cicanum.tld.model.CcssManager;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate data access object implementation of {@link cr.ac.ucr.cicanum.tld.model.CcssManager}.
 *
 * @author Elías Calderón
 */
@Repository("ccssManagerDao")
public class HibernateCcssManagerDao extends HibernateCrudDao<CcssManager, String> implements CcssManagerDao {

    /**
     * Constructor of the HibernateCcssManager data access object which sets the HibernateCrudDao's
     * session factory to obtain session instances from.
     * @param sessionFactory The SessionFactory instance which is autowired by Spring.
     */
    @Autowired
    public HibernateCcssManagerDao(@Qualifier("sessionFactory") SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    /**
     * @see cr.ac.ucr.cicanum.tld.core.security.ccss_manager.dao.CcssManagerDao#findCcssManagerByUsername(String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public CcssManager findCcssManagerByUsername(String username) {

        Query query = super.getSessionFactory().getCurrentSession()
                .createQuery("from CcssManager where username = :username");

        query.setParameter("username", username);
        List<CcssManager> managerResult = (List<CcssManager>)query.list();

        return DataAccessUtils.singleResult(managerResult);
    }
}
