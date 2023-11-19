package frontend;

import Modules.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CCancel extends JFrame {
	int sid;
	JLabel main = new JLabel("Confirm Service Cancellataion");
	private JButton left = new JButton("CONFIRM");
	private JButton right = new JButton("CANCEL");
	private int use;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void Assign(int i,int use) {
		sid=i;
		this.use=use;
		
		if(use==1) {
		main.setText("Confirm Service Cancellation");
		left.setText("Confirm");
		right.setText("Cancel");
		}
		
		if (use==2) {
			main.setText("Marked as Completed");
			left.setText("Payment");
			right.setText("Pay Later");				
		}
		
		if(use==3) {
			main.setText("Payment Completed");
			left.setText("ADD Review");
			right.setText("Later");					
		}
		
		if(use==4) {
			main.setText("Thankyou for using FIXIT");
			left.setText("OK");
			right.setEnabled(false);					
		}
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CCancel frame = new CCancel();
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
	public CCancel() {
		setBackground(new Color(40, 150, 192));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		main.setFont(new Font("Arial Black", Font.BOLD, 15));
		main.setForeground(new Color(0, 0, 0));
		main.setBounds(46, 13, 269, 60);
		contentPane.add(main);
		
		left.setForeground(new Color(255, 255, 255));
		left.setFont(new Font("Arial Black", Font.BOLD, 14));
		left.setBackground(new Color(40, 150, 192));
		left.setBounds(33, 86, 131, 39);
		contentPane.add(left);
		
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
	
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Service s=new Service();
			
			if(use==1) {
				if (sid!=0)
					s.Remove(sid);
				dispose();
				}
			
			if (use==4) {
				dispose();
			}
			
			}
			
		});
	
		right.setForeground(Color.WHITE);
		right.setFont(new Font("Arial Black", Font.BOLD, 14));
		right.setBackground(new Color(40, 150, 192));
		right.setBounds(197, 86, 131, 39);
		contentPane.add(right);
		
		
	}
}
