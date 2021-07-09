import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class Recharge extends JFrame implements ActionListener
{
	
	JPanel p1;
	JFrame frm;
	JLabel lmno,lservice,lamount,limg,lbl,lusername;
	JTextField tmno,tamount,ttemp,tbal1,tusername; 
	Choice cservice;
	JButton brecharge,bback;
	int error=0;

	int bal1;
	public Recharge(int balt)
	{
		bal1=balt;
		
		frm=new JFrame("Recharge");
		frm.setSize(600,375);
		frm.setVisible(true);
		
		p1=new JPanel();
		frm.add(p1);
		p1.setBackground(Color.WHITE);
		
		lbl=new JLabel("Recharge");
		lbl.setForeground(Color.RED);
		Font f2= new Font("Times New Roman",Font.BOLD,35);
		limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img1.jpg"));
		lbl.setFont(f2);
		

		Font f1=new Font("Arial Rounded MT BOLD",Font.BOLD,15);
		lusername=new JLabel("Username");
		lmno=new JLabel("MobileNo");
		lservice=new JLabel("Service");
		lamount=new JLabel("Amount");
	
		

		tusername = new JTextField(10);
		tmno=new JTextField(10);
		cservice=new Choice();
		cservice.add("Idea");
		cservice.add("Jio");
		cservice.add("Airtel");
		tamount=new JTextField(10);
		ttemp=new JTextField(10);
		tbal1=new JTextField(10);
		
		String ans=Integer.toString(bal1);
		ttemp.setText(ans);
		
		brecharge=new JButton("Recharge");
		bback=new JButton("Back");
		
		lusername.setForeground(Color.white);
		lmno.setForeground(Color.white);
		lservice.setForeground(Color.white);
		lamount.setForeground(Color.white);
		
		lusername.setFont(f1);
		lmno.setFont(f1);
		lservice.setFont(f1);
		lamount.setFont(f1);
		
		p1.add(lbl);
		p1.add(lusername);
		p1.add(tusername);
		p1.add(lmno);
		p1.add(tmno);
		p1.add(lservice);
		p1.add(cservice);
		p1.add(lamount);
		p1.add(tamount);
		p1.add(brecharge);
		p1.add(bback);
		p1.add(limg);
	
		
		p1.setLayout(null);
		lbl.setBounds(240,20,200,60);
		

		lusername.setBounds(210,90,100,35);
		tusername.setBounds(320,90,100,35);
		
		lmno.setBounds(210,130,100,35);
		tmno.setBounds(320,130,100,35);
		
		lservice.setBounds(210,170,100,35);
		cservice.setBounds(320,170,100,35);
		
		lamount.setBounds(210,200,100,35);
		tamount.setBounds(320,200,100,35);
		
		brecharge.setBounds(200,250,100,35);
		bback.setBounds(330,250,100,35);
		limg.setBounds(0,0,600,375);
		
		brecharge.addActionListener(this);
		bback.addActionListener(this);
	}
	
	public static void main(String args[])
	{
		new MainPage(1000);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==brecharge)
		{
			int n1,n2,n3,sub; 
			
			String ans; 
			
			error=0;
			
			String str1 = tmno.getText();
			char chararray1[] = str1.toCharArray();
			if(chararray1.length==10)
			{		
				for( int i=0;i<chararray1.length;i++)
				{	
					char ch = chararray1[i];
					if(!(ch>='0'&&ch<='9'))
					{
						error=1;	
						System.out.println("1");
					}

				}
			}
			else
			{
				error=1;
			}
			
			String str3 = tamount.getText();
			char chararray3[] = str3.toCharArray();		
			for( int i=0;i<chararray3.length;i++)
			{	
				char ch = chararray3[i];
				if(!(ch>='0'&&ch<='9'))
				{
					error=2;	
				}

			}
			
			if(!(tamount.getText().isEmpty()||tmno.getText().isEmpty()||tusername.getText().isEmpty()))
			{
				if(!(error==1))
				{
					if(!(error==2))
					{
						String s1=ttemp.getText();
						String s2=tamount.getText();
					    n1=Integer.parseInt(s1);
						n2=Integer.parseInt(s2);
					
						if(n1>=n2)
						{
						
						
							String s5=tmno.getText();
							n3=Integer.parseInt(s5);	
							
							String service_n;
							service_n = (String) cservice.getSelectedItem();
							
							String s4=tusername.getText();
							
							sub=n1-n2;
							ans=Integer.toString(sub);
							tbal1.setText(ans);
							
							try 
							{
								Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ORACLEDB1","123456");
								
								PreparedStatement st = connection.prepareStatement("insert into RECHARGE1 (username,mobileno,service,amount)  VALUES  (? ,? ,? ,?)");
				
								st.setString(1, s4);
								st.setInt(2,n3);
								st.setString(3,service_n );
								st.setInt(4, n2);
								
								ResultSet rs = st.executeQuery(); 
								
								if (rs.next()) 
								{
									JFrame f;
									f=new JFrame();
									JOptionPane.showMessageDialog(f,"Recharge done successfully");
								
									MainPage b1=new MainPage(sub);
									frm.dispose();
								} 
								
								else 
								{
									JFrame f;
									f=new JFrame();
									JOptionPane.showMessageDialog(f,"!!! Recharge Failed !!!");
								}
							}
							
							catch(SQLIntegrityConstraintViolationException s)
							{
								JFrame f;
								f=new JFrame();
								JOptionPane.showMessageDialog(f,"!!! Invalid Username !!!");				
							}
							
							catch (SQLException sqlException) 
							{
								sqlException.printStackTrace();	
							}
						}
						else
						{
							JFrame f;
								f=new JFrame();
							JOptionPane.showMessageDialog(f,"!!! Insufficient Balance !!!");
						}
					}
					else
					{
						JFrame f;
						f=new JFrame();
						JOptionPane.showMessageDialog(f,"!!! Invalid Amount !!!");
					}
				}
				
				else
				{
					JFrame f;
					f=new JFrame();
					JOptionPane.showMessageDialog(f,"!!! Invalid mobile Number !!!");
				}
			}
			else
			{
				JFrame f;
				f=new JFrame();
				JOptionPane.showMessageDialog(f,"!!! All Fields are Compulsary !!!");
			}
			
		}
		
		if(e.getSource()==bback)
		{
			new MainPage(bal1);
			frm.dispose();
		}	
	}
}
