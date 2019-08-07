package com.plugga.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deck")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @OneToMany(mappedBy = "deck",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Pile> piles;

    public Deck() {
    }

    public Deck(String name, String imageUrl, Timestamp dateCreated) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Pile> getPiles() {
        return piles;
    }

    public void setPiles(final List<Pile> piles) {
        this.piles = piles;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public void add(Pile tempPile) {
        if (piles == null) {
            piles = new ArrayList<>();
        }
        piles.add(tempPile);
        tempPile.setDeck(this);
    }
}
