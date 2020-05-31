package org.unicef.eroster.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TBL_REFERENCE")
public class Reference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reference", unique = true, nullable = false)
    private long id;

    @Column(name="full_name", nullable = false)
    private String fullName;

    @Column(name="full_address", nullable = false)
    private String fullAddress;

    @Column(name="email", nullable=false, length=200)
    private String email;

    @Column(name="business_occupation", nullable = false)
    private String businessOccupation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessOccupation() {
        return businessOccupation;
    }

    public void setBusinessOccupation(String businessOccupation) {
        this.businessOccupation = businessOccupation;
    }


}

