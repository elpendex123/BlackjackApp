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

        Shoe shoe = new Shoe(1);
        Dealer dealer = new Dealer();
        dealer.addCard(shoe.getRandomCard());
        dealer.addCard(shoe.getRandomCard());
        dealer.setDealersTurnOff();
        System.out.println("before dealers turn: " + dealer);
        dealer.setDealersTurnOn();
        System.out.println("after dealers turn: " + dealer);
    }
}