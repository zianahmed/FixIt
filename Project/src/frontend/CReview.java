package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modules.*;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class CReview extends JFrame {
	
	private Service s;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField comm;
	
	JLabel sl = new JLabel("Service ID:");
	JLabel tl = new JLabel("Type: ");
	JLabel wl = new JLabel("Worker:");
	JLabel dl = new JLabel("Date:");
	
	
	public void Assign(Service s) {
		this.s=s;
		if(s!=null) {
			sl.setText("Service ID: " + String.valueOf(s.getId()));
			tl.setText("Type: " + s.getType());
			wl.setText("Worker: " + s.getwName());
        }
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CReview frame = new CReview();
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
	public CReview() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 150, 192));
		panel.setBounds(0, 0, 418, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("R E V I E W");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(138, 0, 141, 68);
		panel.add(lblNewLabel);
		
		sl.setFont(new Font("Arial Black", Font.PLAIN, 14));
		sl.setBounds(27, 79, 168, 37);
		contentPane.add(sl);
		
		tl.setFont(new Font("Arial Black", Font.PLAIN, 14));
		tl.setBounds(222, 79, 168, 37);
		contentPane.add(tl);
		
		wl.setFont(new Font("Arial Black", Font.PLAIN, 14));
		wl.setBounds(27, 127, 168, 37);
		contentPane.add(wl);
		
		dl.setFont(new Font("Arial Black", Font.PLAIN, 14));
		dl.setBounds(222, 127, 168, 37);
		contentPane.add(dl);
		
		JLabel lblNewLabel_1_3 = new JLabel("Rating:");
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(27, 175, 168, 37);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Comments:");
		lblNewLabel_1_4.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(27, 223, 168, 37);
		contentPane.add(lblNewLabel_1_4);
		
		JRadioButton b1 = new JRadioButton("");
		b1.setBounds(222, 182, 21, 23);
		contentPane.add(b1);
		
		JRadioButton b2 = new JRadioButton("");
		b2.setBounds(249, 182, 21, 23);
		contentPane.add(b2);
		
		JRadioButton b3 = new JRadioButton("");
		b3.setBounds(277, 182, 21, 23);
		contentPane.add(b3);
		
		JRadioButton b4 = new JRadioButton("");
		b4.setBounds(300, 182, 21, 23);
		contentPane.add(b4);
		
		JRadioButton b5 = new JRadioButton("");
		b5.setBounds(323, 182, 21, 23);
		contentPane.add(b5);
		
		 ButtonGroup buttonGroup = new ButtonGroup();
	        buttonGroup.add(b1);
	        buttonGroup.add(b2);
	        buttonGroup.add(b3);
	        buttonGroup.add(b4);
	        buttonGroup.add(b5);
		comm = new JTextField();
		comm.setBounds(27, 264, 363, 37);
		contentPane.add(comm);
		comm.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("  1");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2.setBounds(222, 212, 21, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("  2");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(249, 212, 21, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("  3");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2_2.setBounds(277, 212, 21, 23);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("  4");
		lblNewLabel_2_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_3.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2_3.setBounds(300, 212, 21, 23);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("  5");
		lblNewLabel_2_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_4.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2_4.setBounds(323, 212, 21, 23);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel error = new JLabel("Please Select Rating!");
        JButton post = new JButton("POST REVIEW");
		post.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s != null) {
		            
					int rating = 0;
		            if (b1.isSelected()) {
		                rating = 1;
		            } else if (b2.isSelected()) {
		                rating = 2;
		            } else if (b3.isSelected()) {
		                rating = 3;
		            } else if (b4.isSelected()) {
		                rating = 4;
		            } else if (b5.isSelected()) {
		                rating = 5;
		            }
		            
		            if(rating==0)
		            	error.setForeground(Color.red);
		            else {
			            String comments = comm.getText();
			            Review r=new Review();
			            r.setcId(s.getCid());
			            r.setwId(s.getWid());
			            r.setRating(rating);
			            r.setComment(comments);
			            LocalDate currentDate = LocalDate.now();
			            String date=String.valueOf(currentDate.getYear())+"-" + String.valueOf(currentDate.getMonthValue())+ "-"+ String.valueOf(currentDate.getDayOfMonth());
			            r.setDate(date);
			            r.post();
			            s.updateStatus(s.getId(), "Completed");
			            dispose();
		            }
				}
				
			}
		});
		
		post.setBackground(new Color(40, 150, 192));
		post.setForeground(new Color(255, 255, 255));
		post.setFont(new Font("Arial Black", Font.BOLD, 14));
		post.setBounds(124, 376, 168, 43);
		contentPane.add(post);
	    LocalDate currentDate = LocalDate.now();
        String date=String.valueOf(currentDate.getYear())+"-" + String.valueOf(currentDate.getMonthValue())+ "-"+ String.valueOf(currentDate.getDayOfMonth());
        dl.setText(date);
        
        error.setForeground(new Color(238, 238, 238));
        error.setBackground(new Color(255, 255, 255));
        error.setFont(new Font("Arial Black", Font.PLAIN, 14));
        error.setBounds(125, 313, 168, 37);
        contentPane.add(error);
        	
	}
}
