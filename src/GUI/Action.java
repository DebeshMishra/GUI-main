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
	Grid panel;
	
	Action(JMenuItem load, JMenuItem save, JMenuItem exit, Grid panel){
		this.load = load;
		this.save = save;
		this.exit = exit;
		this.panel = panel;
	}
	
    public void actionPerformed (ActionEvent e) {
        if(e.getSource()==exit)
            System.exit(0);
        if(e.getSource()==save) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                PrintWriter fileOut = null;
                File file = fileChooser.getSelectedFile();
                String filename = fileChooser.getSelectedFile().toString();
                if (!filename.endsWith(".txt")) {
                    file = new File(file.toString() + ".txt");  // append .txt if the file is saved without .txt at the end
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
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt"); //adding a filter to only load .txt files
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
                    	
                    	//storing all the data from .txt file to dotCoordinates and then repainting the canvas
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