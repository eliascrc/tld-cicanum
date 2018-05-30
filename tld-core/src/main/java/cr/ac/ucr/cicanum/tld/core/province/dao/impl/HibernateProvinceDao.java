package cr.ac.ucr.cicanum.tld.core.province.dao.impl;

import cr.ac.ucr.cicanum.tld.core.province.dao.ProvinceDao;
import cr.ac.ucr.cicanum.tld.model.Province;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.province.dao.ProvinceDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("provinceDao")
public class HibernateProvinceDao extends HibernateCrudDao<Province,String> implements ProvinceDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
