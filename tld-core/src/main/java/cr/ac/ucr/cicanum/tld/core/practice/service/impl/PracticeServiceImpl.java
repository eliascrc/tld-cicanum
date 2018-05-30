package cr.ac.ucr.cicanum.tld.core.practice.service.impl;

import cr.ac.ucr.cicanum.tld.model.Practice;
import cr.ac.ucr.cicanum.tld.core.practice.service.PracticeService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
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
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
