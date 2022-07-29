package game;

import java.awt.*;

public class FastEnemy extends GameObject{
    public FastEnemy(int x, int y) {
        super(x, y, ID.Enemy);
        velX = 7;
        velY = 7;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, width, height);
    }
}
