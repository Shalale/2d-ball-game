package game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1100, HEIGHT= WIDTH*2/3 ; // Your game Canvas dimensions.
    public static boolean gameRun = true;
    public static boolean pause = false;
    private Thread thread;
    private boolean running = false;
    private Player player;
    private Handler handler;
    private Hud hud;
    private Spawn spawn;

    public Game() {
        initGame();
        addKeyListener(new KeyInput(this, player));
        Window gameWindow = new Window(WIDTH, HEIGHT, "Our First Game", this);
    }

    public void initGame() {
        Random rand = new Random();
        handler = new Handler();

        player = new Player(WIDTH / 2, HEIGHT / 2, handler);

        handler.addObject(new BasicEnemy(rand.nextInt(1000), rand.nextInt(800)));

        handler.addObject(new Coin(rand.nextInt(1100), rand.nextInt(800)));

        hud = new Hud(player);
        spawn = new Spawn(handler, player);
        handler.addObject(player);
        setFocusable(true);
    }

    public static void main(String[] args) {
        new Game();
    }

    public static int clamp(int number, int min, int max) {
        if (number >= max) return number = max;
        else if (number <= min) return number = min;
        return number;
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;
            }
            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {
        if (gameRun) {
            handler.tick();
            spawn.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(194, 168, 249));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }

    private void gameOver() {
        if (player.health == 0) {
            running = false;
        }
    }

}