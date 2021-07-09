import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addmoney extends JFrame implements ActionListener
{
	JFrame frm;
	JPanel pnl,p1;
	JButton baddmoney,bback;
	JLabel lupiId,lupipin,lamount,lbl,limg,lusername;
	JTextField tupiId,tupipin,tamount,tbal1,ttemp,tusername;
	int error=0;
	
	int bal1;
	public Addmoney(int balt)
	{
		bal1=balt;
		
		frm=new JFrame("Add Money");
		frm.setSize(600,375);
		frm.setVisible(true);
		
		p1=new JPanel();
		frm.add(p1);
		p1.setBackground(Color.WHITE);
		
		lbl=new JLabel("Add Money");
		lbl.setForeground(Color.RED);
		Font f2= new Font("Times New Roman",Font.BOLD,35);
		limg = new JLabel(new ImageIcon("C://Users//ATE//Downloads/img1.jpg"));
		lbl.setFont(f2);
		
		
		
		Font f1=new Font("Arial Rounded MT BOLD",Font.BOLD,15);
	
		lupiId=new JLabel("Upi Id");
		tupiId=new JTextField(10);
		
		lupipin=new JLabel("Upi Pin");
		tupipin=new JTextField(10);
		
		lamount=new JLabel("Amount");
		tamount=new JTextField(10);
		
		ttemp=new JTextField(10);
		tbal1=new JTextField(10);
		
		String ans=Integer.toString(bal1);
		ttemp.setText(ans);
		
		baddmoney=new JButton("Add Money");
		bback=new JButton("Back");
	
		lupiId.setForeground(Color.white);
		lupipin.setForeground(Color.white);
		lamount.setForeground(Color.white);
		
	
		lupiId.setFont(f1);
		lupipin.setFont(f1);
		lamount.setFont(f1);
		
		p1.setLayout(null);
		p1.add(lbl);
		
		p1.add(lupiId);
		p1.add(tupiId);		
		
		p1.add(lupipin);
		p1.add(tupipin);
		
		p1.add(lamount);
		p1.add(tamount);
		
		p1.add(baddmoney);
		p1.add(bback);
		p1.add(limg);
		
		lbl.setBounds(235,20,200,60);
	
		lupiId.setBounds(210,100,100,35);
		tupiId.setBounds(320,100,100,35);
		
		lupipin.setBounds(210,150,100,35);
		tupipin.setBounds(320,150,100,35);
		
		lamount.setBounds(210,200,100,35);
		tamount.setBounds(320,200,100,35);
		
		baddmoney.setBounds(200,250,120,35);
		bback.setBounds(330,250,100,35);
		limg.setBounds(0,0,600,375);
		

		baddmoney.addActionListener(this);
		bback.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==baddmoney)
		{
			
			String Uid=tupiId.getText();
			String Upass=tupipin.getText();
			
			if(!(tupiId.getText().isEmpty()||tupipin.getText().isEmpty()||tamount.getText().isEmpty()))
			{
			
				if(Uid.equals("1234")&&Upass.equals("1234"))
				{
					error=0;
					String str3 = tamount.getText();
					char chararray3[] = str3.toCharArray();		
					for( int i=0;i<chararray3.length;i++)
					{	
						char ch = chararray3[i];
						if(!(ch>='0'&&ch<='9'))
						{
							error=1;	
						}

					}
					if(!(error==1))
					{
						String s1=ttemp.getText();
						String s2=tamount.getText();
						int n1=Integer.parseInt(s1);
						int n2=Integer.parseInt(s2);
					
						if(n2<5000&&n2>0)
						{
					
							Frame f;
							f=new JFrame();
							JOptionPane.showMessageDialog(f,"Money added successfully!!");
							
							int add=n1+n2;
							String ans=Integer.toString(add);
							tbal1.setText(ans);
							
							MainPage b1=new MainPage(add);
							frm.dispose();
				
						}
						else
						{
							JFrame f;
							f=new JFrame();
							JOptionPane.showMessageDialog(f,"Amount Must be Less than 5000!!");			
						}
					}
					else
					{
						JFrame f;
						f=new JFrame();
						JOptionPane.showMessageDialog(f,"Invalid Amount!!");
					}
				}			
				else		
				{		
					JFrame f;		
					f=new JFrame();			
					JOptionPane.showMessageDialog(f,"Invalid Upi-Id or Upi-Pin");			
				}
			}
			else
			{
				JFrame f;
				f=new JFrame();
				JOptionPane.showMessageDialog(f,"All Fields are Compulsary!!!");
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
		int i = 1000;
		new Addmoney(i);
	}
}
