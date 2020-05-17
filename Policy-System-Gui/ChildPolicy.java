import java.awt.*;
import java.awt.event.*;

class ChildPolicy extends Frame
{
	double sum,term,age;
	int yearly,monthly,quaterly;
	Label lbltitle = new Label("       Child Policy          ");
	//String [] tm = { "-","10","20","25","30","35"};
	Label lbl1 = new Label("Plan for your child's bright future with the child education calculator.Calculate ");
	Label lbl6 = new Label("the total education expenses and give your child the best education.");
	Label lbl2 = new Label("Age :");
	Label lbl4 = new Label("Child's Dream :");
	Label bg = new Label();
	String [] field = { "-" , "Engineering", "Medical", "Law", "MBA", "Others" };
	Choice chchoice = new Choice();
	Label lbl3 = new Label("Sum Assured:");
	TextField txtage=new TextField();
	TextField txtsum=new TextField();
	Button btnsubmit =new Button("Submit");
	Button btnback=new Button("Back");
	Label lblmsgy = new Label("");
	Label lblmsgm = new Label("");
	Label lblmsgq = new Label("");
	Color bk = new Color(255,234,235);
	Color text= new Color(47,60,126);
	
	ChildPolicy()
	{
		super("Marriage Policy");
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
		lblmsgm.setBackground(bk);
		lblmsgm.setForeground(text);
		lblmsgq.setBackground(bk);
		lblmsgq.setForeground(text);
		lblmsgy.setBackground(bk);
		lblmsgy.setForeground(text);
		chchoice.setForeground(new Color(60,26,75));
		
		Font f = new Font("Arial", Font.BOLD, 100);
		Font g = new Font("Arial", Font.BOLD, 25);
		
		bg.setBounds(0,200,1000,800);
		lbltitle.setBounds(0,0,1000,200);
		lbl1.setBounds(30,220,940,40);
		lbl6.setBounds(30,270,940,40);
		lbl2.setBounds(30,350,200,100);
		lbl3.setBounds(30,500,200,100);
		lbl4.setBounds(30,650,200,100);
		txtage.setBounds(280,350,200,70);
		txtsum.setBounds(280,500,200,70);
		chchoice.setBounds(280,680,300,100);
		btnsubmit.setBounds(80,800,150,80);
		btnback.setBounds(300,800,150,80);
		lblmsgm.setBounds(600,350,400,100);
		lblmsgq.setBounds(600,450,400,100);
		lblmsgy.setBounds(600,550,400,100); 
		
		lbltitle.setFont( f );
		lblmsgy.setFont( g);
		lblmsgm.setFont( g);
		lblmsgq.setFont( g);
		lbl1.setFont(g);
		lbl6.setFont(g);
		lbl2.setFont(g);
		lbl3.setFont(g);
		lbl4.setFont(g);
		chchoice.setFont(g);
		txtage.setFont(g);
		txtsum.setFont(g);
		btnback.setFont(g);
		btnsubmit.setFont(g);
		btnback.setForeground(bk);
		btnsubmit.setForeground(bk);
		btnback.setBackground(text);
		btnsubmit.setBackground(text);
		
		add(lbl1);
		add(lbl6);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lblmsgy);
		add(lblmsgq);
		add(lblmsgm);
		add(lbltitle);
		add(btnsubmit);
		add(btnback);
		add(txtsum);
		add(txtage);
		add(chchoice);
		add(bg);
		
		addWindowListener(new Win());
		
		for(int i=0;i<field.length;i++)
			chchoice.add(field[i]);
		BtnListener x=new BtnListener();
		btnsubmit.addActionListener(x);
		btnback.addActionListener(x);
		setSize(1000,1000);
		setVisible(true);
	}
	class BtnListener  implements ActionListener
	{
		public void actionPerformed( ActionEvent ae )
		{
			String btn = ae.getActionCommand();
			String c = chchoice.getSelectedItem();
			sum=Double.parseDouble(txtsum.getText());
			age=Double.parseDouble(txtage.getText());
			term=18 - age;
			if(btn.equals("Submit"))
			{
				
					btnsubmit.setBackground(new Color(105,105,105));
					if( c.equals("Engineering") || c.equals("Medical") )
					{
					yearly=(int)((sum*0.9)/(term));
					monthly=(int)((sum*0.96)/(term*12));
					quaterly=(int)((sum*1.02)/(term*3));
					}
					else if (c.equals("Law") || c.equals("MBA") || c.equals("others"))
					{
					yearly=(int)((sum*1.02)/(term));
					monthly=(int)((sum*1.1)/(term*12));
					quaterly=(int)((sum*1.18)/(term*3));
					}
					lblmsgm.setText("Monthly: "+monthly+"/-");
					lblmsgq.setText("Quaterly: "+quaterly+"/-");
					lblmsgy.setText("Yearly: "+yearly+"/-");
					
			}
			else if(btn.equals("Back"))
			{
				btnback.setBackground(new Color(105,105,105));
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
		ChildPolicy l=new ChildPolicy(); 
	}
}
