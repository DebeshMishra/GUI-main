package GUI;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


public class GUI {
	
	public GUI(){
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Run");
//		button.addActionListener((ActionListener) this);
		
//		JLabel label =  new JLabel("dummy");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(420,420,10,30));
		panel.setLayout(new GridLayout(0,1));
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Dummy GUI");
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args)
	{
		System.out.print("dummy");
		new GUI();

		
	}

}

