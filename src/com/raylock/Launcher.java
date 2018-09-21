package com.raylock;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Launcher extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static int width = 300, height = width / 16 * 9, scale = 3;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

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

    public void run() {
        while (running) {
            System.out.println("Running...");
        }
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
