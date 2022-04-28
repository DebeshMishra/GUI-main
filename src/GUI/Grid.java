package GUI;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.Scanner;



public class Grid extends JPanel {

	private final int MAX_DOTS = 100;
	private final int DOT_DIAMETER = 5;

	private final int GRID_WIDTH = 720;
	private final int GRID_HEIGHT = 720;

	public int[][] xyPoints = new int[GRID_HEIGHT][GRID_WIDTH];
	public int[][] dotCoordinates = new int[MAX_DOTS][2];

	public void drawDots(Graphics2D g2){
		for (int i = 0; i < MAX_DOTS; i++){
			Ellipse2D ellipse = new Ellipse2D.Double(this.dotCoordinates[i][0], this.dotCoordinates[i][1], DOT_DIAMETER, DOT_DIAMETER);
			Dot dot = new Dot(ellipse);
			dot.fill(g2);
		}
	}

	public void generateCoordinates(){
		for (int i = 0; i < MAX_DOTS; i++){
			Random ran = new Random();
			int x = ran.nextInt(715);
			int y = ran.nextInt(715);

			xyPoints[x][y] = 1;
			dotCoordinates[i][0] = x;
			dotCoordinates[i][1] = y;
		}
	}
	
	public Grid(){
		super();
		generateCoordinates();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// use anti-aliasing to make graphics smooth
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawDots(g2);
	}


	//TODO: Populate the dots only upon button click
	//TODO: make sure the xyPoints has 1s in main

}

