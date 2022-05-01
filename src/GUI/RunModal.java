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
		setBounds(100,100,300,100);
		Container dialogContent = getContentPane();
		dialogContent.setLayout(new FlowLayout());
		
		add(new JLabel("Enter Distance:"));
		add(valueField);
		add(btnOK);
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setValue(Integer.parseInt(valueField.getText()));
				RunModal.this.setVisible(false);
			}
		});
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
