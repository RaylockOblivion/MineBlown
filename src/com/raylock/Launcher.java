package com.raylock;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Launcher extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static int width = 300; 
    public static int height = width / 16 * 9; 
    public static int scale = 3;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Launcher() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        frame = new JFrame("Title");
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

    @Override
    public void run() {
        while (running) {
            update();
            render();
        }
    }

    public void update() {

    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.frame.setResizable(false);
        launcher.frame.add(launcher);
        launcher.frame.pack();
        launcher.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launcher.frame.setLocationRelativeTo(null);
        launcher.frame.setVisible(true);
        launcher.start();
    }

}
