package cr.ac.ucr.cicanum.tld.core.dosimeterReading.service.impl;

import cr.ac.ucr.cicanum.tld.core.dosimeterReading.dao.DosimeterReadingDao;
import cr.ac.ucr.cicanum.tld.model.DosimeterReading;
import cr.ac.ucr.cicanum.tld.core.dosimeterReading.service.DosimeterReadingService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.dosimeterReading.service.DosimeterReadingService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("dosimeterReadingService")
@Transactional
public class DosimeterReadingServiceImpl extends CrudServiceImpl<DosimeterReading, String> implements DosimeterReadingService {

    @Autowired
    private DosimeterReadingDao dosimeterReadingDao;

    public void init() {
        setCrudDao(this.dosimeterReadingDao);
    }
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
