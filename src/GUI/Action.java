package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Action implements ActionListener {
	
	//global variables to be used
	JMenuItem load;
	JMenuItem save;
	JMenuItem exit;
	JMenuItem randomize;
	JMenuItem clear;
	JMenuItem dbScan;
	Grid panel;
	JFrame frame;
	
	Action(JMenuItem load, JMenuItem save, JMenuItem exit, JMenuItem randomize, JMenuItem clear, JMenuItem dbScan, Grid panel, JFrame frame){
		this.load = load;
		this.save = save;
		this.exit = exit;
		this.panel = panel;
		this.randomize = randomize;
		this.clear = clear;
		this.dbScan = dbScan;
		this.frame = frame;
	}
	
    public void actionPerformed (ActionEvent e) {
        if(e.getSource()==exit)
            System.exit(0);
        if(e.getSource()==randomize) {
        	panel.generateCoordinates();
			panel.repaint();
        }
        if(e.getSource()==clear) {
        	panel.dotCoordinates = new ArrayList<>();
			panel.repaint();
        }
        if(e.getSource()==dbScan) {
        	RunModal modal = new RunModal(frame,"Distance");
        	modal.setModal(true);
        	modal.setVisible(true);
        	System.out.println("Distance entered "+modal.getValue());
        }
        if(e.getSource()==save) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                PrintWriter fileOut = null;
                File file = fileChooser.getSelectedFile();
                String filename = fileChooser.getSelectedFile().toString();
                if (!filename.endsWith(".dhmj")) {
                    file = new File(file.toString() + ".dhmj");  // append .dhmj if the file is saved without .dhmj at the end
                }
                try {
                    fileOut = new PrintWriter(file);
                    String saveStr = new String();
                    
                    //saving the coordinates of the dots to a text file
                    for(int[] a: panel.dotCoordinates) {
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
            FileNameExtensionFilter filter = new FileNameExtensionFilter("DHMJ files", "dhmj"); //adding a filter to only load .dhmj files
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()) {
                    	//if the file is valid, clean up the existing dotCoordinates
                    	panel.dotCoordinates = new ArrayList<>();
                    	
                    	//storing all the data from .dhmj file to dotCoordinates and then repainting the canvas
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine();
                            if(line!="") {
                            	String[] splitLine = line.split(",");
                            	panel.dotCoordinates.add(new int[] {Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1])});
                            	panel.repaint();
                            }
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