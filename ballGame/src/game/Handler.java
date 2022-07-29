package game;

import java.awt.*;
import java.util.ArrayList;

public class Handler {
    ArrayList<GameObject> objects = new ArrayList<>();

    public void tick() {
            for (int i = 0; i < objects.size(); i++) {
                GameObject temp = objects.get(i);
                if (temp != null)
                    temp.tick();
            }
        }

    public void render(Graphics graphics) {
        for (GameObject temp : objects) {
            if (temp != null)
                temp.render(graphics);
        }
    }

    public void addObject(GameObject obj) {
        this.objects.add(obj);
    }

    public void removeObject(GameObject obj) {
        this.objects.remove(obj);
    }
}
