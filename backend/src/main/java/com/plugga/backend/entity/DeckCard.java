package com.plugga.backend.entity;

import javax.persistence.*;

@Entity
@IdClass(DeckCardId.class)
public class DeckCard {

    @Id
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "deck_id")
    private Deck deck;

    @Id
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "pile_id")
    private Pile pile;

    public DeckCard() {
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(final Deck deck) {
        this.deck = deck;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    public Pile getPile() {
        return pile;
    }

    public void setPile(final Pile pile) {
        this.pile = pile;
    }
}
