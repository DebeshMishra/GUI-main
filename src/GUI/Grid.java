package GUI;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Grid extends JPanel {

	private final int MAX_DOTS = 100;
	private final int DOT_DIAMETER = 5;

	private final int GRID_WIDTH = 720;
	private final int GRID_HEIGHT = 720;

	public int[][] xyPoints = new int[GRID_HEIGHT][GRID_WIDTH];
	public ArrayList<int[]> dotCoordinates = new ArrayList<>();

	public void drawDots(Graphics2D g2){
		for (int i = 0; i < dotCoordinates.size(); i++){
			Ellipse2D ellipse = new Ellipse2D.Double(this.dotCoordinates.get(i)[0], this.dotCoordinates.get(i)[1], DOT_DIAMETER, DOT_DIAMETER);
			Dot dot = new Dot(ellipse);
			dot.fill(g2);
		}
	}

	public void addDbScanButton(){
		JButton runButton = new JButton("DdScan");
		runButton.setBounds(10,10,85,20);

		runButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//call DB Scan here
			}
		});
		this.add(runButton);
	}

	public void addRandomizeButton(){
		JButton runButton = new JButton("Randomize");
		runButton.setBounds(500,10,85,20);

		runButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				generateCoordinates();
				repaint();
			}
		});
		this.add(runButton);
	}

	public void generateCoordinates(){
		dotCoordinates = new ArrayList<>();
		for (int i = 0; i < MAX_DOTS; i++){
			Random ran = new Random();
			int x = ran.nextInt(715);
			int y = ran.nextInt(715);

			xyPoints[x][y] = 1;
			dotCoordinates.add(i, new int[]{x,y});
		}
	}

	//TODO: Random button to regenerate pattern after clear or on click
	
	public Grid(){
		super();
		generateCoordinates();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				dotCoordinates.add(new int[]{x,y});
				repaint();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// use anti-aliasing to make graphics smooth
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawDots(g2);
		addDbScanButton();
		addRandomizeButton();
	}


	//TODO: Populate the dots only upon button click

}

