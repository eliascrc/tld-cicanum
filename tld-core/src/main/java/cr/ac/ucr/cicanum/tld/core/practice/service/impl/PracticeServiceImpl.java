package cr.ac.ucr.cicanum.tld.core.practice.service.impl;

import cr.ac.ucr.cicanum.tld.core.practice.dao.PracticeDao;
import cr.ac.ucr.cicanum.tld.model.Practice;
import cr.ac.ucr.cicanum.tld.core.practice.service.PracticeService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.practice.service.PracticeService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("practiceService")
@Transactional
public class PracticeServiceImpl extends CrudServiceImpl<Practice, String> implements PracticeService {

    @Autowired
    private PracticeDao practiceDao;

    public void init() {
        setCrudDao(this.practiceDao);
    }
    
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
