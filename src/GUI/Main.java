package GUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        //this code works and am currently running test
        DBSCAN test = new DBSCAN(10, 10, 3, 10);

        JFrame frame = new JFrame("Grid");
        Grid panel = new Grid();
        panel.setBorder(BorderFactory.createEmptyBorder(720, 720, 0, 0));
        panel.setLayout(new GridLayout(0, 1));

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

        exit.addActionListener(new Action());
        save.addActionListener(new Action());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Grid");
        frame.pack();
        frame.setVisible(true);
//        final int[] count = {0};
//
//        for (int i = 0; i < 720; i++){
//            for (int j = 0; j < 720; j++){
//                if (panel.xyPoints[i][j] == 1){
//                    count[0]++;
//                }
//            }
//        }
//        System.out.println(count[0]);
        }
    }
