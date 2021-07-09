import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
	JFrame frm;
	JPanel pnl;
	JButton blogin,bregister,bexit,badmin;
	JLabel lbl,limg;
	
	public Home()
	{	
		frm=new JFrame("Home");
		frm.setSize(600,375);
		frm.setVisible(true);
		
		pnl=new JPanel();
		frm.add(pnl);
		lbl=new JLabel("Home Screen");
		pnl.add(lbl);
		
		limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img1.jpg"));
		
		Font f=new Font("Times New Roman",Font.BOLD,30);
		lbl.setFont(f);
		lbl.setForeground(Color.RED);
		
		blogin=new JButton("Login");
		bregister=new JButton("Register");
		badmin=new JButton("Admin Login");
		bexit=new JButton("Exit");
		
		
		pnl.add(blogin);
		pnl.add(bregister);
		pnl.add(badmin);
		pnl.add(bexit);
		pnl.add(limg);
		pnl.setLayout(null);
		
		blogin.addActionListener(this);
		bregister.addActionListener(this);
		badmin.addActionListener(this);
		bexit.addActionListener(this);
		
		limg.setBounds(0,0,600,375);
		lbl.setBounds(210,50,200,50);
		
		blogin.setBounds(130,120,90,35);
		bregister.setBounds(245,120,90,35);
		badmin.setBounds(350,120,105,35);
		bexit.setBounds(245,180,100,35);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==blogin)
		{
			new Login();
			frm.dispose();	
		}
		
		if(e.getSource()==bregister)
		{
			new Registration();
			frm.dispose();	
		}
		
		if(e.getSource()==badmin)
		{
			new AdminLogin();
			frm.dispose();	
		}
		
		
		if(e.getSource()==bexit)
		{
			frm.dispose();
		}
	}
	
	public static void main(String args[]) 
	{
		new Home();
	}
}
