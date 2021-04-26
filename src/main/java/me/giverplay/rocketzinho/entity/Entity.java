package me.giverplay.rocketzinho.entity;

import me.giverplay.rocketzinho.game.Game;

import java.awt.*;

public class Entity {
    public int x;
    public int y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }
}
