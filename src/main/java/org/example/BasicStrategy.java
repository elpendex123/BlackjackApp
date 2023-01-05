package org.example;

import java.util.HashSet;
import java.util.Set;

public class BasicStrategy {
    private Dealer dealer;
    private Hand hand;
    private boolean softHand = false;
    private boolean hardHand = false;
    private boolean pair = false;

    public BasicStrategy() {
        this.hand = new Hand();
        this.dealer = new Dealer();
    }

    public void setPlayerHandAndDealer(Hand hand, Dealer dealer) {
        this.hand = hand;
        this.dealer = dealer;
    }

    public boolean isItASoftHand() {
        if (hand.getFirstCard().getRank().equals("A") || hand.getSecondCard().getRank().equals("A"))
            softHand = true;
        return softHand;
    }

    public boolean isItAHardHand() {
        if (!hand.getFirstCard().getRank().equals("A") && !hand.getSecondCard().getRank().equals("A"))
            hardHand = true;
        return hardHand;
    }

    public boolean isItAPair() {
        if (hand.getFirstCard().getRankValue() == hand.getSecondCard().getRankValue())
            pair = true;
        return pair;
    }

    public Set whatToDo() {
        isItAPair();
        isItAHardHand();
        isItASoftHand();

        Set<String> result = new HashSet<>();
        int sum = hand.getFirstCard().getRankValue() + hand.getSecondCard().getRankValue();
        int dealersUpCard = dealer.getHand().getSecondCard().getRankValue();
        System.out.println("hand sum: " + sum);
        System.out.println("dealer's up card: " + dealersUpCard);

        if ((hand.getFirstCard().getRank().equals("A") && hand.getSecondCard().getRankValue() == 10 || (hand.getSecondCard().getRank().equals("A") && hand.getFirstCard().getRankValue() == 10))) {
            result.add("BLACKJACK");
            return result;
        }

        if (sum <= 8) result.add("HIT");

        if (hardHand && ! isItAPair()) {
            switch (sum) {
                case 8:
                    result.add("HIT");
                    break;
                case 9:
                    if (dealersUpCard >= 3 && dealersUpCard <= 6)
                        result.add("DOUBLE");
                    else
                        result.add("HIT");
                    break;
                case 10:
                    if (dealersUpCard >= 2 && dealersUpCard <= 9)
                        result.add("DOUBLE");
                    else
                        result.add("HIT");
                    break;
                case 11:
                    result.add("DOUBLE");
                    break;
                case 12:
                    if (dealersUpCard >= 4 && dealersUpCard <= 6)
                        result.add("STAND");
                    else
                        result.add("HIT");
                    break;
                case 13:
                case 14:
                case 15:
                case 16:
                    if (dealersUpCard >= 2 && dealersUpCard <= 6)
                        result.add("STAND");
                    else
                        result.add("HIT");
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    result.add("STAND");
                    break;
            }
        }

        int valueOfFirstCard = hand.getFirstCard().getRankValue();
        int valueOfSecondCard = hand.getSecondCard().getRankValue();
        int otherThanAce;
        if (softHand && ((hand.getFirstCard().getRank().equals("A") && !hand.getSecondCard().getRank().equals("A") || (!hand.getFirstCard().getRank().equals("A") && hand.getSecondCard().getRank().equals("A"))))) {
            otherThanAce = valueOfFirstCard > valueOfSecondCard ? valueOfFirstCard : valueOfSecondCard;
            System.out.println("other than ace value: " + otherThanAce);
            switch (otherThanAce) {
                case 2:
                case 3:
                    if (dealersUpCard >= 5 && dealersUpCard <= 6)
                        result.add("DOUBLE");
                    else
                        result.add("HIT");
                    break;
                case 4:
                case 5:
                    if (dealersUpCard >= 4 && dealersUpCard <= 6)
                        result.add("DOUBLE");
                    else
                        result.add("HIT");
                    break;
                case 6:
                    if (dealersUpCard >= 3 && dealersUpCard <= 6)
                        result.add("DOUBLE");
                    else
                        result.add("HIT");
                    break;
                case 7:
                    if (dealersUpCard >= 2 && dealersUpCard <= 6)
                        result.add("DOUBLE");
                    else if (dealersUpCard >= 7 && dealersUpCard <= 8)
                        result.add("STAND");
                    else
                        result.add("HIT");
                    break;
                case 8:
                    if (dealersUpCard == 6)
                        result.add("DOUBLE");
                    else
                        result.add("STAND");
                    break;
                case 9:
                    result.add("STAND");
                    break;
            }
        }

        if (pair) {
            switch (valueOfFirstCard) {
                case 2:
                case 3:
                case 7:
                    if (dealersUpCard >= 2 && dealersUpCard <= 7)
                        result.add("SPLIT");
                    else
                        result.add("DON'T SPLIT");
                    break;
                case 4:
                    if (dealersUpCard >= 5 && dealersUpCard <= 6)
                        result.add("SPLIT");
                    else
                        result.add("DON'T SPLIT");
                    break;
                case 6:
                    if (dealersUpCard >= 2 && dealersUpCard <= 6)
                        result.add("SPLIT");
                    else
                        result.add("DON'T SPLIT");
                    break;
                case 5:
                    result.add("DON'T SPLIT");
                    break;
                case 8:
                    result.add("SPLIT");
                    break;
                case 9:
                    if ((dealersUpCard >= 2 && dealersUpCard <= 6) || (dealersUpCard >= 8 && dealersUpCard <= 9))
                        result.add("SPLIT");
                    else
                        result.add("DON'T SPLIT");
                    break;
                case 10:
                    result.add("DON'T SPLIT");
                    break;
                case 1:
                    result.add("SPLIT");
                    break;
            }
        }

        return result;
    }
}