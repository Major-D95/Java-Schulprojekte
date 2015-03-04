package taschenrechner;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;


public class MainFrame
{

	private JFrame frmTaschenrechner;
	static JTextField txtDisplay;
	
	String number1="";
	String number2="";
	int operator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.MacLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable()
		{

			public void run()
			{
				try
				{
					MainFrame window = new MainFrame();
					window.frmTaschenrechner.setVisible(true);
					txtDisplay.setText("0");
				
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmTaschenrechner = new JFrame();
		frmTaschenrechner.setResizable(false);
		frmTaschenrechner.setTitle("Taschenrechner");
		frmTaschenrechner.setBounds(100, 100, 341, 374);
		frmTaschenrechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTaschenrechner.setLocationRelativeTo(null);
		frmTaschenrechner.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDisplay.setBackground(new Color(51, 204, 51));
		txtDisplay.setEditable(false);
		txtDisplay.setBounds(12, 13, 308, 83);
		frmTaschenrechner.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btnDelete = new JButton("On");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				number1="";
				number2="";
				operator=0;
				txtDisplay.setBackground(new Color(51, 204, 51));
				txtDisplay.setText("0");
			}
			});
		btnDelete.setBounds(12, 136, 75, 25);
		frmTaschenrechner.getContentPane().add(btnDelete);
		
		JButton btnOff = new JButton("Off");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtDisplay.setText("");
				number1="";
				number2="";
				operator=0;
				txtDisplay.setBackground(Color.LIGHT_GRAY);
				
			}
		});
		btnOff.setBounds(99, 136, 75, 25);
		frmTaschenrechner.getContentPane().add(btnOff);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="7";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="7";
				txtDisplay.setText(number1);
			}
			}
		});
		btn7.setBounds(12, 174, 75, 25);
		frmTaschenrechner.getContentPane().add(btn7);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="4";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="4";
				txtDisplay.setText(number1);
			}
			}
		});
		btn4.setBounds(12, 212, 75, 25);
		frmTaschenrechner.getContentPane().add(btn4);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="8";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="8";
				txtDisplay.setText(number1);
			}
			}
		});
		btn8.setBounds(99, 174, 75, 25);
		frmTaschenrechner.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="9";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="9";
				txtDisplay.setText(number1);
			}
			}
		});
		btn9.setBounds(186, 174, 75, 25);
		frmTaschenrechner.getContentPane().add(btn9);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="5";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="5";
				txtDisplay.setText(number1);
			}
			}
		});
		btn5.setBounds(99, 212, 75, 25);
		frmTaschenrechner.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="6";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="6";
				txtDisplay.setText(number1);
			}
			}
		});
		btn6.setBounds(186, 212, 75, 25);
		frmTaschenrechner.getContentPane().add(btn6);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="3";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="3";
				txtDisplay.setText(number1);
			}
			}
		});
		btn3.setBounds(12, 250, 75, 25);
		frmTaschenrechner.getContentPane().add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="2";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="2";
				txtDisplay.setText(number1);
			}
			}
		});
		btn2.setBounds(99, 250, 75, 25);
		frmTaschenrechner.getContentPane().add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+="1";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+="1";
				txtDisplay.setText(number1);
			}
		}});
		btn1.setBounds(186, 250, 75, 25);
		frmTaschenrechner.getContentPane().add(btn1);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!txtDisplay.getText().equals("0"))
				{
					if(operator>0)
					{
					number2+="0";
					txtDisplay.setText(number2);
				}
				else
				{
					number1+="0";
					txtDisplay.setText(number1);
				}
				}
			}
		});
		btn0.setBounds(12, 288, 75, 25);
		frmTaschenrechner.getContentPane().add(btn0);
		
		JButton btnComma = new JButton(",");
		btnComma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(operator>0)
				{
				number2+=".";
				txtDisplay.setText(number2);
			}
			else
			{
				number1+=".";
				txtDisplay.setText(number1);
			}
		}});
		btnComma.setBounds(99, 288, 75, 25);
		frmTaschenrechner.getContentPane().add(btnComma);
		
		JButton btnCalc = new JButton("=");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
				switch (operator)
				{
				case 1:
				{
					double zahl1=Double.parseDouble(number1);
					double zahl2=Double.parseDouble(number2);
					double ergebnis=zahl1+zahl2;
					txtDisplay.setText(Double.toString(ergebnis));
					number1="";
					number2="";
					operator=0;
				}
				case 2:
				{
					double zahl1=Double.parseDouble(number1);
					double zahl2=Double.parseDouble(number2);
					double ergebnis=zahl1-zahl2;
					txtDisplay.setText(Double.toString(ergebnis));
					number1="";
					number2="";
					operator=0;
				}
				case 4:
				{	
					double zahl1=Double.parseDouble(number1);
					double zahl2=Double.parseDouble(number2);
					if(zahl2!=0)
					{
					double ergebnis=zahl1/zahl2;
					txtDisplay.setText(Double.toString(ergebnis));
					}
					else
					{
					txtDisplay.setText("Syntax Error (Divison durch 0 !)");
					}
					number1="";
					number2="";
					operator=0;
				}
				case 3:
				{
					double zahl1=Double.parseDouble(number1);
					double zahl2=Double.parseDouble(number2);
					double ergebnis=zahl1*zahl2;
					txtDisplay.setText(Double.toString(ergebnis));
					number1="";
					number2="";
					operator=0;
				}
				}
			}catch(java.lang.NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "BUG !!");
				}
		}});
		btnCalc.setBounds(186, 288, 75, 25);
		frmTaschenrechner.getContentPane().add(btnCalc);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				operator=4;
			}
		});
		btnDiv.setBounds(273, 174, 47, 25);
		frmTaschenrechner.getContentPane().add(btnDiv);
		
		JButton btnMal = new JButton("*");
		btnMal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				operator=3;
			}
		});
		btnMal.setBounds(273, 212, 47, 25);
		frmTaschenrechner.getContentPane().add(btnMal);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				operator=2;
			}
		});
		btnMinus.setBounds(273, 250, 47, 25);
		frmTaschenrechner.getContentPane().add(btnMinus);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				operator=1;
	
			}
		});
		btnPlus.setBounds(273, 288, 47, 25);
		frmTaschenrechner.getContentPane().add(btnPlus);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Dieses Programm wurde von Dustin Majora geschrieben ");
			}
		});
		btnInfo.setBounds(186, 136, 75, 25);
		frmTaschenrechner.getContentPane().add(btnInfo);
	}
}
