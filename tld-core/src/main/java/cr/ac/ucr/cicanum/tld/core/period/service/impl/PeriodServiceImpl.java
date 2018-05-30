package cr.ac.ucr.cicanum.tld.core.period.service.impl;

import cr.ac.ucr.cicanum.tld.core.period.dao.PeriodDao;
import cr.ac.ucr.cicanum.tld.model.Period;
import cr.ac.ucr.cicanum.tld.core.period.service.PeriodService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.period.service.PeriodService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("periodService")
@Transactional
public class PeriodServiceImpl extends CrudServiceImpl<Period, String> implements PeriodService {

    @Autowired
    private PeriodDao periodDao;

    public void init() {
        setCrudDao(this.periodDao);
    }
    
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
