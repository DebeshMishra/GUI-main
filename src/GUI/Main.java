package GUI;

import javax.swing.*;
import java.awt.*;

public class Main {

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
        final int[] count = {0};

        for (int i = 0; i < 720; i++){
            for (int j = 0; j < 720; j++){
                if (panel.gridPoints[i][j] == 1){
                    count[0]++;
                }
            }
        }
        System.out.println(count[0]);
    }
}
