package cr.ac.ucr.cicanum.tld.core.dosimeter.service;

import cr.ac.ucr.cicanum.tld.model.Dosimeter;
import cr.ac.ucr.cicanum.tld.support.service.CrudService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Provides business logic services related to {@link cr.ac.ucr.cicanum.tld.model.Dosimeter} entities.
 *
 * @author Elías Calderón
 */
@Service("dosimeterService")
@Transactional
public interface DosimeterService extends CrudService<Dosimeter, String> {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
