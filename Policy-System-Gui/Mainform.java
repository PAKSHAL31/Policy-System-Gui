import java.awt.*;
import java.awt.event.*;

class Mainform extends Frame
{
	String [] pl = { "-","Human Life Policy","Marriage Expense Policy","Child Education Planner" };
	Label lblmsg = new Label("   Life Prospectus     ");
	Label lbl1 = new Label("Choose Your Policy");
	Choice chchoice = new Choice();
	Button btnsubmit =new Button("Submit");
	Button btnclose=new Button("Close");
	Label bg = new Label();
	Color bk = new Color(255,234,235);
	Color text= new Color(47,60,126);
	
	Mainform()
	{
		super("Mainform");
		setLayout(null);
		//setLocationRelativeTo(center);
		lblmsg.setBackground(text);
		lblmsg.setForeground(bk);
		bg.setBackground(bk);
		lbl1.setForeground(text);
		lbl1.setBackground(bk);
		btnsubmit.setForeground(bk);
		btnsubmit.setBackground(text);
		btnclose.setForeground(bk);
		btnclose.setBackground(text);
		chchoice.setForeground(new Color(60,26,75));
		
		Font f = new Font("Arial", Font.BOLD, 100);
		Font f1 = new Font("Arial", Font.BOLD, 30);
		
		bg.setBounds(0,200,900,700);
		lblmsg.setBounds(0,0,900,200);
		lbl1.setBounds(80,400,300,120);
		chchoice.setBounds(420,450,400,100);
		btnsubmit.setBounds(80,650,150,80);
		btnclose.setBounds(350,650,150,80);
		
		lblmsg.setFont( f );
		lbl1.setFont(f1);
		chchoice.setFont(f1);
		btnsubmit.setFont(f1);
		btnclose.setFont(f1);
		
		add(lblmsg);
		add(chchoice);
		add(lbl1);
		add(btnsubmit);
		add(btnclose);
		add(bg);
		
		for(int i=0;i<pl.length;i++)
			chchoice.add(pl[i]);
		
		addWindowListener(new Win());
		
		BtnListener x=new BtnListener();
		btnsubmit.addActionListener(x);
		btnclose.addActionListener(x);
		
		setSize(900,900);
		setVisible(true);
	}
	
	

	class BtnListener  implements ActionListener
	{
		public void actionPerformed( ActionEvent ae )
		{
			Color cl = new Color(43,50,82);
			String btn = ae.getActionCommand();
			String c=chchoice.getSelectedItem();
			if(btn.equals("Submit"))
			{
				btnsubmit.setBackground(new Color(105,105,105));
				if (c.equals("Human Life Policy"))
			{
				LifePolicy l =new LifePolicy();
				dispose();
			}
			else if(c.equals("Marriage Expense Policy"))
			{
				MarriagePolicy m =new MarriagePolicy();
				dispose();
			}
			else if(c.equals("Child Education Planner"))
			{
				ChildPolicy C =new ChildPolicy();
				dispose();
			}
			}
			else if(btn.equals("Close"))
			{
				btnsubmit.setBackground(new Color(105,105,105));
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
		Mainform g=new Mainform(); 
	}
}