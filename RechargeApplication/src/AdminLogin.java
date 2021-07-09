import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class AdminLogin extends JFrame implements ActionListener
{
		JFrame frm;
		JPanel pnl;
		JButton blogin,bback;
		JTextField tusername;
		JLabel lbl,lusername,lpass,limg;
		JPasswordField tpass;
		
		public AdminLogin()
		{
			frm=new JFrame("Login Page");
			frm.setSize(600,375);
			frm.setVisible(true);
			
			pnl=new JPanel();
			frm.add(pnl);
			pnl.setBackground(Color.white);
			
		
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
				String Uid=tusername.getText();
				String Upass=tpass.getText();
				
				
				if(Uid.equals("Admin")||Upass.equals("1234"))
				{
					
						
						JFrame f;
						f=new JFrame();
						JOptionPane.showMessageDialog(f,"Login Successful");
						new AdminPanel();
						frm.dispose();
					}	
					
					else
					{
						JFrame f;
						f=new JFrame();
						JOptionPane.showMessageDialog(f,"Invalid Username or Password");
					}
				
			}
			if(e.getSource()==bback)
			{
				new Home();
				frm.dispose();	
			}
      }
}
