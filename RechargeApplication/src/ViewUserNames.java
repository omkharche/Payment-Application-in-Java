import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class ViewUserNames extends JFrame implements ActionListener 
{

			JFrame frm;
			JPanel pnl;
			JButton bviewrecord,bback;
			JLabel lbl,limg;
			JTextArea a;
			JTextField opt;
			JLabel l;
			int i;
			
			public ViewUserNames()
			{
				frm=new JFrame("View Usernames");
				frm.setSize(850,650);
				frm.setVisible(true);
				
				pnl=new JPanel();
				frm.add(pnl);
				lbl=new JLabel("View Usernames");
				pnl.add(lbl);
				
				limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img2.jpg"));
				
				
				Font f=new Font("Times New Roman",Font.BOLD,30);
				lbl.setFont(f);
				lbl.setForeground(Color.RED);
				
				bviewrecord=new JButton("View Usernames");
				bback=new JButton("Back");
		
		
			    a = new JTextArea();
				a.setFont(new Font("Times New Roman", Font.BOLD,30));
				a.setForeground(Color.black);
				a.setSize(400, 300);
				a.setLocation(220,140);
				a.setLineWrap(true);
				a.setEditable(false);
		
				pnl.add(a);
		
				pnl.add(bviewrecord);
				pnl.add(bback);
				pnl.add(lbl);		
				pnl.add(limg);

				pnl.setLayout(null);
				
				bviewrecord.addActionListener(this);
				bback.addActionListener(this);
				
				lbl.setBounds(290,10,250,50);
				bviewrecord.setBounds(230,485,150,35);
				bback.setBounds(390,485,120,35);
				limg.setBounds(0, 0, 850, 650);
}
			
public void actionPerformed(ActionEvent e) 
{
		if(e.getSource()==bviewrecord)
		{
					
			String s1 = null;
			String s2 ="List of UserNames";
	 
					
			try 
			{
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ORACLEDB1","123456");
				
					PreparedStatement st = connection.prepareStatement("Select username from Registration1");
					    
					ResultSet rs = st.executeQuery(); 
							
					ResultSetMetaData rsmd=rs.getMetaData();
						
					int colCount=rsmd.getColumnCount();
						
					while(rs.next())
					{
						for(int i=0;i<=colCount;i++)
						{
							System.out.println(s1 = rs.getString(1));
						}
									    
						s2=s2+"\n"+s1;	
					}
									  
									  
							 
					a.setText(s2);
						 
				    JFrame f;
					f=new JFrame();
					JOptionPane.showMessageDialog(f,"!!! Record Fetched !!!");
			}
					
			
			catch(Exception e1)
			{
					JFrame f;
					f=new JFrame();
					JOptionPane.showMessageDialog(f,"!!! No Record Founds !!!");
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
			new AdminPanel();
	}
}

