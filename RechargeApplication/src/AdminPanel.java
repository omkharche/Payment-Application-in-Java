import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener
{
	JFrame frm;
	JPanel pnl;
	JButton busernames,blogout,bview,btransactionHistory;
	JLabel lbl,limg;
	
	public AdminPanel()
	{
		frm=new JFrame("Admin Panel");
		frm.setSize(600,375);
		frm.setVisible(true);
		
		pnl=new JPanel();
		frm.add(pnl);
		lbl=new JLabel("Admin Panel");
		pnl.add(lbl);
		
		limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img1.jpg"));
		
		Font f=new Font("Times New Roman",Font.BOLD,30);
		lbl.setFont(f);
		lbl.setForeground(Color.RED);
		
		busernames=new JButton("View Usernames");
	
		bview=new JButton("View User Info");
		blogout=new JButton("Logout");
		btransactionHistory=new JButton("Transaction");
		
		
		pnl.add(busernames);
		pnl.add(bview);
		pnl.add(blogout);
		pnl.add(btransactionHistory);
		pnl.add(limg);
		pnl.setLayout(null);
		
		busernames.addActionListener(this);
		bview.addActionListener(this);
		blogout.addActionListener(this);
		btransactionHistory.addActionListener(this);
		limg.setBounds(0,0,600,375);
		lbl.setBounds(240,50,200,50);
		
		busernames.setBounds(150,120,132,35);
		bview.setBounds(320,120,125,35);
		blogout.setBounds(320,180,125,35);
		btransactionHistory.setBounds(150, 180, 125, 35);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==busernames)
		{
			new ViewUserNames();
			frm.dispose();	
		}
	
		if(e.getSource()==bview)
		{
			new ViewUserDetails();
			frm.dispose();	
		}
		if(e.getSource()==btransactionHistory)
		{
			new ViewTransactionHistory();
			frm.dispose();
		}
		
		if(e.getSource()==blogout)
		{
			new Home();
			frm.dispose();
		}
		
	}
	
	public static void main(String args[]) 
	{
		new AdminPanel();
	}
}
