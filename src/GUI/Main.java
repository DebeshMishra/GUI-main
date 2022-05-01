package GUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        //this code works and am currently running test
        //DBSCAN test = new DBSCAN(10, 10, 3, 10);

        JFrame frame = new JFrame("Grid");
        Grid panel = new Grid();
        panel.setBorder(BorderFactory.createEmptyBorder(720, 720, 0, 0));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        
        //adding the menu bar and corresponding items
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
        
        JMenu act = new JMenu("Action");
        menubar.add(act);
        JMenuItem dbScan = new JMenuItem("Run");
        act.add(dbScan);
        JMenuItem randomize = new JMenuItem("Randomize");
        act.add(randomize);
        JMenuItem clear = new JMenuItem("Clear");
        act.add(clear);
        
        //calling the constructor from Action class for actionListener
        Action action = new Action(load, save, exit, randomize, clear, dbScan, panel);

        exit.addActionListener(action);
        save.addActionListener(action);
        load.addActionListener(action);
        randomize.addActionListener(action);
        clear.addActionListener(action);
        dbScan.addActionListener(action);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Grid");
        frame.pack();
        frame.setVisible(true);
    }
}
