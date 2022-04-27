package GUI;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		DBSCAN test = new DBSCAN(10,10, 3, 10);

		JFrame frame = new JFrame("Grid");
		Grid panel = new Grid();
		panel.setBorder(BorderFactory.createEmptyBorder(720,720,0,0));
		panel.setLayout(new GridLayout(0,1));

		frame.add(panel, BorderLayout.CENTER);

		JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu file = new JMenu("File");
        menubar.add(file);
        JMenuItem load = new JMenuItem("Load");
        file.add(load);
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);

        class exitAction implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        }
        
        exit.addActionListener(new exitAction());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Grid");
		frame.pack();
		frame.setVisible(true);
	}

}

