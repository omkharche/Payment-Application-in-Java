import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.color.*;

public class ViewTransactionHistory extends JFrame implements ActionListener 
{

			JFrame frm;
			JPanel pnl;
			JButton bviewrecord,bback;
			JLabel lbl,limg;
			JTextArea textarea;
			JTextField username1;
			JLabel l;
			
			public ViewTransactionHistory()
			{
				frm=new JFrame("View Recharge Transaction");
				frm.setSize(850,650);
				frm.setVisible(true);
				
				pnl=new JPanel();
				frm.add(pnl);
				lbl=new JLabel("View Recharge Transaction");
				pnl.add(lbl);
				
				
				l=new JLabel("Enter name");
				l.setFont(new Font("Times New Roman", Font.BOLD,25));
				l.setForeground(Color.red);
				
				username1=new JTextField();
				username1.setFont(new Font("Times New Roman", Font.BOLD,25));
				username1.setForeground(Color.red);
				
				
				Font f=new Font("Times New Roman",Font.BOLD,30);
				lbl.setFont(f);
				lbl.setForeground(Color.RED);
				
				bviewrecord=new JButton("View Transaction Details");
				bback=new JButton("Back");
				limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img2.jpg"));
		
			    textarea = new JTextArea();
			    textarea.setFont(new Font("Times New Roman", Font.BOLD,22));
			    textarea.setForeground(Color.black);
			    textarea.setSize(400, 300);
			    textarea.setLocation(220,140);
			    textarea.setLineWrap(true);
			    textarea.setEditable(false);
				pnl.add(textarea);
				
				pnl.add(l);
				pnl.add(username1);
				pnl.add(bviewrecord);
				pnl.add(bback);
				pnl.add(lbl);	
				pnl.add(limg);

				pnl.setLayout(null);
				
				bviewrecord.addActionListener(this);
				bback.addActionListener(this);
				
				
				l.setBounds(210,90,150,30);
				username1.setBounds(350,90,150,35);
				
				
				
				lbl.setBounds(220,10,400,50);
				bviewrecord.setBounds(200,485,180,35);
				bback.setBounds(390,485,120,35);
				limg.setBounds(0, 0, 850, 650);
}
			
public void actionPerformed(ActionEvent e) 
{
		if(e.getSource()==bviewrecord)
		{			
			String username2 = username1.getText();
					
			try 
			{
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ORACLEDB1","123456");
						
				PreparedStatement st = connection.prepareStatement("Select * from Recharge1 where username=?");

				st.setString(1,username2);
					
				ResultSet rs = st.executeQuery();
							
						
				if (rs.next()) 
				{
				
						String s2 = "Service : "+rs.getString(3)+"\n";
							
						int s1 = rs.getInt(2);	  
						String s="User Mobile No : "+String.valueOf(s1)+"\n";
						
						int s3 = rs.getInt(4);	  
						String s4="Amount : "+String.valueOf(s3)+"\n";
						
						
						textarea.setText(s+s2+s4);
						
						JFrame f;
						f=new JFrame();
						JOptionPane.showMessageDialog(f,"!!! Record Fetched !!!");
				} 
						
				else 
				{
						JFrame f;
						f=new JFrame();
						JOptionPane.showMessageDialog(f,"!!! No record found!!!");
				}
					
			}
				
			catch(Exception e1)
			{
					System.out.println(e);		
			}
		}
				
		if(e.getSource()==bback)
		{
			new AdminPanel();
			frm.dispose();	
		}
				
	}	
			
	public static void main(String args[]) 
	{
		new ViewUserDetails();
	}
}