package cr.ac.ucr.cicanum.tld.core.toe.service.impl;

import cr.ac.ucr.cicanum.tld.core.toe.dao.ToeDao;
import cr.ac.ucr.cicanum.tld.model.Toe;
import cr.ac.ucr.cicanum.tld.core.toe.service.ToeService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.toe.service.ToeService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("toeService")
@Transactional
public class ToeServiceImpl extends CrudServiceImpl<Toe, String> implements ToeService {

    @Autowired
    private ToeDao toeDao;

    public void init() {
        setCrudDao(this.toeDao);
    }
    
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
