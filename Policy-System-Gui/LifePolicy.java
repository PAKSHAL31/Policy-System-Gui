import java.awt.*;
import java.awt.event.*;

class LifePolicy extends Frame
{
	double sum,term,age;
	int yearly,monthly,quaterly;
	String [] lpl = { "-","Whole Life Policy","Term Life Policy"};
	String [] tm = { "-","10","20","25","30","35"};
	Label lbltitle = new Label("       Life Policy         ");
	Label lbl1 = new Label("A term inurance provides death risk cover for a specified period. In case the life assured passes");
	Label lbl6 = new Label("away during the policy period, the life insurance company pays the death benefit to the nominee.");
	Label lbl2 = new Label("Age :");
	Label lbl3 = new Label("Choose Your Plan :");
	Label lbl4 = new Label("Term :");
	Label lbl5 = new Label("Accident Benefit :");
	Choice chchoose = new Choice();
	TextField txtage=new TextField();
	Choice chterm = new Choice();
	CheckboxGroup grp = new CheckboxGroup();
	Checkbox chkyes = new Checkbox("Yes",false, grp);
	Checkbox chkno = new Checkbox("NO" ,false, grp);
	Button btnsubmit =new Button("Submit");
	Button btnback=new Button("Back");
	Label lblmsgy = new Label("");
	Label lblmsgm = new Label("");
	Label lblmsgq = new Label("");
	Color bk = new Color(255,234,235);
	Color text= new Color(47,60,126);
	Label bg = new Label();
	
	LifePolicy()
	{
		super("Life Policy");
		setLayout(null);
		
		bg.setBackground(bk);
		lbltitle.setBackground(bk);
		lbltitle.setForeground(text);
		lbl1.setBackground(bk);
		lbl1.setForeground(text);
		lbl6.setBackground(bk);
		lbl6.setForeground(text);
		lbl2.setBackground(bk);
		lbl2.setForeground(text);
		lbl4.setBackground(bk);
		lbl4.setForeground(text);
		lbl3.setBackground(bk);
		lbl3.setForeground(text);
		lbl5.setBackground(bk);
		lbl5.setForeground(text);
		lblmsgm.setBackground(bk);
		lblmsgm.setForeground(text);
		lblmsgq.setBackground(bk);
		lblmsgq.setForeground(text);
		lblmsgy.setBackground(bk);
		lblmsgy.setForeground(text);
		chkyes.setBackground(bk);
		chkno.setBackground(bk);
		chchoose.setForeground(new Color(60,26,75));
		chterm.setForeground(new Color(60,26,75));
		btnback.setForeground(bk);
		btnsubmit.setForeground(bk);
		btnback.setBackground(text);
		btnsubmit.setBackground(text);
		
		Font f = new Font("Arial", Font.BOLD, 100);
		Font g = new Font("Arial", Font.BOLD, 30);
		Font h = new Font("Arial", Font.BOLD, 18);
		
		bg.setBounds(0,200,1000,800);
		lbltitle.setBounds(0,0,1000,200);
		lbl1.setBounds(30,220,940,40);
		lbl6.setBounds(30,270,940,40);
		lbl2.setBounds(30,350,200,80);
		lbl5.setBounds(30,450,200,80);
		lbl3.setBounds(30,550,200,80);
		lbl4.setBounds(30,650,200,80);
		txtage.setBounds(280,350,100,70);
		chkyes.setBounds(280,450, 100, 70 );
		chkno.setBounds(400, 450, 100, 70 );
		chchoose.setBounds(280, 570, 250, 60 );
		chterm.setBounds( 280, 670, 250, 60 );
		btnsubmit.setBounds(80,800,150,80);
		btnback.setBounds(300,800,150,80);
		lblmsgm.setBounds(600,350,400,100);
		lblmsgq.setBounds(600,450,400,100);
		lblmsgy.setBounds(600,550,400,100); 
		
		lbltitle.setFont( f );
		lblmsgy.setFont( g);
		lblmsgm.setFont( g);
		lblmsgq.setFont( g);
		lbl1.setFont(h);
		lbl6.setFont(h);
		lbl2.setFont(g);
		lbl3.setFont(h);
		lbl4.setFont(g);
		lbl5.setFont(h);
		txtage.setFont(g);
		btnback.setFont(g);
		btnsubmit.setFont(g);
		chchoose.setFont(h);
		chterm.setFont(h);
		chkyes.setFont(h);
		chkno.setFont(h);
		
		add(lbl1);
		add(lbl6);
		add(lbl2);
		add(lbl3);
		add(lbl5);
		add(lblmsgy);
		add(lblmsgq);
		add(lblmsgm);
		add(lbltitle);
		add(chkyes);
		add(chkno);
		add(chchoose);
		add(txtage);
		add(btnback);
		add(btnsubmit);
		add(lbl4);
		add(chterm);
		add(bg);
		
		btnback.setEnabled(false);
		btnsubmit.setEnabled(false);
		lbl4.setEnabled(false);
		chterm.setEnabled(false);
		
		addWindowListener(new Win());
		
		for(int i=0;i<lpl.length;i++)
			chchoose.add(lpl[i]);
		
		chchoose.addItemListener( new ListListener() );
		BtnListener x=new BtnListener();
		btnsubmit.addActionListener(x);
		btnback.addActionListener(x);
		
		setSize(1000,1000);
		setVisible(true);
	}
	
