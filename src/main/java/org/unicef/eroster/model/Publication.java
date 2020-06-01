package org.unicef.eroster.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TBL_PUBLICATION")
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_publication", unique = true, nullable = false)
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="publisher", nullable = false)
    private String publisher;

    @Column(name="date_published", nullable = false)
    private Date datePublished;

    @Column(name="city_published", nullable = false)
    private String cityPublished;

    @Column(name="country", nullable = false)
    private String country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getCityPublished() {
        return cityPublished;
    }

    public void setCityPublished(String cityPublished) {
        this.cityPublished = cityPublished;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
