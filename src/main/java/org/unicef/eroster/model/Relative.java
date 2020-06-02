package org.unicef.eroster.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

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

}
