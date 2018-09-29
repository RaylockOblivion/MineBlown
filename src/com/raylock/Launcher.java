package com.raylock;

import com.raylock.entity.mob.Player;
import com.raylock.graphics.Screen;
import com.raylock.input.Keyboard;
import com.raylock.level.Level;
import com.raylock.level.SpawnLevel;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Launcher extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static String title = "Rain";

    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Level level;
    private Player player;
    private boolean running = false;

    private Screen screen;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Launcher() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = new SpawnLevel("/textures/level.png");
        player = new Player(8,8,key);

        addKeyListener(key);
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public void update() {
        key.update();
        player.update();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        int xscroll = player.x - screen.width / 2;
        int yscroll = player.y - screen.height / 2;
        level.render(xscroll, yscroll, screen);
        player.render(screen);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.CYAN);
        g.setFont(new Font("Consolas", 0, 20));
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.frame.setTitle(launcher.title);
        launcher.frame.setResizable(false);
        launcher.frame.add(launcher);
        launcher.frame.pack();
        launcher.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launcher.frame.setLocationRelativeTo(null);
        launcher.frame.setVisible(true);
        launcher.start();
    }

}
