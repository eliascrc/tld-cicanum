package cr.ac.ucr.cicanum.tld.core.programVariable.service.impl;

import cr.ac.ucr.cicanum.tld.model.ProgramVariable;
import cr.ac.ucr.cicanum.tld.core.programVariable.service.ProgramVariableService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.programVariable.service.ProgramVariableService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("programVariableService")
@Transactional
public class ProgramVariableServiceImpl extends CrudServiceImpl<ProgramVariable, String> implements ProgramVariableService {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
