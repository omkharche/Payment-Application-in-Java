
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.awt.color.*;

public class Registration extends JFrame implements ActionListener
{
	  ResultSet rs=null;
      Connection con=null;
      Statement stmt=null;
      
	JFrame frm;
	JPanel pnl;
	JLabel lgender,lname,lmno,lunm,llnm,lpass,lcpass,lcity,lemail,lmobile;
	JLabel lstate,lbl,laddr;
	JTextField taddr,tmno,tunm,tlnm,tname,temail,tgender;
	JPasswordField tpass,tcpass;
	
	
	
	JComboBox ccity,cststate;
	
	
	//JList lststate;
	JButton bregister,bback;
	JLabel limg;
	int error=0;

	String gen,city_n,state_n;
	JRadioButton r1=new JRadioButton("Male");
	JRadioButton r2=new JRadioButton("Female");
	ButtonGroup bg=new ButtonGroup();
	
	public Registration()
	{
		//super("Login Page");
		frm=new JFrame("Linkcode");
		frm.setSize(600,413);
		frm.setVisible(true);
		
		pnl=new JPanel();
		frm.add(pnl);
		pnl.setBackground(Color.WHITE);
		
		lbl=new JLabel("Registration");
		lbl.setForeground(Color.RED);
		Font f2= new Font("TimesNewRoman",Font.BOLD,30);
		limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img1.jpg"));
		lbl.setFont(f2);
		
		Font f= new Font("Arial Rounded MT BOLD",Font.BOLD+Font.ITALIC,15);
		
		lname = new JLabel("Name");
		lemail=new JLabel("Email");
		lmno=new JLabel("Mobile No");
		lunm=new JLabel("User Name");
		lpass=new JLabel("Password");
		lgender=new JLabel("Gender");
		laddr=new JLabel("Address");
		lcity=new JLabel("City");
		
		tname=new JTextField(10);
		temail=new JTextField(10);
		tmno=new JTextField(10);
		tunm=new JTextField(10);
		tpass=new JPasswordField(10);
		taddr=new JTextField(10);
		
		String ct[]= {"Mumbai","Pune","Nashik","Nagpur","Satra","Surat","Jalgoan","Shirdi","Kolhapur","Buldhana","Dhule","Nagar","Hyderabad","Bangalore","Ahmedabad","Kolkata","Jaipur","Lucknow","Kanpur","Bhilai","Agra","Rajkot","Amritsar","Aurangabad"};	
		ccity=new JComboBox(ct);
		
		lstate=new JLabel("State");
		String st[]= {"Maharashtra","Punjab","Tamilnadu","Haryana","Karnataka","Telangana","West Bengal","Rajasthan","Bihar","Haryana","Jharkhand","Assam","Chandigarh","Chhattisgarh","Jammu and Kashmir","Tripura","Odisha"};	
	    
		cststate=new JComboBox(st);
		
		lname.setForeground(Color.white);
		lmno.setForeground(Color.white);
		lemail.setForeground(Color.white);
		lpass.setForeground(Color.white);
		lunm.setForeground(Color.white);
		lgender.setForeground(Color.white);
		laddr.setForeground(Color.white);
		lcity.setForeground(Color.white);
		lstate.setForeground(Color.white);
		
		lname.setFont(f);
		lmno.setFont(f);
		lemail.setFont(f);
		lunm.setFont(f);
		lpass.setFont(f);
		lgender.setFont(f);
		laddr.setFont(f);
		lcity.setFont(f);
		lstate.setFont(f);
		
		bregister=new JButton("Register");
		bback=new JButton("Back");
		
		pnl.add(lbl);
		pnl.add(lname);
		pnl.add(lunm);
		pnl.add(lpass);
		pnl.add(lmno);
		pnl.add(lemail);
		pnl.add(lgender);
		pnl.add(laddr);
		pnl.add(lcity);
		pnl.add(lstate);
		
		pnl.add(tname);
		pnl.add(tunm);
		pnl.add(tpass);
		pnl.add(tmno);
		pnl.add(temail);
		pnl.add(taddr);
	
		pnl.add(ccity);
		pnl.add(cststate);
		pnl.add(r1);
		pnl.add(r2);
		
		pnl.add(bregister);
		pnl.add(bback);
		pnl.add(limg);
		
		pnl.setLayout(null);
		limg.setBounds(0,0,600,375);
		lbl.setBounds(195,10,300,35);
		lname.setBounds(184,55,100,30);
		lunm.setBounds(184,90,100,30);
		lpass.setBounds(184,125,100,30);
		lmno.setBounds(184,160,100,30);
		lgender.setBounds(184,195,100,30);
		laddr.setBounds(184,230,100,30);
		lcity.setBounds(184,265,100,30);
		lstate.setBounds(184,300,100,30);
		
		tname.setBounds(289,55,100,28);
		tunm.setBounds(289,90,100,28);
		tpass.setBounds(289,125,100,28);
		tmno.setBounds(289,160,100,28);
		r1.setBounds(289,195,55,28);
		r2.setBounds(350,195,70,28);
		taddr.setBounds(289,230,100,28);
		ccity.setBounds(289,265,100,28);
		cststate.setBounds(289,300,100,28);
		
		bregister.setBounds(190,330,90,35);
		bback.setBounds(300,330,90,35);
		
		
		bback.addActionListener(this);
		bregister.addActionListener(this);
	
		dbOpen();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String s1=tname.getText();
		String s2=tunm.getText();
		String s3=tpass.getText();
		String s4=tmno.getText();

		
		city_n = (String) ccity.getSelectedItem();
		
		
		state_n = (String) cststate.getSelectedItem();

	
	
		if(e.getActionCommand()=="Female")
		{
			gen="Female";
		}
		 
		else
		{
			gen="Male";
		}
		
		
		try {
			if(e.getSource()==bregister) {
				
				error=0;
				
				String str = tname.getText();
				char chararray[] = str.toCharArray();
				for( int i=0;i<chararray.length;i++)
				{
					char ch = chararray[i];
					if(!((ch>='a'&&ch<='z')||ch==' '||(ch>='A'&&ch<='Z')))
					{
						error=1;
					}

				}
				
				String str1 = tmno.getText();
				char chararray1[] = str1.toCharArray();
				if(chararray1.length==10)
				{		
					for( int i=0;i<chararray1.length;i++)
					{	
						char ch = chararray1[i];
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
				if(!(tname.getText().isEmpty()||tunm.getText().isEmpty()||tpass.getText().isEmpty()||tmno.getText().isEmpty()||gen.isEmpty()||city_n.isEmpty()||state_n.isEmpty()||taddr.getText().isEmpty()))
				{
					if(error!=1)
					{
						if(error!=2)
						{
							stmt.executeUpdate("INSERT INTO Registration1 VALUES('" + tname.getText() + "','" + tunm.getText() + "','" + tpass.getText() + "','" + tmno.getText() + "','"+ gen+"','"+ state_n+ "','"+city_n+"')");
							
							dbClose();
							dbOpen();
							
							JFrame f;
							f=new JFrame();
							JOptionPane.showMessageDialog(f,"Registration done successfully");
							new Home();
							frm.dispose();
						}
						else {
							JFrame f;
							f=new JFrame();
							JOptionPane.showMessageDialog(f,"Invalid Mobile Number...");
						}
					}
					else{
						JFrame f;
						f=new JFrame();
						JOptionPane.showMessageDialog(f,"Invalid Name...");
					}
				}
				else{
					JFrame f;
					f=new JFrame();
					JOptionPane.showMessageDialog(f,"All Felds are Compulsary");
				}
				
				
			}
		}catch  (SQLIntegrityConstraintViolationException e1) {
			JFrame f;
			f=new JFrame();
			JOptionPane.showMessageDialog(f,"Username Already Exists");
		}
		
		catch  (Exception e2) {
			JFrame f;
			f=new JFrame();
			JOptionPane.showMessageDialog(f,e2);
		
		}
		
		if(e.getSource()==bback)
		{
			new Home();
			frm.dispose();	
			
			
		}
	}
	
	

	public void dbOpen()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ORACLEDB1","123456"); 
		    
			System.out.println("connection..");
			
			
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			rs = stmt.executeQuery("Select * from Registration");
			
			
		}
		
		
		catch(Exception e)
		{}
	
	}
	
	public void dbClose()
	{
		try
		{
			
			stmt.close();
			rs.close();
			con.close();
		}
		
		catch(Exception e)
		{}
	}
	
	
	public void setText()
	{
		try
		{	
			tname.setText(rs.getString(1));
			tunm.setText(rs.getString(2));
			tpass.setText(rs.getString(3));
			tmno.setText(rs.getString(4));
			
		
			rs.getString(6);
			rs.getString(7);
			
			if(rs.getString(5).equals("Male")) 
			{	
				r1.setSelected(true);
			}	
			else
			{
				r2.setSelected(true);
			}
	   }
		
		catch(Exception ex){}		
   }
	public static void main(String args[]) 
	{
		Registration r=new Registration();
	}
	
}
