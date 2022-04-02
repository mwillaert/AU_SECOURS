package view;

import javax.swing.*;

public class Window extends JFrame {
    private static Window instance = new Window();
    Camera c = new Camera();
    Thread t;
    public Window() {
        this.setSize(600,400);
        this.setResizable(false);
        this.setVisible(false);
        this.setContentPane(c);
    }

    public static Window getInstance() {
        return instance;
    }
}
