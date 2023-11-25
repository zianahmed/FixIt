package frontend;

import Modules.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class CBook extends JFrame {
	Customer c;
	Worker w;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addr;
	private JTextField details;
	JLabel lc = new JLabel("Customer: ");
	JLabel lw = new JLabel("Worker:  ");
	JLabel lt = new JLabel("Type:  ");
	JLabel lcity = new JLabel("City: ");
	JLabel Fee = new JLabel("City: ");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CBook frame = new CBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void intialize(Customer c,Worker w) {
		this.c=c;
		this.w=w;
		if(c!=null && w!=null) {
			lc.setText("Customer: " + c.getName());
			lw.setText("Worker: " + w.getName());
			lt.setText("Skill: " + w.getSkill());
			lcity.setText("City: " + c.getCity());
			Fee.setText("Fee: " + String.valueOf(w.getFee()));
		}
	}
	
	public CBook() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 150, 192));
		panel.setBounds(0, 0, 474, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("B O O K   A P P O I N T M E N T ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(57, 11, 359, 38);
		panel.add(lblNewLabel);
		
		lc.setFont(new Font("Arial Black", Font.BOLD, 12));
		lc.setBounds(46, 75, 168, 30);
		contentPane.add(lc);
		
		lw.setFont(new Font("Arial Black", Font.BOLD, 12));
		lw.setBounds(245, 75, 183, 30);
		contentPane.add(lw);
		
		lt.setFont(new Font("Arial Black", Font.BOLD, 12));
		lt.setBounds(46, 117, 168, 30);
		contentPane.add(lt);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Address:  ");
		JLabel lblNewLabel_1_2_2 = new JLabel("Date:  ");
		JLabel lblNewLabel_1_2_3 = new JLabel("Details:  ");
		lcity.setFont(new Font("Arial Black", Font.BOLD, 12));
		lcity.setBounds(245, 117, 183, 30);
		contentPane.add(lcity);
		
		lblNewLabel_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(46, 156, 168, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		lblNewLabel_1_2_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_2_2.setBounds(46, 198, 168, 30);
		contentPane.add(lblNewLabel_1_2_2);
		
		lblNewLabel_1_2_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_2_3.setBounds(46, 240, 168, 30);
		contentPane.add(lblNewLabel_1_2_3);
		
		addr = new JTextField();
		addr.setBounds(245, 159, 183, 30);
		contentPane.add(addr);
		addr.setColumns(10);
		
		details = new JTextField();
		details.setColumns(10);
		details.setBounds(47, 280, 381, 30);
		contentPane.add(details);
		
		JButton btnNewButton = new JButton("BOOK");
		JButton btnCancel = new JButton("CANCEL");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(40, 150, 192));
		btnNewButton.setBounds(46, 354, 168, 30);
		contentPane.add(btnNewButton);
		
		
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnCancel.setBackground(new Color(40, 150, 192));
		btnCancel.setBounds(260, 354, 168, 30);
		contentPane.add(btnCancel);
		
		JComboBox dd = new JComboBox();
		dd.setFont(new Font("Arial Black", Font.BOLD, 12));
		dd.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dd.setForeground(new Color(255, 255, 255));
		dd.setBackground(new Color(40, 150, 192));
		dd.setBounds(245, 201, 56, 25);
		contentPane.add(dd);
		
		JComboBox mm = new JComboBox();
		mm.setForeground(new Color(255, 255, 255));
		mm.setBackground(new Color(40, 150, 192));
		mm.setFont(new Font("Arial Black", Font.BOLD, 14));
		mm.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		mm.setBounds(353, 201, 56, 25);
		contentPane.add(mm);
		
		JLabel error = new JLabel("ERROR: Missing/Inavlid Info");
		error.setForeground(new Color(238, 238, 238));
		error.setFont(new Font("Arial Black", Font.BOLD, 12));
		error.setBounds(137, 312, 200, 40);
		contentPane.add(error);
		
		Fee = new JLabel("Fee:   ");
		Fee.setFont(new Font("Arial Black", Font.BOLD, 12));
		Fee.setBounds(241, 240, 168, 30);
		contentPane.add(Fee);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkSelectedDate(dd.getSelectedIndex(),mm.getSelectedIndex())){
					error.setForeground(Color.RED);
				}
				
				else if(c==null || w==null)
					error.setForeground(Color.RED);
				
				else if(addr.getText().isEmpty())
					error.setForeground(Color.RED);
				
				else {
					String detail;
					 
					if (details.getText().isEmpty())
						detail="";
					else
						detail=details.getText();
				
					 Service s=new Service();
					s.setCid(c.getId());
					s.setWid(w.getId());
					s.setAddr(addr.getText());
					s.setDetail(detail);
					s.setCity(w.getCity());
					s.setType(w.getSkill());
					int yyyy=LocalDate.now().getYear();
					String date = yyyy +"-"+ String.valueOf(mm.getSelectedIndex()) +"-"+ String.valueOf(dd.getSelectedIndex());
					s.setFee(w.getFee());
					s.setDate(date);
					s.Register();
					dispose();
				
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private boolean checkSelectedDate(int day, int month) {
        if (day > 0 && month > 0) {
            LocalDate selectedDate = LocalDate.of(LocalDate.now().getYear(), month, day);
            LocalDate currentDate = LocalDate.now();

            if (selectedDate.isBefore(currentDate)) {
                return false;
            } else {
            	return true;
            }
        }
        return false;
    }
}
