package me.giverplay.rocketzinho.entity;

import me.giverplay.rocketzinho.game.Game;
import me.giverplay.rocketzinho.game.KeyInput;
import me.giverplay.rocketzinho.game.Spritesheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    private final BufferedImage sprite;

    public Player(int x, int y) {
        super(x, y);

        sprite = Spritesheet.getSprite(0, 0, Game.TILE_SIZE, Game.TILE_SIZE);
    }

    @Override
    public void tick() {
        if(KeyInput.right) ++x;
        if(KeyInput.left) --x;
        if(KeyInput.up) --y;
        if(KeyInput.down) ++y;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, x, y, Game.TILE_SIZE, Game.TILE_SIZE, null);
    }
}
