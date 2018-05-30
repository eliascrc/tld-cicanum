package cr.ac.ucr.cicanum.tld.core.hospital.service.impl;

import cr.ac.ucr.cicanum.tld.model.Hospital;
import cr.ac.ucr.cicanum.tld.core.hospital.service.HospitalService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.hospital.service.HospitalService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("hospitalService")
@Transactional
public class HospitalServiceImpl extends CrudServiceImpl<Hospital, String> implements HospitalService {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
