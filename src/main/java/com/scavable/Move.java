package com.scavable;

import java.util.Objects;

public record Move(int player, char symbol, int pos1, int pos2) {

    public Move {
    }
}
