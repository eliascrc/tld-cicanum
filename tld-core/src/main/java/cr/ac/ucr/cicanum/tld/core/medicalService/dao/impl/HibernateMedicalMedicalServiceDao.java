package cr.ac.ucr.cicanum.tld.core.medicalService.dao.impl;

import cr.ac.ucr.cicanum.tld.core.medicalService.dao.MedicalServiceDao;
import cr.ac.ucr.cicanum.tld.model.MedicalService;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link MedicalServiceDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("serviceDao")
public class HibernateMedicalMedicalServiceDao extends HibernateCrudDao<MedicalService,String> implements MedicalServiceDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
