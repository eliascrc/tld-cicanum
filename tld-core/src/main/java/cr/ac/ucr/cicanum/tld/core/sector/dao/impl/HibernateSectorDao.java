package cr.ac.ucr.cicanum.tld.core.sector.dao.impl;

import cr.ac.ucr.cicanum.tld.core.sector.dao.SectorDao;
import cr.ac.ucr.cicanum.tld.model.Sector;
import cr.ac.ucr.cicanum.tld.support.dao.impl.HibernateCrudDao;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of {@link cr.ac.ucr.cicanum.tld.core.sector.dao.SectorDao}.
 *
 * @author Fabián Roberto Leandro
 */
@Repository("sectorDao")
public class HibernateSectorDao extends HibernateCrudDao<Sector,String> implements SectorDao {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
