package org.example;

public class Main {
    public static void main(String[] args) {
//        Card card = new Card("A", "S");
//        System.out.println(card);

//        Deck deck = new Deck();
//        System.out.println(deck);

//        Shoe shoe = new Shoe(1);
//        System.out.println(shoe);
//        System.out.println("size of shoe before removing cards: " + shoe.size());
//        System.out.println("random card: " + shoe.getRandomCard());
//        System.out.println("size of shoe after removing cards: " + shoe.size());

//        Card first = new Card("5", "S");
//        Card second = new Card("6", "C");
//        Hand hand = new Hand(first, second);
//        System.out.println(hand);

//        Shoe shoe = new Shoe(1);
//        Hand hand = new Hand();
//        hand.addCard(shoe.getRandomCard());
//        hand.addCard(shoe.getRandomCard());
//        System.out.println(hand);

//        Shoe shoe = new Shoe(1);
//        Dealer dealer = new Dealer();
//        dealer.addCard(shoe.getRandomCard());
//        dealer.addCard(shoe.getRandomCard());
//        dealer.setDealersTurnOff();
//        System.out.println("before dealers turn: " + dealer);
//        dealer.setDealersTurnOn();
//        System.out.println("after dealers turn: " + dealer);

        int decks = 1;
        Card card;
        Shoe shoe = new Shoe(decks);
        System.out.println("Cards in shoe with " + decks + " decks: " + shoe.size());
        for(int i = 0; i < shoe.size(); ) {
            card = shoe.getRandomCard();
            System.out.println("rank and suit: " + card + " - value: " + card.getValue() + ", running count: " + shoe.getRunningCount() + ", shoe size: " + shoe.size() + ", approximage deck size: " + shoe.getApproximateDeckSize() + ", true count: " + shoe.getTrueCount());
        }
        System.out.println("Cards left in shoe: " + shoe.size() + ", running count: " + shoe.getRunningCount());
        System.out.println("Max count: " + shoe.getMaxRunningCount() + ", min count: " + shoe.getMinRunningCount() + ", true max count: " + shoe.getMaxTrueCount() + ", true min count: " + shoe.getMinTrueCount());
    }
}