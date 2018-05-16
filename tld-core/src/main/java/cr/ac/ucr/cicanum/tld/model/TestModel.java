package cr.ac.ucr.cicanum.tld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_model")
public class TestModel {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "id")
    private int id;

}
