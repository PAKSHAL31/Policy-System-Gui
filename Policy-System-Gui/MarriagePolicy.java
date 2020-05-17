import java.awt.*;
import java.awt.event.*;

class MarriagePolicy extends Frame
{
	double sum,term,age;
	int yearly,monthly,quaterly;
	Label lbltitle = new Label("       Marriage Policy           ");
	Label lbl1 = new Label("The child's future marriage planning calculator by HDFC Life is specially designed to ");
	Label lbl6 = new Label("calculate the wedding cost and to help you towards planning a memorable wedding for your child.");
	Label lbl2 = new Label("Age :");
	Label lbl3 = new Label("Marriage Age :");
	Label lbl4 = new Label("Sum Assured :");
	TextField txtage=new TextField();
	TextField txtmage=new TextField();
	TextField txtsum=new TextField();
	Button btnsubmit =new Button("Submit");
	Button btnback=new Button("Back");
	Label lblmsgy = new Label("");
	Label lblmsgm = new Label("");
	Label lblmsgq = new Label("");
	Color bk = new Color(255,234,235);
	Color text= new Color(47,60,126);
	Label bg = new Label();
	
	MarriagePolicy()
	{
		super("Marriage Policy");
		setLayout(null);
		
		bg.setBackground(bk);
		lbltitle.setBackground(bk);
		lbltitle.setForeground(text);
		btnback.setForeground(bk);
		btnsubmit.setForeground(bk);
		btnback.setBackground(text);
		btnsubmit.setBackground(text);
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
		
		Font f = new Font("Arial", Font.BOLD, 100);
		Font g = new Font("Arial", Font.BOLD, 30);
		Font h = new Font("Arial", Font.BOLD, 20);
		
		bg.setBounds(0,200,1000,800);
		lbltitle.setBounds(0,0,1000,200);
		lbl1.setBounds(30,220,940,40);
		lbl6.setBounds(30,270,940,40);
		lbl2.setBounds(30,350,200,100);
		lbl3.setBounds(30,500,200,100);
		lbl4.setBounds(30,650,200,100);
		txtage.setBounds(280,350,200,70);
		txtmage.setBounds(280,500,200,70);
		txtsum.setBounds(280,650,200,70);
		btnsubmit.setBounds(80,800,150,80);
		btnback.setBounds(300,800,150,80);
		lblmsgm.setBounds(600,350,400,100);
		lblmsgq.setBounds(600,450,400,100);
		lblmsgy.setBounds(600,550,400,100); 
		
		lbltitle.setFont( f );
		lbl1.setFont(h);
		lbl6.setFont(h);
		lbl2.setFont(g);
		lbl3.setFont(g);
		lbl4.setFont(g);
		lblmsgy.setFont(g);
		lblmsgm.setFont(g);
		lblmsgq.setFont(g);
		txtage.setFont(g);
		txtsum.setFont(g);
		txtmage.setFont(g);
		btnback.setFont(g);
		btnsubmit.setFont(g);
		
		add(lbl1);
		add(lbl6);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lblmsgm);
		add(lblmsgy);
		add(lblmsgq);
		add(lbltitle);
		add(btnsubmit);
		add(btnback);
		add(txtsum);
		add(txtmage);
		add(txtage);
		add(bg);
		
		addWindowListener(new Win());
		
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
			sum=Double.parseDouble(txtsum.getText());
			term=Double.parseDouble(txtmage.getText());
			age=Double.parseDouble(txtage.getText());
			term=term - age;
			if(btn.equals("Submit"))
			{
					btnsubmit.setBackground(new Color(105,105,105));
					yearly=(int)((sum*0.8)/(term));
					monthly=(int)((sum)/(term*12));
					quaterly=(int)((sum*0.95)/(term*3));
					lblmsgm.setText("Monthly: "+monthly+"/-");
					lblmsgq.setText("Quaterly: "+quaterly+"/-");
					lblmsgy.setText("Yearly: "+yearly+"/-");
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
		MarriagePolicy l=new MarriagePolicy(); 
	}
}
