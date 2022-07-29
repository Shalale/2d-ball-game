package game;

import java.awt.*;
import java.io.Serializable;

public abstract class GameObject implements Serializable {
    protected int x,y;
    protected ID id;
    protected double velX, velY;
    protected int width = 40;
    protected int height = 40;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public void tick() {
        x+=velX;
        y+=velY;

        x = Game.clamp(x,0,Game.WIDTH-(width+10));
        y = Game.clamp(y,0,Game.HEIGHT-(height+5));

        if (x == Game.WIDTH-(width+10) || x==0)
            velX*=-1;
        if (y == Game.HEIGHT-(height+5)|| y==0)
            velY*=-1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public abstract Rectangle getBounds();
    public abstract void render(Graphics g);
}
