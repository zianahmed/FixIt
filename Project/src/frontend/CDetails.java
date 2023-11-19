package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modules.*;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class CDetails extends JFrame {

	private Service s;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private JPanel panel = new JPanel();
	private JLabel lblNewLabel = new JLabel("APPOINTMENT DETAILS");
	private JLabel sid = new JLabel("Service ID: ");
	private JLabel type = new JLabel("Type: ");
	private JLabel worker = new JLabel("Employee: ");
	private JLabel phone = new JLabel("Phone: ");
	private JLabel date = new JLabel("Date: ");
	private JLabel status = new JLabel("Status: ");
	private JLabel fee = new JLabel("Fee: ");
	private JLabel city = new JLabel("City: ");
	private JLabel addr = new JLabel("Address: ");
	private JLabel details = new JLabel("Details: ");
	
	
	
	void Assign(Service s) {
		
		this.s=s;

		if(s!=null) {
			sid.setText("Service ID: " + String.valueOf(s.getId()));
			type.setText("Type: " +s.getType());
			worker.setText("Worker: " +s.getwName());
			phone.setText("Phone: "  +s.getwPhone());
			date.setText("Date" +s.getDate());
			fee.setText("Fee: " + String.valueOf(s.getFee()));
			status.setText("Status" +s.getStatus());
			city.setText("City: " + s.getCity());
			addr.setText("Address: "  + s.getAddr());
			details.setText("Details: " + s.getDetail());
		}

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CDetails frame = new CDetails();
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
	public CDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBackground(new Color(40, 150, 192));
		panel.setBounds(0, 0, 435, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(90, 0, 255, 59);
		panel.add(lblNewLabel);
		
		sid.setFont(new Font("Arial Black", Font.PLAIN, 12));
		sid.setBounds(10, 86, 174, 36);
		contentPane.add(sid);
		
		type.setFont(new Font("Arial Black", Font.PLAIN, 12));
		type.setBounds(221, 86, 174, 36);
		contentPane.add(type);
		
		worker.setFont(new Font("Arial Black", Font.PLAIN, 12));
		worker.setBounds(10, 133, 174, 36);
		contentPane.add(worker);
		
		phone.setFont(new Font("Arial Black", Font.PLAIN, 12));
		phone.setBounds(221, 133, 174, 36);
		contentPane.add(phone);
		
		date.setFont(new Font("Arial Black", Font.PLAIN, 12));
		date.setBounds(10, 180, 174, 36);
		contentPane.add(date);
		
		status.setFont(new Font("Arial Black", Font.PLAIN, 12));
		status.setBounds(221, 180, 174, 36);
		contentPane.add(status);
		
		fee.setFont(new Font("Arial Black", Font.PLAIN, 12));
		fee.setBounds(10, 227, 174, 36);
		contentPane.add(fee);
		
		city.setFont(new Font("Arial Black", Font.PLAIN, 12));
		city.setBounds(221, 227, 174, 36);
		contentPane.add(city);
		
		addr.setFont(new Font("Arial Black", Font.PLAIN, 12));
		addr.setBounds(10, 274, 415, 36);
		contentPane.add(addr);
		
		details.setFont(new Font("Arial Black", Font.PLAIN, 12));
		details.setBounds(10, 321, 415, 36);
		contentPane.add(details);
	}
}
