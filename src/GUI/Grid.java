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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Grid extends JPanel {

	private static final int MAX_DOTS = 100;
	private static final int DOT_DIAMETER = 5;

	private static ArrayList<Dot> dotsList = new ArrayList<>();
	
	private static final int[][] xyPoints = new int[720][720];

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
		
		//this code works and am currently running test
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

        class action implements ActionListener {
            public void actionPerformed (ActionEvent e) {
            	if(e.getSource()==exit)
            		System.exit(0);
            	if(e.getSource()==save) {
            		JFileChooser fileChooser = new JFileChooser();
            		int response = fileChooser.showSaveDialog(null);
            		   
            		if(response == JFileChooser.APPROVE_OPTION) {
            		    File file;
            		    PrintWriter fileOut = null;
            		    
            		    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            		    try {
            		    	fileOut = new PrintWriter(file);
            		        
            		        String saveStr = new String();
            		        
            		        for(int[] a: xyPoints) {
            		        	saveStr +=a[0]+","+a[1]+"\n";
            		        }
            		    	
            		    	fileOut.println(saveStr);
            		    } 
            		    catch (FileNotFoundException e1) {
            		    	// TODO Auto-generated catch block
            		    	e1.printStackTrace();
            		    }
            		    finally {
            		    	fileOut.close();
            		    } 
            		}
            	}
            	if(e.getSource()==load) {
            		JFileChooser fileChooser = new JFileChooser();
            		fileChooser.setCurrentDirectory(new File("."));
            		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            		fileChooser.setFileFilter(filter);
            		   
            		int response = fileChooser.showOpenDialog(null);
            		   
            		if(response == JFileChooser.APPROVE_OPTION) {
            		    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            		    Scanner fileIn = null;
            		    
            		    try {
            		    	fileIn = new Scanner(file);
            		    	if(file.isFile()) {
            		    		while(fileIn.hasNextLine()) {
            		    			String line = fileIn.nextLine()+"\n";
            		    			//textArea.append(line);
            		    		}
            		    	}
            		    } catch (FileNotFoundException e1) {
            		     // TODO Auto-generated catch block
            		    	e1.printStackTrace();
            		    }
            		    finally {
            		    	fileIn.close();
            		    }
            		}
            	}
            }
        }
        
        exit.addActionListener(new action());
        save.addActionListener(new action());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Grid");
		frame.pack();
		frame.setVisible(true);
	}

}

