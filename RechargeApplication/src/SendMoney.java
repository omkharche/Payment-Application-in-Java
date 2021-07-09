import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SendMoney extends JFrame implements ActionListener
{
	JFrame frm;
	JPanel pnl,p1;
	JButton bsendmoney,bback;
	JLabel laccno,lmno,lamount,lbl,limg,lusername;
	JTextField taccno,tmno,tamount,tbal1,ttemp,tusername;
	int error=0,bal1;
	
	public SendMoney(int balt)
	{
		 bal1=balt;
		
		frm=new JFrame("Linkcode");
		frm.setSize(600,375);
		frm.setVisible(true);
		
		p1=new JPanel();
		frm.add(p1);
		p1.setBackground(Color.WHITE);
		
		lbl=new JLabel("Send Money");
		lbl.setForeground(Color.RED);
		Font f2= new Font("Times New Roman",Font.BOLD,35);
		limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img1.jpg"));
		lbl.setFont(f2);
		
		Font f1=new Font("Arial Rounded MT BOLD",Font.BOLD,15);
		
		lusername=new JLabel("Username");
		tusername=new JTextField(10);
		
		laccno=new JLabel("Account No");
		taccno=new JTextField(10);
		
		lmno=new JLabel("Mobile No");
		tmno=new JTextField(10);
		
		lamount=new JLabel("Amount");
		tamount=new JTextField(10);
		
		ttemp=new JTextField(10);
		tbal1=new JTextField(10);
		
		String ans=Integer.toString(bal1);
		ttemp.setText(ans);
		
		bsendmoney=new JButton("Send Money");
		bback=new JButton("Back");
		
		lusername.setForeground(Color.white);
		laccno.setForeground(Color.white);
		lmno.setForeground(Color.white);
		lamount.setForeground(Color.white);
		
		lusername.setFont(f1);
		laccno.setFont(f1);
		lmno.setFont(f1);
		lamount.setFont(f1);
		
		p1.setLayout(null);
		p1.add(lbl);
		
		p1.add(lusername);
		p1.add(tusername);		
		
		
		p1.add(laccno);
		p1.add(taccno);		
		
		p1.add(lmno);
		p1.add(tmno);
		
		p1.add(lamount);
		p1.add(tamount);
		
		p1.add(bsendmoney);
		p1.add(bback);
		p1.add(limg);
		
		lbl.setBounds(235,20,200,60);
		
		
		lusername.setBounds(210,90,100,35);
		tusername.setBounds(320,90,100,35);
		
		lmno.setBounds(210,130,100,35);
		tmno.setBounds(320,130,100,35);
		
		
		laccno.setBounds(210,170,100,35);
		taccno.setBounds(320,170,100,35);
		
		lamount.setBounds(210,210,100,35);
		tamount.setBounds(320,210,100,35);

		
		bsendmoney.setBounds(200,255,120,35);
		bback.setBounds(330,255,100,35);
		limg.setBounds(0,0,600,375);
		

		bsendmoney.addActionListener(this);
		bback.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==bsendmoney)
		{
			String s3=tusername.getText();
			
			String s5 = tamount.getText();
			String s1=ttemp.getText();
			String s2=tamount.getText();
			
			
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
					}

				}
			}
			else
			{
				error=1;
			}
			String str2 = taccno.getText();
			char chararray2[] = str2.toCharArray();
			if(chararray2.length==5)
			{		
				for( int i=0;i<chararray2.length;i++)
				{	
					char ch = chararray2[i];
					if(!(ch>='0'&&ch<='9'))
					{
						error=2;	
					}

				}
			}
			else
			{
				error=2;
			}
			String str3 = tamount.getText();
			char chararray3[] = str3.toCharArray();		
			for( int i=0;i<chararray3.length;i++)
			{	
				char ch = chararray3[i];
				if(!(ch>='0'&&ch<='9'))
				{
					error=3;	
				}

			}
			
			if(!(tusername.getText().isEmpty()||tamount.getText().isEmpty()||tmno.getText().isEmpty()||taccno.getText().isEmpty())) 
			{
				if(!(error==1))
				{
					if(!(error==2))
					{
						if(!(error==3))
						{
							int n2=Integer.parseInt(s2);
						
							if(n2<5000&&n2>0)
							{	
									int n4=Integer.parseInt(s5);
									int n1=Integer.parseInt(s1);
									
									int sub=n1-n2;
									
									String ans=Integer.toString(sub);
									tbal1.setText(ans);
								
									
									String s4= tmno.getText();
									int n3=Integer.parseInt(s4);
									
									try 
									{
										Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ORACLEDB1","123456");
										
										PreparedStatement st = connection.prepareStatement("insert into SendMoney1 (username,mobileno,accountno,amount)  VALUES  (? ,? ,? ,?)");
						
										st.setString(1,s3);
										st.setInt(2,n3);
										st.setInt(3,n1);
										st.setInt(4,n4);
										
										ResultSet rs = st.executeQuery(); 
										
										if (rs.next()) 
										{
											JFrame f1;
											f1=new JFrame();
											JOptionPane.showMessageDialog(f1,"Money Sent Successfully");
										
											MainPage b1=new MainPage(sub);
											frm.dispose();
										} 
										
										else 
										{
											JFrame f2;
											f2=new JFrame();
											JOptionPane.showMessageDialog(f2,"!!! Recharge Failed !!!");
									     }
									}
									
									catch(SQLIntegrityConstraintViolationException s)
									{
										JFrame f;
										f=new JFrame();
										JOptionPane.showMessageDialog(f,"!!! Invalid Username !!!");
									}
									
									catch (Exception e1) 
									{
										JFrame f;
										f=new JFrame();
										JOptionPane.showMessageDialog(f,e1);
									}
											
								}else
								{
									JFrame f2;
									f2=new JFrame();
									JOptionPane.showMessageDialog(f2,"!!! Amount must be less than 5000 !!!");
								}
							
							}else
							{
								JFrame f2;
								f2=new JFrame();
								JOptionPane.showMessageDialog(f2,"!!! Invalid Amount !!!");
							}
						}else
						{
							JFrame f2;
							f2=new JFrame();
							JOptionPane.showMessageDialog(f2,"!!! Invalid Account Number !!!");
						}
					}else
					{
						JFrame f2;
						f2=new JFrame();
						JOptionPane.showMessageDialog(f2,"!!! invalid Mobile Number !!!");
					}
				}
				else
				{
					JFrame f2;
					f2=new JFrame();
					JOptionPane.showMessageDialog(f2,"!!! All Fields are compulsary !!!");
				}
			}
		
			
			if(e.getSource()==bback)
			{
				new MainPage(bal1);
				frm.dispose();
			}		
		
	}
	
	
	public static void main(String args[]) 
	{
		SendMoney s = new SendMoney(1000);
	}
	
}
