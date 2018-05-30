package cr.ac.ucr.cicanum.tld.core.province.service.impl;

import cr.ac.ucr.cicanum.tld.core.province.dao.ProvinceDao;
import cr.ac.ucr.cicanum.tld.model.Province;
import cr.ac.ucr.cicanum.tld.core.province.service.ProvinceService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.province.service.ProvinceService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("provinceService")
@Transactional
public class ProvinceServiceImpl extends CrudServiceImpl<Province, String> implements ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;

    public void init() {
        setCrudDao(this.provinceDao);
    }

    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
