package cr.ac.ucr.cicanum.tld.core.medicalService.service.impl;

import cr.ac.ucr.cicanum.tld.core.medicalService.dao.MedicalServiceDao;
import cr.ac.ucr.cicanum.tld.core.medicalService.service.MedicalServiceService;
import cr.ac.ucr.cicanum.tld.model.MedicalService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link MedicalServiceService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("serviceService")
@Transactional
public class MedicalServiceServiceImpl extends CrudServiceImpl<MedicalService, String> implements MedicalServiceService {

    @Autowired
    private MedicalServiceDao medicalServiceDao;

    public void init() {
        setCrudDao(this.medicalServiceDao);
    }
    
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
