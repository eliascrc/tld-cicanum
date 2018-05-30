package cr.ac.ucr.cicanum.tld.core.sector.service.impl;

import cr.ac.ucr.cicanum.tld.model.Sector;
import cr.ac.ucr.cicanum.tld.core.sector.service.SectorService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.sector.service.SectorService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("sectorService")
@Transactional
public class SectorServiceImpl extends CrudServiceImpl<Sector, String> implements SectorService {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
