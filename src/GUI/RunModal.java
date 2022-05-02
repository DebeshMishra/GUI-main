package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RunModal extends JDialog {

	JButton btnOK = new JButton("OK");
	JTextField valueField = new JTextField(20);
	int value;
	
	public RunModal(JFrame owner, String title) {
		super(owner,title);
		setBounds(100,100,300,150);
		Container dialogContent = getContentPane();
		dialogContent.setLayout(new FlowLayout());
		
		add(new JLabel("Enter Distance (in pixels):"));
		add(valueField);
		add(btnOK);
		//action listner for the OK button 
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setValue(Integer.parseInt(valueField.getText()));
				RunModal.this.setVisible(false);
			}
		});
	}
	//getters and setters for the value variable 
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
