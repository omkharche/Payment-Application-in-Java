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

public class ViewUserDetails extends JFrame implements ActionListener 
{

			JFrame frm;
			JPanel pnl;
			JButton bviewrecord,bback;
			JLabel lbl,limg;
			JTextArea textarea;
			JTextField username1;
			JLabel l;
			
			public ViewUserDetails()
			{
				frm=new JFrame("View User Details");
				frm.setSize(850,650);
				frm.setVisible(true);
				
				pnl=new JPanel();
				frm.add(pnl);
				lbl=new JLabel("View User Details");
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
				
				bviewrecord=new JButton("View User Details");
				bback=new JButton("Back");
				limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img2.jpg"));
		
			    textarea = new JTextArea();
			    textarea.setFont(new Font("Times New Roman", Font.BOLD,30));
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
				
				
				
				lbl.setBounds(270,10,250,50);
				bviewrecord.setBounds(220,485,150,35);
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
						
				PreparedStatement st = connection.prepareStatement("Select * from Registration1 where username=?");

				st.setString(1,username2);
					
				ResultSet rs = st.executeQuery(); 
							
						
				if (rs.next()) 
				{
						
						String s1 = "User Name : "+rs.getString(1)+"\n";
						String s3 = "User Gender : "+rs.getString(5)+"\n";
						String s4 = "User State : "+rs.getString(6)+"\n";
						String s5 = "User City : "+rs.getString(7)+"\n";
							
							
						int s2 = rs.getInt(4);
							  
						String s="User Mobile No : "+String.valueOf(s2)+"\n";
						
						textarea.setText(s1+s+s3+s4+s5);
						
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

