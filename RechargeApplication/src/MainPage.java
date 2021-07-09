import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class MainPage extends JFrame implements ActionListener
{
	JPanel pnl,p1,p2,p3,p4,p5;
	JButton brecharge,blogout,baddmoney,bsendmoney;
	JLabel lbl,limg,lbal,lbl1;
	JFrame frm;
	int bal=3000;
	int addmoney;


	public MainPage(int balo)
	{
		bal=balo;
		
		frm=new JFrame("Linkcode");
		frm.setSize(900,500);
		frm.setVisible(true);
		
		p1=new JPanel();
		p1.setBackground(Color.BLACK);
		String str=Integer.toString(bal);
		lbal=new JLabel(str);
		Font f1=new Font("Times New Roman",Font.BOLD+Font.ITALIC,100);
		lbl=new JLabel("Balance - ");
		lbal.setForeground(Color.WHITE);
		lbl.setForeground(Color.WHITE);
		lbl.setFont(f1);
		lbal.setFont(f1);
		
		BorderLayout b1=new BorderLayout();
		frm.setLayout(b1);
		frm.add(BorderLayout.CENTER,p1);
		
		p1.add(lbl);
		p1.add(lbal);
		
		p2=new JPanel();
		p2.setBackground(Color.RED);
		//p2.setForeground(Color.red);
		Font f2=new Font("Times New Roman",Font.BOLD+Font.ITALIC,70);
		lbl1=new JLabel("Welcome To My Recharge..");
		
		p2.add(lbl1);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(f2);
		frm.add(BorderLayout.NORTH,p2);

		
		
		p4=new JPanel();
		p4.setLayout(new GridLayout(4,1,0,20));
		p4.setBackground(Color.black);
		frm.add(BorderLayout.WEST,p4);
	

		p5=new JPanel();
		limg = new JLabel(new ImageIcon("C:/Users/HP/Desktop/Images/Project3.jpg"));
		
		p5.add(limg);
		frm.add(BorderLayout.EAST,p5);
		
		brecharge=new JButton("Recharge");
		bsendmoney=new JButton("Send Money");
		baddmoney=new JButton("Add Money");
		blogout=new JButton("Logout");
			
		
		p4.add(brecharge);
		p4.add(bsendmoney);
		p4.add(baddmoney);
		p4.add(blogout);
		
		
		brecharge.addActionListener(this);
		bsendmoney.addActionListener(this);
		baddmoney.addActionListener(this);
		blogout.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==brecharge)
		{
			Recharge r=new Recharge(bal);
			frm.dispose();
		}
		
		
		if(e.getSource()==blogout)
		{
			new Home();
			frm.dispose();
		}
		
		if(e.getSource()==bsendmoney)
		{
			new SendMoney(bal);
			frm.dispose();
		}
		
		if(e.getSource()==baddmoney)
		{
			new Addmoney(bal);
			frm.dispose();
		}
	}
	
	public static void main(String args[]) 
	{
		new MainPage(1000);
	}

}
