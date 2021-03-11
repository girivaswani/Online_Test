import java.awt.event.*;
import javax.swing.*;

class OnlineTest1 extends JFrame implements ActionListener
{
	JLabel l1;
	JRadioButton r1, r2, r3, r4, r5;
	JButton b1;
	ButtonGroup group;

	int count=0, current=1;

  public static void main(String s[])
	{
		OnlineTest1 o = new OnlineTest1();
	}

	OnlineTest1()
	{
		super("Online Test in Java");

    setVisible(true);
    setSize(600,350);
    setLayout(null);
    setLocation(400,100);

		l1=new JLabel();
    l1.setBounds(30,40,550,20);
    add(l1);

    r1 = new JRadioButton();
    r1.setBounds(50,80,200,20);
    add(r1);

    r2 = new JRadioButton();
    r2.setBounds(50,110,200,20);
    add(r2);

    r3 = new JRadioButton();
    r3.setBounds(50,140,200,20);
    add(r3);

    r4 = new JRadioButton();
    r4.setBounds(50,170,200,20);
    add(r4);

    r5 = new JRadioButton();
    add(r5);

    b1=new JButton("Next");
    b1.setBounds(30,200,100,30);
    add(b1);

		group=new ButtonGroup();
    group.add(r1);
    group.add(r2);
    group.add(r3);
    group.add(r4);
    group.add(r5);

		b1.addActionListener(this);

		set();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Next"))
		{
			if(check())
				count=count+1;
			current++;
      if(current==4)
				b1.setText("Result");
			set();
		}

		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			JOptionPane.showMessageDialog(this,"Correct answers ="+count+"\nQs1-Float\nQs2-Object\nQs3-lang\nQs4-get");
			System.exit(0);
		}
	}

	void set()
	{
		r5.setSelected(true);

		if(current==1)
		{
			l1.setText("Qs.1: Which among these is not a primitive datatype?");
			r1.setText("int"); r2.setText("Float");r3.setText("boolean");r4.setText("char");
		}
		else if(current==2)
		{
			l1.setText("Qs.2: Which class is the superclass of all java classes automatically?");
			r1.setText("Swing");r2.setText("Applet");r3.setText("Object");r4.setText("ActionEvent");
		}
		else if(current==3)
		{
			l1.setText("Qs.3: Which package is directly available to our class without importing it?");
			r1.setText("swing");r2.setText("applet");r3.setText("net");r4.setText("lang");
		}
		else if(current==4)
		{
      l1.setText("Qs.4: Which one among these is not a keyword");
			r1.setText("class");r2.setText("int");r3.setText("get");r4.setText("if");
		}
	}

	boolean check()
	{
    switch(current)
    {
      case 1: return (r2.isSelected());
      case 2: return (r3.isSelected());
      case 3: return (r4.isSelected());
      case 4: return (r3.isSelected());
      case 5: return (r4.isSelected());
      default: return false;
    }
	}

}
