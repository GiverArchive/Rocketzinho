package me.giverplay.rocketzinho;

import me.giverplay.rocketzinho.game.Game;
import me.giverplay.rocketzinho.game.Spritesheet;

public class Launcher {
    public static void main(String[] args) {
        Spritesheet.init();
        Game game = new Game();
        game.start();
    }
}
