package cr.ac.ucr.cicanum.tld.core.canton.service.impl;

import cr.ac.ucr.cicanum.tld.model.Canton;
import cr.ac.ucr.cicanum.tld.core.canton.service.CantonService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.canton.service.CantonService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("cantonService")
@Transactional
public class CantonServiceImpl extends CrudServiceImpl<Canton, String> implements CantonService {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
