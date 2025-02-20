package cr.ac.ucr.cicanum.tld.core.position.service.impl;

import cr.ac.ucr.cicanum.tld.core.position.dao.PositionDao;
import cr.ac.ucr.cicanum.tld.model.Position;
import cr.ac.ucr.cicanum.tld.core.position.service.PositionService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.position.service.PositionService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("positionService")
@Transactional
public class PositionServiceImpl extends CrudServiceImpl<Position, String> implements PositionService {

    @Autowired
    private PositionDao positionDao;

    public void init() {
        setCrudDao(this.positionDao);
    }

    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