	class ListListener implements ItemListener
	{
		public void itemStateChanged( ItemEvent ie)
		{
			String c=chchoose.getSelectedItem();
			chterm.removeAll();
			if (c.equals("Term Life Policy"))
			{
				btnback.setEnabled(true);
				btnsubmit.setEnabled(true);
				lbl4.setEnabled(true);
				chterm.setEnabled(true);
				for(int i=0;i<tm.length;i++)
				{
					chterm.add(tm[i]);
				}
			}
			else if (c.equals("Whole Life Policy"))
			{
				lbl4.setEnabled(false);
				chterm.setEnabled(false);
				btnback.setEnabled(true);
				btnsubmit.setEnabled(true);
			}
		}
	}
	
	
	class BtnListener  implements ActionListener
	{
		public void actionPerformed( ActionEvent ae )
		{
			String btn = ae.getActionCommand();
			String co=chchoose.getSelectedItem();
			age=Double.parseDouble(txtage.getText());
			if(btn.equals("Submit"))
			{
				if(co.equals("Term Life Policy"))
				{
					String t=chterm.getSelectedItem();
					term=Double.parseDouble(t);
					sum=50000*term;
					if( chkyes.getState())
					{
						yearly=(int)((sum*0.998)/(term));
						monthly=(int)((sum*1.02)/(term*12));
						quaterly=(int)((sum*1.02)/(term*3));
					}
					else if(chkno.getState())
					{
						yearly=(int)((sum*1.02)/(term));
						monthly=(int)((sum*1.1)/(term*12));
						quaterly=(int)((sum*1.1)/(term*3));
					}
					lblmsgm.setText("Monthly: "+monthly+"/-");
					lblmsgq.setText("Quaterly: "+quaterly+"/-");
					lblmsgy.setText("Yearly: "+yearly+"/-");
				}
				else if(co.equals("Whole Life Policy"))
				{
					term=80-age;
					sum=30000*term;
					if( chkyes.getState())
					{
						yearly=(int)((sum*0.998)/(term));
						monthly=(int)((sum*1.02)/(term*12));
						quaterly=(int)((sum*1.02)/(term*3));
					}
					else if(chkno.getState())
					{
						yearly=(int)((sum*1.02)/(term));
						monthly=(int)((sum*1.1)/(term*12));
						quaterly=(int)((sum*1.1)/(term*3));
					}
					lblmsgm.setText("Monthly: "+monthly+"/-");
					lblmsgq.setText("Quaterly: "+quaterly+"/-");
					lblmsgy.setText("Yearly: "+yearly+"/-");
				}
				
			}
			else if(btn.equals("Back"))
			{
				Mainform m=new Mainform(); 
				dispose();
			}
		}
	}
	
	class Win extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		LifePolicy l=new LifePolicy(); 
	}
}
