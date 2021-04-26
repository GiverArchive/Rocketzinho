package me.giverplay.rocketzinho.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener  {

    public static boolean left, right, up, down;

    private void change(int code, boolean status) {
        switch (code) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                left = status;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                right = status;
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                up = status;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                down = status;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        change(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        change(e.getKeyCode(), false);
    }
}
