package game;

import java.awt.*;

public class Coin extends GameObject{
    public Coin(int x, int y) {
        super(x, y, ID.Coin);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }
}
