package me.giverplay.rocketzinho.game;

import me.giverplay.rocketzinho.entity.Entity;
import me.giverplay.rocketzinho.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game {
    public static final int WIDTH = 240;
    public static final int HEIGHT = 180;
    public static final int SCALE = 3;
    public static final int TILE_SIZE = 16;

    public static boolean isRunning = false;
    private Looping looping;
    private Thread gameThread;

    private BufferedImage layer;
    private BufferStrategy bufferStrategy;
    private Canvas canvas;
    private JFrame frame;

    public static ArrayList<Entity> entities = new ArrayList<>();

    public void start() {
        startGame();
        startWindow();
        startLooping();
    }

    private void startGame() {
        entities.clear();
        entities.add(new Player(12, 30));
    }

    private void startWindow() {
        canvas = new Canvas();
        frame = new JFrame();
        layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);

        canvas.createBufferStrategy(3);
        bufferStrategy = canvas.getBufferStrategy();

        frame.setVisible(true);
        canvas.addKeyListener(new KeyInput());
        canvas.requestFocus();
    }

    private void startLooping() {
        looping = new Looping(this);
        gameThread = new Thread(looping);

        isRunning = true;
        gameThread.start();
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.tick();
        }
    }

    public void render() {
        Graphics graphics = layer.getGraphics();
        graphics.setColor(new Color(0xFF00BBAA));
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        for (Entity entity : entities) {
            entity.render(graphics);
        }

        graphics = bufferStrategy.getDrawGraphics();
        graphics.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

        bufferStrategy.show();
    }

    public void stop() {
        isRunning = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.gc();
        System.exit(0);
    }
}
