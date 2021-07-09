import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener
{
	JFrame frm;
	JPanel pnl;
	JButton blogin,bback;
	JTextField tusername;
	JLabel lbl,lusername,lpass,limg;
	JPasswordField tpass;
	
	public Login()
	{
		frm=new JFrame("Login Page");
		frm.setSize(600,375);
		frm.setVisible(true);
		
		pnl=new JPanel();
		frm.add(pnl);
		pnl.setBackground(Color.white);
		
	//	Font f=new Font("Times New Roman",Font.BOLD,30);
		lbl=new JLabel("Login");
		Font f=new Font("Times New Roman",Font.BOLD,40);
		limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img1.jpg"));
		lbl.setFont(f);
		lbl.setForeground(Color.RED);
		
		Font f1=new Font("Arial Rounded MT Bold",Font.BOLD,15);

		
		lusername=new JLabel("User Name");
		lpass=new JLabel("Password");
		tusername=new JTextField(10);
		tpass=new JPasswordField(10);
		lusername.setForeground(Color.white);
		lpass.setForeground(Color.white);
		lusername.setFont(f1);
		lpass.setFont(f1);
		
		blogin=new JButton("Login");
		bback=new JButton("Back");
			
		pnl.add(lbl);
		pnl.add(lusername);
		pnl.add(tusername);
		
		pnl.add(lpass);
		pnl.add(tpass);
		
		pnl.add(blogin);
		pnl.add(bback);
		pnl.add(limg);
		
		pnl.setLayout(null);
		limg.setBounds(0,0,600,375);
		lbl.setBounds(235,40,200,60);
		
		lusername.setBounds(190,130,100,30);
		tusername.setBounds(295,130,100,35);
		lpass.setBounds(190,180,100,30);
		tpass.setBounds(295,180,100,35);

		blogin.setBounds(187,240,100,45);
		bback.setBounds(305,240,90,45);
		
		blogin.addActionListener(this);
		bback.addActionListener(this);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==blogin)
		{
			String s1=tusername.getText();
			String s2=tpass.getText();
			
			try 
			{
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ORACLEDB1","123456");
				
				PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select username, password from REGISTRATION1 where username=? and password=?");

				st.setString(1, s1);
				st.setString(2, s2);
				
				ResultSet rs = st.executeQuery();
				
				if (rs.next()) 
				{
					JFrame f;
					f=new JFrame();
					JOptionPane.showMessageDialog(f,"Login done successfully");
					new MainPage(1000);
					frm.dispose();	
				} 
				
				else 
				{
					JFrame f;
					f=new JFrame();
					JOptionPane.showMessageDialog(f,"!!! Login Failed !!!");
				}
			} 
			
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
			}

		}
		
		if(e.getSource()==bback)
		{
			new Home();
			frm.dispose();	
		}
		
	}
	
	
	public static void main(String args[]) 
	{
		new Login();
	}
}
