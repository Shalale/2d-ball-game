package game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    boolean[] keyPressed = new boolean[5];
    Random random = new Random();
    private Handler handler;
    int health = 100;
    int coin = 0;

    public Player(int x, int y, Handler handler) {
        super(x, y, ID.Player);
        this.handler = handler;
        width = 50;
        height = 50;
    }

    @Override
    public void tick() {
        int v = 6;
        if (keyPressed[1]) velY = -v;
        else if (keyPressed[3]) velY = v;
        else velY = 0;

        if (keyPressed[2]) velX = -v;
        else if (keyPressed[4]) velX = v;
        else velX = 0;

        x += velX;
        y += velY;

        collision();
        x = Game.clamp(x, 0, Game.WIDTH - (width + 5));
        y = Game.clamp(y, 0, Game.HEIGHT - (height + 5));
    }

    public void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject obj = handler.objects.get(i);

            if (obj.id == ID.Enemy) {
                if (this.getBounds().intersects(obj.getBounds())) {
                    if (health > 0) {
                        health--;
                    }
                }
            } else if (obj.id == ID.Health) {
                if (this.getBounds().intersects(obj.getBounds())) {
                    health += 5;
                    if (health >= 95)
                        health = 100;
                    i--;
                    handler.removeObject(obj);

                }
            } else if (obj.id == ID.Coin) {
                if (this.getBounds().intersects(obj.getBounds())) {
                    coin += 5;
                    i--;
                    handler.removeObject(obj);
                    handler.addObject(new Coin(random.nextInt(1000), random.nextInt(1000)));
                }
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, width, height);

    }

}
