package cr.ac.ucr.cicanum.tld.core.security.cicanum_user.dao.impl;

import cr.ac.ucr.cicanum.tld.core.security.cicanum_user.dao.CicanumUserDao;
import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate data access object implementation of {@link CicanumUser}.
 *
 * @author Elías Calderón
 */
@Repository("cicanumUserDao")
public class HibernateCicanumUserDao extends HibernateCrudDao<CicanumUser, String> implements CicanumUserDao {

    /**
     * Constructor of the HibernateCicanumUser data access object which sets the HibernateCrudDao's
     * session factory to obtain session instances from.
     * @param sessionFactory The SessionFactory instance which is autowired by Spring.
     */
    @Autowired
    public HibernateCicanumUserDao(@Qualifier("sessionFactory") SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    /**
     * @see CicanumUserDao#findCicanumUserByUsername(String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public CicanumUser findCicanumUserByUsername(String username) {

        Query query = super.getSessionFactory().getCurrentSession()
                .createQuery("from CicanumUser where username = :username");

        query.setParameter("username", username);
        List<CicanumUser> userResult = (List<CicanumUser>)query.list();

        return DataAccessUtils.singleResult(userResult);
    }
}
