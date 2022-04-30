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
                File file;
                PrintWriter fileOut = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);

                    String saveStr = new String();

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
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()) {
                    	panel.dotCoordinates = new ArrayList<>();
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine();
                            if(line!="") {
                            	String[] splitLine = line.split(",");
                            	panel.dotCoordinates.add(new int[] {Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1])});
                            	panel.repaint();
                            }
                            	//System.out.println(line);
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