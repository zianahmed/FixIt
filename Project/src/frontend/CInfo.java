package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modules.*;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class CInfo extends JFrame {

	Customer c;
	Worker w;
	Boolean flag=false;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField pnum;
	private JPasswordField pass;
	private JTextField fee;

	
	public CInfo(Customer cc) {
		c=cc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 150, 192));
		panel.setBounds(0, 0, 452, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("A C C O U N T   I N F O");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_4.setBounds(87, 6, 278, 60);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("User Name: ");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(30, 100, 181, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPassword.setBounds(30, 153, 181, 42);
		contentPane.add(lblPassword);
		
		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPhoneNo.setBounds(30, 207, 181, 42);
		contentPane.add(lblPhoneNo);
		
		JLabel lblCity = new JLabel("City: ");
		lblCity.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblCity.setBounds(30, 261, 181, 42);
		contentPane.add(lblCity);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 14));
		name.setBounds(241, 100, 181, 42);
		contentPane.add(name);
		name.setColumns(10);
		
		pnum = new JTextField();
		pnum.setFont(new Font("Arial", Font.PLAIN, 14));
		pnum.setColumns(10);
		pnum.setBounds(241, 207, 181, 42);
		contentPane.add(pnum);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Arial Black", Font.BOLD, 14));
		pass.setBounds(241, 153, 181, 42);
		contentPane.add(pass);
		
		JComboBox city = new JComboBox();
		city.setForeground(new Color(255, 255, 255));
		city.setBackground(new Color(40, 150, 192));
		city.setFont(new Font("Arial Black", Font.BOLD, 14));
		city.setModel(new DefaultComboBoxModel(new String[] {"Islamabad", "Lahore", "Rawalpindi", "Karachi"}));
		city.setBounds(241, 262, 181, 42);
		contentPane.add(city);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Arial Black", Font.BOLD, 14));
		gender.setBounds(30, 315, 181, 42);
		contentPane.add(gender);
		
		JLabel dob = new JLabel("DOB: ");
		dob.setFont(new Font("Arial Black", Font.BOLD, 14));
		dob.setBounds(241, 315, 181, 42);
		contentPane.add(dob);
	
		
		if(c!=null) {
			name.setText(c.getName());
			pass.setText(c.getPassword());
			pnum.setText(c.getPhone());
			city.setSelectedItem(c.getCity());
			dob.setText("DOB: " + c.getDob());
			gender.setText("Gender: " + c.getGender());
		}
		
		JLabel er = new JLabel("Error: Invalid/Missing Info");
		er.setForeground(new Color(255, 255, 255));
		er.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
		er.setBounds(161, 350, 129, 29);
		contentPane.add(er);
	
		JButton submit = new JButton("UPDATE");
		submit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (name.getText().equals("")) {
		            er.setForeground(Color.RED);
		        } else if (new String(pass.getPassword()).equals("")) {
		            er.setForeground(Color.RED);
		        } else if (pnum.getText().equals("")) {
		            er.setForeground(Color.RED);
		        } else {
		            c.setName(name.getText());
		            c.setPassword(new String(pass.getPassword()));
		            c.setCity(String.valueOf(city.getSelectedItem()));
		            c.setPhone(pnum.getText());
		            c.update();
		            dispose();
		        }
		    }
		});
		submit.setBackground(new Color(40, 150, 192));
		submit.setForeground(new Color(255, 255, 255));
		submit.setFont(new Font("Arial Black", Font.BOLD, 14));
		submit.setBounds(64, 391, 129, 35);
		contentPane.add(submit);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		cancel.setBackground(new Color(40, 150, 192));
		cancel.setBounds(257, 391, 129, 35);
		contentPane.add(cancel);
		
	}
	
	public CInfo(Worker ww) {
		w=ww;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 150, 192));
		panel.setBounds(0, 0, 452, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("A C C O U N T   I N F O");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_4.setBounds(87, 6, 278, 60);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("User Name: ");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(30, 84, 181, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPassword.setBounds(30, 137, 181, 42);
		contentPane.add(lblPassword);
		
		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPhoneNo.setBounds(30, 191, 181, 42);
		contentPane.add(lblPhoneNo);
		
		JLabel lblCity = new JLabel("City: ");
		lblCity.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblCity.setBounds(30, 245, 181, 42);
		contentPane.add(lblCity);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 14));
		name.setBounds(241, 84, 181, 42);
		contentPane.add(name);
		name.setColumns(10);
		
		pnum = new JTextField();
		pnum.setFont(new Font("Arial", Font.PLAIN, 14));
		pnum.setColumns(10);
		pnum.setBounds(241, 191, 181, 42);
		contentPane.add(pnum);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Arial Black", Font.BOLD, 14));
		pass.setBounds(241, 137, 181, 42);
		contentPane.add(pass);
		
		JComboBox city = new JComboBox();
		city.setForeground(new Color(255, 255, 255));
		city.setBackground(new Color(40, 150, 192));
		city.setFont(new Font("Arial Black", Font.BOLD, 14));
		city.setModel(new DefaultComboBoxModel(new String[] {"Islamabad", "Lahore", "Rawalpindi", "Karachi"}));
		city.setBounds(241, 246, 181, 42);
		contentPane.add(city);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Arial Black", Font.BOLD, 14));
		gender.setBounds(30, 407, 181, 42);
		contentPane.add(gender);
		
		JLabel dob = new JLabel("DOB: ");
		dob.setFont(new Font("Arial Black", Font.BOLD, 14));
		dob.setBounds(241, 407, 181, 42);
		contentPane.add(dob);
		
		JComboBox skill = new JComboBox();
		skill.setModel(new DefaultComboBoxModel(new String[] {"Electrician", "Plumber", "Gardener", "Carpenter"}));
		skill.setForeground(new Color(255, 255, 255));
		skill.setBackground(new Color(40, 150, 192));
		skill.setFont(new Font("Arial Black", Font.BOLD, 14));
		skill.setBounds(241, 299, 181, 42);
		contentPane.add(skill);
		
		fee = new JTextField();
		fee.setFont(new Font("Arial", Font.PLAIN, 14));
		fee.setColumns(10);
		fee.setBounds(241, 353, 181, 42);
		contentPane.add(fee);
		
		
		if(w!=null) {
			name.setText(w.getName());
			pass.setText(w.getPassword());
			pnum.setText(w.getPhone());
			city.setSelectedItem(w.getCity());
			dob.setText("DOB: " + w.getDob());
			skill.setSelectedItem(w.getSkill());
			fee.setText(String.valueOf(String.valueOf(w.getFee())));
			gender.setText("Gender: " + w.getGender());
		}
		
		JLabel er = new JLabel("Error: Invalid/Missing Info");
		er.setForeground(new Color(255, 255, 255));
		er.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
		er.setBounds(162, 444, 129, 29);
		contentPane.add(er);
	
		JButton submit = new JButton("UPDATE");
		submit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (name.getText().equals("")) {
		            er.setForeground(Color.RED);
		        } else if (new String(pass.getPassword()).equals("")) {
		            er.setForeground(Color.RED);
		        } else if (pnum.getText().equals("")) {
		            er.setForeground(Color.RED);
		        } else if (fee.getText().equals("")) {
		            er.setForeground(Color.RED);
		        }
		        
		        else {
		            w.setName(name.getText());
		            w.setPassword(new String(pass.getPassword()));
		            w.setCity(String.valueOf(city.getSelectedItem()));
		            w.setPhone(pnum.getText());
		            w.setSkill(String.valueOf(skill.getSelectedItem()));
		            w.setFee(Double.valueOf(fee.getText()));
		            w.update();
		            dispose();
		        }
		    }
		});
		submit.setBackground(new Color(40, 150, 192));
		submit.setForeground(new Color(255, 255, 255));
		submit.setFont(new Font("Arial Black", Font.BOLD, 14));
		submit.setBounds(65, 485, 129, 35);
		contentPane.add(submit);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		cancel.setBackground(new Color(40, 150, 192));
		cancel.setBounds(259, 485, 129, 35);
		contentPane.add(cancel);
		
		JLabel lblSkill = new JLabel("Skill: ");
		lblSkill.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSkill.setBounds(30, 299, 181, 42);
		contentPane.add(lblSkill);
		
		JLabel lblFee = new JLabel("Fee: ");
		lblFee.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblFee.setBounds(30, 353, 181, 42);
		contentPane.add(lblFee);
		
		
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CInfo frame = new CInfo(new Worker());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
