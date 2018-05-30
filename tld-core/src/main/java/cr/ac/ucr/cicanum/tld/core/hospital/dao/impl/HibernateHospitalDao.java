package cr.ac.ucr.cicanum.tld.core.hospital.dao.impl;

import cr.ac.ucr.cicanum.tld.core.hospital.dao.HospitalDao;
import cr.ac.ucr.cicanum.tld.model.Hospital;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.hospital.dao.HospitalDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("hospitalDao")
public class HibernateHospitalDao extends HibernateCrudDao<Hospital,String> implements HospitalDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
