
/********************************************
	Benz Huynh								
	This is a GUI created 
	based on the password class.	
********************************************/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CryptID implements ActionListener
{
	private JFrame frame;
	private JTextField input = new JTextField();
	private JTextArea output = new JTextArea();
	JButton btn1 = new JButton("Create Password");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					CryptID window = new CryptID();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CryptID() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(5,3));
		frame.getRootPane().setDefaultButton(btn1);
		
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_1);
		frame.getContentPane().add(panel_2);
		frame.getContentPane().add(panel_3);
		frame.getContentPane().add(panel_4);
		frame.getContentPane().add(panel_5);
		
		JLabel lblUsername = new JLabel("Username:");
		panel_2.add(lblUsername);
		panel_2.add(input);
		input.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panel_3.add(lblPassword);
		panel_3.add(output);
		output.setEditable(false);
		output.setColumns(10);
		btn1.setForeground(Color.DARK_GRAY);
		btn1.setBackground(Color.WHITE);
		
		panel_4.add(btn1);
		btn1.addActionListener(this);
		btn1.setVisible(true);
	}
	
	/**
	 * define the actions
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn1)
		{
			String password = Password.main(input.getText());
			output.setText(password);
		}
	}
}
