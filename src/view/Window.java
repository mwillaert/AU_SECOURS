package view;

import controller.Controller;
import model.Game;
import resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame implements KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Camera drawing;
	
	JPanel container;
	Thread t;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Window f = new Window();
	}
	
	public Window() {
		//Initialize the window and call the functions for the initialization
		super();
		Resources.loadResources();
		configureCamera();
		getDifferencesDimension();
		setGraphicsWindow();
		setEvenementiel();
		Game.reinitialisation();
		enterLoop();
	}
	
	public void setGraphicsWindow() {
		//This function is used for the graphics of the window
		this.setVisible(true);
		this.setSize(640+bh,480+bv);
		this.setResizable(false);
		this.setTitle("");
		Image icon = Toolkit.getDefaultToolkit().getImage("Graphics/icone.png");  
		this.setIconImage(icon);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static int bh;
	public static int bv;
	public void getDifferencesDimension() {
		//To find the decalage between the real size of the window and the size of the screen
		bh = getSize().width - drawing.getSize().width;
		bv = getSize().height - drawing.getSize().height;
	}
	
	public void setEvenementiel() {
		//Creation of the evenementiel (keylistener for the game)
		this.addKeyListener(this);
		this.addMouseListener(this);
	}
	
	public void configureCamera() {
		//Configure the content of the JFrame
		drawing = new Camera();

        this.setContentPane(drawing);
    	setVisible(true);
	}
	
	public void enterLoop() {
		while (true) {
			try {
				Game.loop();
				drawing.repaint();
				Thread.sleep(5);
			}
			catch (Exception e) {
				
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Controller.handleControls(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Controller.handleControls(e.getKeyCode(), false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Game.click(e.getX(), e.getY()-20);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}