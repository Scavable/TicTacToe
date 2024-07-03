package com.scavable;

public class Player {

    int playerNumber;
    String playerName;
    char playerSymbol;
    boolean myTurn = false;

    public Player(int playerNumber, String playerName, char playerSymbol) {
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }
}
