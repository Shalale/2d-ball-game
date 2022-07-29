package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Game game;
    private Player player;

    public KeyInput(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);

        if (key == KeyEvent.VK_W) player.keyPressed[1] = true;
        if (key == KeyEvent.VK_A) player.keyPressed[2] = true;
        if (key == KeyEvent.VK_S) player.keyPressed[3] = true;
        if (key == KeyEvent.VK_D) player.keyPressed[4] = true;

        if (key == KeyEvent.VK_UP) player.keyPressed[1] = true;
        if (key == KeyEvent.VK_LEFT) player.keyPressed[2] = true;
        if (key == KeyEvent.VK_DOWN) player.keyPressed[3] = true;
        if (key == KeyEvent.VK_RIGHT) player.keyPressed[4] = true;


        if (key == KeyEvent.VK_P) {
            if (Game.pause) {
                Game.pause = false;
                Game.gameRun = true;
            } else {
                Game.pause = true;
                Game.gameRun = false;
            }
        }
    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();

        if (key == KeyEvent.VK_W) player.keyPressed[1] = false;
        if (key == KeyEvent.VK_A) player.keyPressed[2] = false;
        if (key == KeyEvent.VK_S) player.keyPressed[3] = false;
        if (key == KeyEvent.VK_D) player.keyPressed[4] = false;

        if (key == KeyEvent.VK_UP) player.keyPressed[1] = false;
        if (key == KeyEvent.VK_LEFT) player.keyPressed[2] = false;
        if (key == KeyEvent.VK_DOWN) player.keyPressed[3] = false;
        if (key == KeyEvent.VK_RIGHT) player.keyPressed[4] = false;


    }
}
