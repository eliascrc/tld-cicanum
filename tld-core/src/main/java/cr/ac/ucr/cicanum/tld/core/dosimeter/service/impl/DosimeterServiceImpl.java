package cr.ac.ucr.cicanum.tld.core.dosimeter.service.impl;

import cr.ac.ucr.cicanum.tld.model.Dosimeter;
import cr.ac.ucr.cicanum.tld.core.dosimeter.service.DosimeterService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.dosimeter.service.DosimeterService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("dosimeterService")
@Transactional
public class DosimeterServiceImpl extends CrudServiceImpl<Dosimeter, String> implements DosimeterService {
}
