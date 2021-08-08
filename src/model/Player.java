package model;

import java.awt.*;

public class Player {
    private String name;
    private Color color;
    private int moves;
    private int points;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMoves() {
        return this.moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String toString() {
        return "Player [name=" + this.name + ", color=" + this.color + ", moves=" + this.moves + ", points=" + this.points + "]";
    }
}
