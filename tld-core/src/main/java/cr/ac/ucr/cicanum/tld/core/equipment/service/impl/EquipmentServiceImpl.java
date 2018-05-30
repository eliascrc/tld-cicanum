package cr.ac.ucr.cicanum.tld.core.equipment.service.impl;

import cr.ac.ucr.cicanum.tld.model.Equipment;
import cr.ac.ucr.cicanum.tld.core.equipment.service.EquipmentService;
import cr.ac.ucr.cicanum.tld.support.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Default implementation of {@link cr.ac.ucr.cicanum.tld.core.equipment.service.EquipmentService}.
 *
 * @author Fabián Roberto Leandro
 */
@Service("equipmentService")
@Transactional
public class EquipmentServiceImpl extends CrudServiceImpl<Equipment, String> implements EquipmentService {
    /*
     * Por ahora sólo la estructura, implementar los métodos necesarios para el
     * front end cuando se necesiten.
     */
}
