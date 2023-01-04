package org.example;

public class BasicStrategy {
    // pass in the player's hand and the dealer
    // determine on the first 2 cards of the player and the dealer's second (up) card what to do
    // output should be: hit, stand, split, double down or surrender
    private Dealer dealer;
    private Hand hand;

    public BasicStrategy() {
        dealer = new Dealer();
        hand = new Hand();
    }

    public BasicStrategy(Hand hand, Dealer dealer) {
        this.hand = hand;
        this.dealer = dealer;
    }

    public String whatToDo() {
        return null;
    }
}
