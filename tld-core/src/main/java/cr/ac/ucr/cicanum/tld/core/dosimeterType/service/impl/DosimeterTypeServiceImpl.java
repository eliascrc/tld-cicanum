package cr.ac.ucr.cicanum.tld.core.dosimeterType.service.impl;

import cr.ac.ucr.cicanum.tld.core.dosimeterType.dao.DosimeterTypeDao;
import cr.ac.ucr.cicanum.tld.model.DosimeterType;
import cr.ac.ucr.cicanum.tld.core.dosimeterType.service.DosimeterTypeService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.dosimeterType.service.DosimeterTypeService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("dosimeterTypeService")
@Transactional
public class DosimeterTypeServiceImpl extends CrudServiceImpl<DosimeterType, String> implements DosimeterTypeService {

    @Autowired
    private DosimeterTypeDao dosimeterTypeDao;

    public void init() {
        setCrudDao(this.dosimeterTypeDao);
    }

    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
