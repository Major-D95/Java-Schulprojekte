package fahrtkostenrechner.dustin.majora;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;


public class MainFrame
{

	private JFrame frmFahrtkostenrechner;
	private JTextField txtStrecke;
	private JTextField txtVerbrauch;
	private JTextField txtBenzinPreis;
	private JTextField txtKosten;
	double verbrauch;
	double strecke;
	double benzinPreis;
	double kosten;
	String ausgabe;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	DecimalFormat f = new DecimalFormat("#0.00");
	private JLabel lblNewLabel_3;
	
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
					window.frmFahrtkostenrechner.setVisible(true);
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
		frmFahrtkostenrechner = new JFrame();
		frmFahrtkostenrechner.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/fahrtkostenrechner/dustin/majora/47-fuel-icon.png")));
		frmFahrtkostenrechner.setTitle("FKR Tool");
		frmFahrtkostenrechner.setFont(new Font("Segoe UI", Font.PLAIN, 7));
		frmFahrtkostenrechner.setBounds(100, 100, 236, 285);
		frmFahrtkostenrechner.setLocationRelativeTo(null);
		frmFahrtkostenrechner.setResizable(false);
		frmFahrtkostenrechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFahrtkostenrechner.getContentPane().setLayout(null);
		
		txtStrecke = new JTextField();
		txtStrecke.setToolTipText("");
		txtStrecke.setBounds(140, 13, 78, 22);
		frmFahrtkostenrechner.getContentPane().add(txtStrecke);
		txtStrecke.setColumns(10);
		
		txtVerbrauch = new JTextField();
		txtVerbrauch.setToolTipText("");
		txtVerbrauch.setBounds(140, 42, 78, 22);
		frmFahrtkostenrechner.getContentPane().add(txtVerbrauch);
		txtVerbrauch.setColumns(10);
		
		txtBenzinPreis = new JTextField();
		txtBenzinPreis.setToolTipText("");
		txtBenzinPreis.setBounds(140, 71, 78, 22);
		frmFahrtkostenrechner.getContentPane().add(txtBenzinPreis);
		txtBenzinPreis.setColumns(10);
		
		txtKosten = new JTextField();
		txtKosten.setBackground(new Color(255, 255, 255));
		txtKosten.setEditable(false);
		txtKosten.setBounds(140, 141, 78, 22);
		frmFahrtkostenrechner.getContentPane().add(txtKosten);
		txtKosten.setColumns(10);
		
		JButton btnCalc = new JButton("Berechnen");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try{
				strecke=Double.parseDouble(txtStrecke.getText());
				verbrauch=Double.parseDouble(txtVerbrauch.getText());
				benzinPreis=Double.parseDouble(txtBenzinPreis.getText());
				
				
				kosten=((verbrauch/100)*strecke)*benzinPreis;
				
				ausgabe=f.format(kosten);
				
				txtKosten.setText(ausgabe+" €");
				}catch(java.lang.NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder mit korrekten Werten aus !","Eingabe prüfen !",JOptionPane.WARNING_MESSAGE);
				}	
				
			}
		});
		btnCalc.setBounds(55, 110, 120, 25);
		frmFahrtkostenrechner.getContentPane().add(btnCalc);
		
		lblNewLabel = new JLabel("Strecke (km): ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(12, 16, 136, 16);
		frmFahrtkostenrechner.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Verbrauch (l/100km): ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(12, 42, 136, 22);
		frmFahrtkostenrechner.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Benzin Preis (\u20AC): ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(12, 70, 136, 24);
		frmFahrtkostenrechner.getContentPane().add(lblNewLabel_2);
		
		JLabel lblFahrtkosten = new JLabel("Fahrtkosten (\u20AC): ");
		lblFahrtkosten.setHorizontalAlignment(SwingConstants.LEFT);
		lblFahrtkosten.setBounds(12, 144, 104, 16);
		frmFahrtkostenrechner.getContentPane().add(lblFahrtkosten);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtStrecke.setText("");
				txtVerbrauch.setText("");
				txtBenzinPreis.setText("");
				txtKosten.setText("");
				
			}
		});
		btnLschen.setBounds(12, 184, 100, 25);
		frmFahrtkostenrechner.getContentPane().add(btnLschen);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int confirmDialog=JOptionPane.showConfirmDialog(null,"Wollen Sie das Programm wirklich beenden ?");
				
				if(confirmDialog==0)
				 {
					System.exit(0);
				 }
				
			}
		});
		btnBeenden.setBounds(116, 184, 100, 25);
		frmFahrtkostenrechner.getContentPane().add(btnBeenden);
		
		lblNewLabel_3 = new JLabel("Dustin Majora V1.0");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(0, 218, 218, 32);
		frmFahrtkostenrechner.getContentPane().add(lblNewLabel_3);
	}
}
