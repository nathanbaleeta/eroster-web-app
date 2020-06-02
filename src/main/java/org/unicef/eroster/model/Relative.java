package org.unicef.eroster.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TBL_RELATIVE")
public class Relative implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_relative", unique = true, nullable = false)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="relationship", nullable = false)
    private String relationship;

    @Column(name="international_organization", nullable = false)
    private String internationalOrganization;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getInternationalOrganization() {
        return internationalOrganization;
    }

    public void setInternationalOrganization(String internationalOrganization) {
        this.internationalOrganization = internationalOrganization;
    }

}
