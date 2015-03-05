package lineareFunktionenTool;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;


public class MainFrame
{

	private JFrame frmLineareFunktionenTool;
	private JTextField txtM;
	private JTextField txtB;
	private JTextField txtVerschieben;
	private JTextField txtX1;
	private JTextField txtX2;
	private JTextField txtY1;
	private JTextField txtY2;
	private JTextField txtFunktion;
	private static JTextField txtStartwert;
	private static JTextField txtEndwert;


	public static void funktionswerteAuslesen (int m,int b,int Array[])
	{
		int variStartwert=Integer.parseInt(txtStartwert.getText());
		int variEndwert=Integer.parseInt(txtEndwert.getText());
		
		for(int x=0;x<variEndwert-variStartwert;x++)
		{
			int y;
			y=m*x+b;
			Array[x]=y;
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
					window.frmLineareFunktionenTool.setVisible(true);
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
		frmLineareFunktionenTool = new JFrame();
		frmLineareFunktionenTool.setResizable(false);
		frmLineareFunktionenTool.setTitle("Lineare Funktionen Tool");
		frmLineareFunktionenTool.setBounds(100, 100, 356, 400);
		frmLineareFunktionenTool.setLocationRelativeTo(null);
		frmLineareFunktionenTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmLineareFunktionenTool.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel FunktionswertePnl = new JPanel();
		tabbedPane.addTab("Funktionswerte Berechnen", null, FunktionswertePnl, null);
		FunktionswertePnl.setLayout(null);
		
		txtM = new JTextField();
		txtM.setBounds(42, 33, 59, 22);
		FunktionswertePnl.add(txtM);
		txtM.setColumns(10);
		
		JLabel m_1 = new JLabel("m:");
		m_1.setBounds(12, 36, 36, 16);
		FunktionswertePnl.add(m_1);
		
		JLabel b_1 = new JLabel("b:");
		b_1.setBounds(12, 71, 36, 16);
		FunktionswertePnl.add(b_1);
		
		txtB = new JTextField();
		txtB.setBounds(42, 68, 59, 22);
		FunktionswertePnl.add(txtB);
		txtB.setColumns(10);
		
		JPanel DisplayPnl = new JPanel();
		DisplayPnl.setBounds(130, 13, 204, 208);
		FunktionswertePnl.add(DisplayPnl);
		DisplayPnl.setLayout(new BorderLayout(0, 0));
		
		
		final JTextArea txtDisplay = new JTextArea();
		DisplayPnl.add(txtDisplay, BorderLayout.CENTER);
		txtDisplay.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtDisplay);
		DisplayPnl.add(scrollPane, BorderLayout.CENTER);
		
		JButton btnRechnen = new JButton("Rechnen");
		btnRechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int variStartwert=Integer.parseInt(txtStartwert.getText());
				int variEndwert=Integer.parseInt(txtEndwert.getText());
				
				int funktionswerteArray[] = new int [variEndwert-variStartwert];

				int variM=Integer.parseInt(txtM.getText());
				int variB=Integer.parseInt(txtB.getText());
				String Ausgabe = "";
				funktionswerteAuslesen(variM,variB,funktionswerteArray);
				for(int i=0;i<funktionswerteArray.length;i++)
				{
					
					Ausgabe+= variStartwert+i+": "+String.valueOf(funktionswerteArray[i]+"\n");
					
				}
				txtDisplay.setText(Ausgabe);
				
			}
		});
		btnRechnen.setBounds(12, 163, 89, 25);
		FunktionswertePnl.add(btnRechnen);
		
		JLabel lblYmxb = new JLabel("y=m*x+b");
		lblYmxb.setBounds(12, 4, 89, 16);
		FunktionswertePnl.add(lblYmxb);
		
		JButton btnUeber0 = new JButton("\u00DCber 0");
		btnUeber0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int funktionswerteArray[] = new int [20];

				int variM=Integer.parseInt(txtM.getText());
				int variB=Integer.parseInt(txtB.getText());
				int ueber0=0;
				funktionswerteAuslesen(variM,variB,funktionswerteArray);
				for(int i=0;i<20;i++)
				{
					if(funktionswerteArray[i]>0)
					{
						ueber0++;
					}
					
				}
				JOptionPane.showMessageDialog(null, "Es sind "+ueber0+" Funktionswerte �ber 0");
				
			}
		});
		btnUeber0.setBounds(12, 231, 89, 25);
		FunktionswertePnl.add(btnUeber0);
		
		txtVerschieben = new JTextField();
		txtVerschieben.setBounds(130, 264, 76, 22);
		FunktionswertePnl.add(txtVerschieben);
		txtVerschieben.setColumns(10);
		
		JButton btnVerschieben = new JButton("Verschieben");
		btnVerschieben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int funktionswerteArray[] = new int [20];

				int variM=Integer.parseInt(txtM.getText());
				int variB=Integer.parseInt(txtB.getText());
				if(!txtVerschieben.getText().equals(""))
				{
					int VariVerschieben=Integer.parseInt(txtVerschieben.getText());
					String Ausgabe="";
					funktionswerteAuslesen(variM,variB,funktionswerteArray);
					
						for(int i=0;i<20;i++)
						{
							funktionswerteArray[i]=funktionswerteArray[i]+VariVerschieben;
							
						}
						for(int i=0;i<20;i++)
						{
		
							Ausgabe+= i+": "+String.valueOf(funktionswerteArray[i]+"\n");
							
						}
					txtDisplay.setText(Ausgabe);
					
				}else JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Zahl ein !");
					
			}
			});
		btnVerschieben.setBounds(218, 264, 101, 22);
		FunktionswertePnl.add(btnVerschieben);
		
		JLabel lblYachseVerschieben = new JLabel("Y-Achse verschieben");
		lblYachseVerschieben.setBounds(12, 267, 134, 16);
		FunktionswertePnl.add(lblYachseVerschieben);
		
		txtStartwert = new JTextField();
		txtStartwert.setBounds(42, 100, 59, 20);
		FunktionswertePnl.add(txtStartwert);
		txtStartwert.setColumns(10);
		
		txtEndwert = new JTextField();
		txtEndwert.setBounds(42, 131, 59, 20);
		FunktionswertePnl.add(txtEndwert);
		txtEndwert.setColumns(10);
		
		JLabel lblStart = new JLabel("Start:");
		lblStart.setBounds(10, 102, 46, 18);
		FunktionswertePnl.add(lblStart);
		
		JLabel lblEnde = new JLabel("Ende:");
		lblEnde.setBounds(10, 132, 46, 20);
		FunktionswertePnl.add(lblEnde);
		
		JButton btnNewButton = new JButton("Fl\u00E4cheninhalt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int variM=Integer.parseInt(txtM.getText());
				int variB=Integer.parseInt(txtB.getText());
				int variStartwert=Integer.parseInt(txtStartwert.getText());
				int variEndwert=Integer.parseInt(txtEndwert.getText());
				int funktionswerteArray[] = new int [variEndwert-variStartwert];

				
				int nullstelle=variB/variM;
				
				int Fläche = (variB*nullstelle)/2;
		
				int dreieck2= variEndwert-nullstelle;
				
				funktionswerteAuslesen(variM,variB,funktionswerteArray);
				
				int dreieckhöchsteKoordinate=funktionswerteArray[variEndwert-1];
				
				int Fläche2=(dreieckhöchsteKoordinate*dreieck2)/2;
				
				int Flächeninhalt=Fläche+Fläche2;
				
				
				JOptionPane.showMessageDialog(null,"Der Flächeninhalt beträgt: "+Flächeninhalt+"cm�");
				
			}
		});
		btnNewButton.setBounds(130, 231, 119, 25);
		FunktionswertePnl.add(btnNewButton);
		

		JPanel MBBerechnenPnl = new JPanel();
		tabbedPane.addTab("Funktion Berechnen", null, MBBerechnenPnl, null);
		MBBerechnenPnl.setLayout(null);
		
		txtX1 = new JTextField();
		txtX1.setBounds(107, 30, 48, 22);
		MBBerechnenPnl.add(txtX1);
		txtX1.setColumns(10);
		
		txtX2 = new JTextField();
		txtX2.setBounds(189, 30, 48, 22);
		MBBerechnenPnl.add(txtX2);
		txtX2.setColumns(10);
		
		txtY1 = new JTextField();
		txtY1.setBounds(107, 65, 48, 22);
		MBBerechnenPnl.add(txtY1);
		txtY1.setColumns(10);
		
		txtY2 = new JTextField();
		txtY2.setBounds(189, 65, 48, 22);
		MBBerechnenPnl.add(txtY2);
		txtY2.setColumns(10);
		
		JLabel lblX = new JLabel("x1:");
		lblX.setBounds(87, 33, 23, 16);
		MBBerechnenPnl.add(lblX);
		
		JLabel lblY = new JLabel("y1:");
		lblY.setBounds(87, 68, 23, 16);
		MBBerechnenPnl.add(lblY);
		
		JLabel lblX_1 = new JLabel("x2:");
		lblX_1.setBounds(168, 33, 23, 16);
		MBBerechnenPnl.add(lblX_1);
		
		JLabel lblY_1 = new JLabel("y2:");
		lblY_1.setBounds(167, 68, 23, 16);
		MBBerechnenPnl.add(lblY_1);
		
		JButton btnFunktionBerechnen = new JButton("Funktion berechnen");
		btnFunktionBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
					{
					int VariX1=Integer.parseInt(txtX1.getText());
					int VariX2=Integer.parseInt(txtX2.getText());
					int VariY1=Integer.parseInt(txtY1.getText());
					int VariY2=Integer.parseInt(txtY2.getText());
					
					int m=(VariY2-VariY1)/(VariX2-VariX1);
					int b=VariY1-m*VariX1;
					
					String Funktion="y="+m+"*x+"+b;
					txtFunktion.setText(Funktion);
					}
					catch(java.lang.NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Bitte f�llen sie alle Felder korrekt aus");
					}
				
				
			}
		});
		btnFunktionBerechnen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFunktionBerechnen.setBounds(107, 98, 130, 25);
		MBBerechnenPnl.add(btnFunktionBerechnen);
		
		txtFunktion = new JTextField();
		txtFunktion.setBounds(107, 134, 130, 22);
		MBBerechnenPnl.add(txtFunktion);
		txtFunktion.setColumns(10);
		
		JButton btnDelete = new JButton("Zur\u00FCcksetzen");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtY1.setText("");
				txtY2.setText("");
				txtX1.setText("");
				txtX2.setText("");
				txtFunktion.setText("");
				
				
			}
		});
		btnDelete.setBounds(107, 169, 130, 25);
		MBBerechnenPnl.add(btnDelete);
	}
}
