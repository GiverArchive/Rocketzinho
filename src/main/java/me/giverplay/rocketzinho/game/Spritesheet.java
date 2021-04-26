package me.giverplay.rocketzinho.game;

import me.giverplay.rocketzinho.Launcher;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet {
    private static BufferedImage spritesheet;

    public static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }

    public static void init() {
        try {
            spritesheet = ImageIO.read(Launcher.class.getResourceAsStream("/spritesheet.png"));
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
