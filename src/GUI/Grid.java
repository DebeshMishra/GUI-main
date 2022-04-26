package GUI;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;


public class Grid extends JPanel {

	private static final int MAX_DOTS = 100;
	private static final int DOT_DIAMETER = 5;

	private static ArrayList<Dot> dotsList = new ArrayList<>();

	private static void generateDots(Graphics2D g2){
		for (int i = 0; i < MAX_DOTS; i++){
			Random ran = new Random();
			int x = ran.nextInt(715);
			int y = ran.nextInt(715);

			Ellipse2D ellipse = new Ellipse2D.Double(x, y, DOT_DIAMETER, DOT_DIAMETER);
			Dot dot = new Dot(ellipse);
			dot.fill(g2);
			dotsList.add(dot);
		}
	}
	
	public Grid(){
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// use anti-aliasing to make graphics smooth
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		generateDots(g2);
	}
	
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Grid");
		Grid panel = new Grid();
		panel.setBorder(BorderFactory.createEmptyBorder(720,720,0,0));
		panel.setLayout(new GridLayout(0,1));

		frame.add(panel, BorderLayout.CENTER);
		//Menu menu = new Menu(frame);
		//frame.add(menu);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Grid");
		frame.pack();
		frame.setVisible(true);
	}

}

