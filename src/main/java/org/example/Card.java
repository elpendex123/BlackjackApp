package org.example;

public class Card {

    private String rank;

    private String suit;

    private int value;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;

        if (rank.equals("2") || rank.equals("3") || rank.equals("4") || rank.equals("5") || rank.equals("6")) {
            value = 1;
        } else if (rank.equals("7") || rank.equals("8") || rank.equals("9")) {
            value = 0;
        } else {
            value = -1;
        }
    }

    public String getRank() {
        return this.rank;
    }

    public int getRankValue() {
        int rankValue = 0;
        if (rank.equals("2") || rank.equals("3") || rank.equals("4") || rank.equals("5") || rank.equals("6") || rank.equals("7") || rank.equals("8") || rank.equals("9")) {
            rankValue = Integer.valueOf(rank);
        } else if (rank.equals("T") || rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
            rankValue =  10;
        } else if (rank.equals("A")) {
            rankValue =  1;
        }
        return rankValue;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return this.rank + this.suit;
    }
}
