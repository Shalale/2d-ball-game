package game;

import java.awt.*;

public class Hud {
    private Player player;

    public Hud(Player player) {
        this.player = player;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fill3DRect(10 + 2 * player.health, 10, 200 - 2 * player.health, 50, true);

        graphics.setColor(Color.GREEN);
        graphics.fill3DRect(10, 10, 2 * player.health, 50, true);

        graphics.setColor(Color.black);
        graphics.setFont(new Font("default", Font.BOLD, 16));
        graphics.drawString("Players health: " + player.health + "%", 300, 20);
        graphics.drawString("Players coins: " + player.coin, 300, 35);

        if (player.health==0)
            gameOver(graphics);

        if (Game.pause){
            pause(graphics);
        }

    }

    private void gameOver(Graphics graphics) {
        Game.gameRun=false;
        graphics.setColor(new Color(23, 23, 23));
        graphics.fill3DRect(350, 300, 340, 150, true);
        graphics.setColor(Color.white);
        graphics.setFont(new Font("default", Font.BOLD, 36));
        graphics.drawString("GAME OVER ", 400, 370);
        graphics.drawString("COIN: " + player.coin, 430, 420);
    }

    private void pause(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("default", Font.BOLD, 36));
        graphics.drawString("PAUSE ", 450, 370);

    }
}
