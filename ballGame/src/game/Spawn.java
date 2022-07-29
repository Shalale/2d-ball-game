package game;

import java.util.Random;

public class Spawn {
    private Random random = new Random();
    private Handler handler;
    private Player player;
    private int counter = 0;
    private int basicEnemy = 0;
    private int fastEnemy = 0;
    private int followerEnemy = 0;


    public Spawn(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
    }

    public void tick() {
        counter++;
        if (counter == 120) {
            if (basicEnemy < 3 && player.coin < 30) {
                handler.addObject(new BasicEnemy(random.nextInt(1000), random.nextInt(1000)));
                basicEnemy++;
            } else if (fastEnemy < 3 && player.coin > 30 && player.coin <= 60) {
                handler.addObject(new FastEnemy(random.nextInt(1000), random.nextInt(1000)));
                fastEnemy++;
            } else if (followerEnemy == 0 && player.coin > 60 && player.coin <= 90) {
                handler.addObject(new FollowerEnemy(random.nextInt(1000), random.nextInt(1000), player));
                followerEnemy++;
            }
        }

        if (counter == 400) {
            handler.addObject(new Health(random.nextInt(1000), random.nextInt(1000)));
            counter = 0;
        }

    }
}
