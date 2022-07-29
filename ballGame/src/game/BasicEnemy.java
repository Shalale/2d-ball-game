package game;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y) {
        super(x, y, ID.Enemy);
        velX = 3;
        velY = 3;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
}
