package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.plugga.backend.jackson.EntityIdResolver
import java.awt.SystemColor.text

import javax.persistence.*

@Entity
@Table(name = "side")
class Side {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "side_id")
    var id: Int = 0

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    @JsonIdentityReference(alwaysAsId = true)
    var card: Card? = null

    @Column(name = "image_url")
    var imageUrl: String? = null

    @Column(name = "text")
    var text: String? = null

    constructor() {}

    constructor(id: Int) {
        this.id = id
    }

    constructor(imageUrl: String, text: String) {
        this.imageUrl = imageUrl
        this.text = text
    }

    override fun toString(): String {
        return "Side{" +
                "id=" + id +
                ", card=" + card +
                ", imageUrl='" + imageUrl + '\''.toString() +
                ", text='" + text + '\''.toString() +
                '}'.toString()
    }
}
