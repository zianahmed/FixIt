package frontend;
import Modules.*;
import java.awt.EventQueue;
import java.util.Date;
import java.math.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class CPayment extends JFrame {
	private Service s;
	private Customer c;
	private double ctotal;
	private String cdate;
	private JLabel sid = new JLabel("Service ID: ");
	private JLabel date = new JLabel("Date: ");
	private JLabel fee = new JLabel("Fee: ");
	private JLabel tax = new JLabel("Tax(16% GST): ");
	private JLabel total = new JLabel("Total: ");
	
	public void Assign(Service s,Customer c) {
		this.s=s;
		if(s!=null) {
			LocalDate currentDate = LocalDate.now();
            cdate=String.valueOf(currentDate.getYear())+"-" + String.valueOf(currentDate.getMonthValue())+ "-"+ String.valueOf(currentDate.getDayOfMonth());
            sid.setText("Service ID: " + String.valueOf(s.getId()));
			date.setText("Date: " + cdate);
			fee.setText("Fee: " + String.valueOf(s.getFee()));
			double ctax= (16.0F/100.0F)*s.getFee();
			ctax=Math.round(ctax);
			tax.setText("Tax(16% GST):"+ ctax);
			ctotal=ctax+s.getFee();
			ctotal=Math.round(ctotal);
			total.setText("Total: " + ctotal);
			accTitle.setText(c.getName());
			accNum.setText(c.getPhone());
		}
	}
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField accTitle;
	private JTextField accNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPayment frame = new CPayment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CPayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 150, 192));
		panel.setBounds(0, 0, 436, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("P  A  Y  M  E  N  T");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(116, 11, 203, 56);
		panel.add(lblNewLabel);
		
		sid.setFont(new Font("Arial Black", Font.BOLD, 14));
		sid.setBounds(40, 115, 158, 38);
		contentPane.add(sid);
		
		date.setFont(new Font("Arial Black", Font.BOLD, 14));
		date.setBounds(238, 115, 158, 38);
		contentPane.add(date);
		
		fee.setFont(new Font("Arial Black", Font.BOLD, 14));
		fee.setBounds(40, 165, 158, 38);
		contentPane.add(fee);
		
		tax.setFont(new Font("Arial Black", Font.BOLD, 14));
		tax.setBounds(238, 165, 158, 38);
		contentPane.add(tax);
		
		total.setFont(new Font("Arial Black", Font.BOLD, 14));
		total.setBounds(139, 215, 158, 38);
		contentPane.add(total);
		
		JLabel lblNewLabel_1_4 = new JLabel("Account Title: ");
		lblNewLabel_1_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(40, 265, 158, 38);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Account Number: ");
		lblNewLabel_1_5.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(40, 315, 158, 38);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Bank: ");
		lblNewLabel_1_6.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(40, 365, 63, 38);
		contentPane.add(lblNewLabel_1_6);
		
		accTitle = new JTextField();
		accNum = new JTextField();
		accTitle.setBounds(216, 265, 158, 38);
		contentPane.add(accTitle);
		accTitle.setColumns(10);
		
		accNum.setColumns(10);
		accNum.setBounds(216, 315, 158, 38);
		contentPane.add(accNum);
		
		JComboBox bank = new JComboBox();
		bank.setFont(new Font("Arial Black", Font.BOLD, 14));
		bank.setForeground(new Color(255, 255, 255));
		bank.setBackground(new Color(40, 150, 192));
		bank.setModel(new DefaultComboBoxModel(new String[] {"Easypaisa", "JazzCash", "SadaPay"}));
		bank.setBounds(216, 373, 158, 30);
		contentPane.add(bank);
		
		JButton confirm = new JButton("CONFIRM");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Service ss=new Service();
			ss.setId(s.getId());
			ss.setCid(s.getCid());
			ss.setWid(s.getWid());
			ss.Pay(ctotal);
			dispose();
			}
		});
		confirm.setForeground(new Color(255, 255, 255));
		confirm.setBackground(new Color(40, 150, 192));
		confirm.setFont(new Font("Arial Black", Font.BOLD, 16));
		confirm.setBounds(142, 437, 151, 38);
		contentPane.add(confirm);
	}
}
