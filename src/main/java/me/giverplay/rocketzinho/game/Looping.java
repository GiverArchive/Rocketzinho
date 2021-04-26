package me.giverplay.rocketzinho.game;

import me.giverplay.rocketzinho.game.Game;

public class Looping implements Runnable{
    private final Game game;

    public Looping(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        long now;

        double unprocessed = 0;
        double nsTick = 1_000_000_000 / 60.0D;

        int fps = 0;
        int tps = 0;

        while(Game.isRunning) {
            now = System.nanoTime();
            unprocessed += (now - lastTime) / nsTick;
            lastTime = now;

            while(unprocessed >= 1) {
                game.tick();
                ++tps;
                --unprocessed;
            }

            game.render();
            ++fps;

            if(System.currentTimeMillis() - time >= 1000) {
                System.out.println("TPS: " + tps + " | FPS: " + fps);
                tps = 0;
                fps = 0;
                time += 1000;
            }

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
