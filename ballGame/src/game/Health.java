package game;

import java.awt.*;

public class Health extends GameObject{
    public Health(int x, int y) {
        super(x, y, ID.Health);
        width =40;
        height=40;
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x,y,width,height);
    }

}
