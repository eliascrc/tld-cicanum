package cr.ac.ucr.cicanum.tld.core.programVariable.dao.impl;

import cr.ac.ucr.cicanum.tld.core.programVariable.dao.ProgramVariableDao;
import cr.ac.ucr.cicanum.tld.model.ProgramVariable;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.programVariable.dao.ProgramVariableDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("programVariableDao")
public class HibernateProgramVariableDao extends HibernateCrudDao<ProgramVariable,String> implements ProgramVariableDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
