package game;

import java.awt.*;

public class FollowerEnemy extends GameObject {
    private Player player;

    public FollowerEnemy(int x, int y, Player player) {
        super(x, y, ID.Enemy);
        this.player = player;

        velX = 2.5;
        velY = 2.5;
    }

    @Override
    public void tick() {
        double distance = Math.sqrt(Math.pow(player.x - x, 2) + Math.pow(player.y - y, 2));

        int moveX = (int) (((player.x - x )/ distance) * velX);
        int moveY = (int) (((player.y - y )/ distance) * velY);

        player.collision();

        this.x += moveX;
        this.y += moveY;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(8, 114, 227));
        g.fillOval(x, y, width, height);
    }
}
