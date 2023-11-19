package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modules.*;

public class registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JPasswordField passwordField;
	private JTextField fee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
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
	public registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 814, 531);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_1.setBounds(295, 98, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2.setBounds(295, 123, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		
		name = new JTextField();
		name.setBounds(381, 95, 121, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		final JComboBox city = new JComboBox();
		city.setFont(new Font("Arial", Font.ITALIC, 11));
		city.setForeground(new Color(0, 0, 0));
		city.setBackground(new Color(192, 192, 192));
		city.setModel(new DefaultComboBoxModel(new String[] {"Select City", "Islamabad", "Lahore ", "Karachi", "Rawalpindi"}));
		city.setSelectedIndex(0);
		city.setBounds(291, 234, 207, 22);
		contentPane.add(city);

		final JComboBox skill = new JComboBox();
		skill.setFont(new Font("Arial", Font.ITALIC, 11));
		skill.setEnabled(false);
		skill.setModel(new DefaultComboBoxModel(new String[] {"Select Skill", "Plumber", "Electrician", "Carpenter", "Gardener"}));
		skill.setSelectedIndex(0);
		skill.setForeground(Color.BLACK);
		skill.setBackground(Color.LIGHT_GRAY);
		skill.setBounds(291, 300, 207, 22);
		contentPane.add(skill);
		
	
		final JLabel feeLabel = new JLabel("Fee");
		feeLabel.setForeground(new Color(255, 255, 255));
		feeLabel.setFont(new Font("Arial Black", Font.BOLD, 11));
		feeLabel.setBounds(289, 336, 76, 14);
		contentPane.add(feeLabel);
		
		fee = new JTextField();
		fee.setBackground(new Color(255, 255, 255));
		fee.setColumns(10);
		fee.setBounds(375, 333, 121, 20);
		contentPane.add(fee);
		
	
		
		final JComboBox accType = new JComboBox();
		accType.setFont(new Font("Arial", Font.ITALIC, 11));
		accType.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedAccountType = (String) accType.getSelectedItem();

		        if ("Worker".equals(selectedAccountType)) {
		            skill.setEnabled(true);
		            feeLabel.setForeground(Color.BLACK);
		            fee.setEnabled(true);
		            fee.setBackground(Color.white);
		    		            
		        } else {
		            skill.setEnabled(false);
		            fee.setEnabled(false);
		            feeLabel.setForeground(Color.white);
		            fee.setBackground(Color.WHITE);
		    		}
		    }
		});
		
		accType.setModel(new DefaultComboBoxModel(new String[] {"Select Account Type", "Customer", "Worker"}));
		accType.setSelectedIndex(0);
		accType.setMaximumRowCount(3);
		accType.setForeground(Color.BLACK);
		accType.setBackground(Color.LIGHT_GRAY);
		accType.setBounds(291, 267, 207, 22);
		contentPane.add(accType);
		
		JLabel lblNewLabel_5 = new JLabel("Phone No");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_5.setBounds(295, 148, 91, 14);
		contentPane.add(lblNewLabel_5);
		
		phone = new JTextField();
		phone.setBounds(381, 145, 121, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		final JLabel error = new JLabel("");
		error.setBackground(new Color(255, 0, 0));
		error.setVerticalAlignment(SwingConstants.TOP);
		error.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		error.setForeground(new Color(255, 0, 0));
		error.setBounds(315, 396, 168, 22);
		contentPane.add(error);
	
		passwordField = new JPasswordField();
		passwordField.setBounds(381, 121, 121, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_5_1 = new JLabel("Gender");
		lblNewLabel_5_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_5_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_5_1.setBounds(295, 173, 91, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("DOB");
		lblNewLabel_5_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_5_2.setBounds(295, 198, 28, 25);
		contentPane.add(lblNewLabel_5_2);
		
		final JRadioButton gMale = new JRadioButton("Male");
        gMale.setFont(new Font("Arial Black", Font.BOLD, 11));
        gMale.setBackground(new Color(255, 255, 255));
        gMale.setBounds(357, 169, 66, 23);
        contentPane.add(gMale);

        JRadioButton gFemale = new JRadioButton("Female");
        gFemale.setFont(new Font("Arial Black", Font.BOLD, 11));
        gFemale.setBackground(new Color(255, 255, 255));
        gFemale.setBounds(419, 170, 89, 23);
        contentPane.add(gFemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(gMale);
        genderGroup.add(gFemale);
		
		final JComboBox DOD = new JComboBox();
		DOD.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", ""}));
		DOD.setSelectedIndex(0);
		DOD.setMaximumRowCount(32);
		DOD.setBounds(333, 198, 44, 25);
		contentPane.add(DOD);
		
		final JComboBox DOM = new JComboBox();
		DOM.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12 "}));
		DOM.setMaximumRowCount(13);
		DOM.setBounds(382, 198, 56, 25);
		contentPane.add(DOM);
		
		final JComboBox DOY = new JComboBox();
		DOY.setMaximumRowCount(30);
		DOY.setModel(new DefaultComboBoxModel(new String[] {"YYYY", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005"}));
		DOY.setSelectedIndex(0);
		DOY.setBounds(442, 198, 56, 25);
		contentPane.add(DOY);
		
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Arial Black", Font.BOLD, 11));
		submit.setBounds(289, 422, 89, 23);
		contentPane.add(submit);

		submit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if all required fields are filled
		        if (name.getText().isEmpty() || passwordField.getPassword().length == 0 ||
		            phone.getText().isEmpty() || accType.getSelectedIndex() == 0 ||
		            (accType.getSelectedItem().equals("Worker") && skill.getSelectedIndex() == 0) ||
		            DOD.getSelectedIndex() == 0 || DOM.getSelectedIndex() == 0 || DOY.getSelectedIndex() == 0) {
		            error.setText("Error: Missing/Invalid Info.");
		            return; // Stop further processing if any field is empty
		        }

		        if (accType.getSelectedItem().equals("Customer")) {
		        Customer c= new Customer();      
		        c.setName(name.getText());
		        c.setPassword(new String(passwordField.getPassword()));
		        c.setCity(city.getSelectedItem().toString());
		        c.setPhone(phone.getText());
		        c.setGender(gMale.isSelected() ? "Male" : "Female");
		        c.setDob(DOY.getSelectedItem() + "-" + DOM.getSelectedItem() + "-" + DOD.getSelectedItem());
		        c.Register();
		        error.setText("");
		        Login lg=new Login();
		        lg.setVisible(true);
		        dispose();
		        }
		        
		        else if (accType.getSelectedItem().equals("Worker")) {
		        	Worker c= new Worker();      
			        c.setName(name.getText());
			        c.setPassword(new String(passwordField.getPassword()));
			        c.setCity(city.getSelectedItem().toString());
			        c.setPhone(phone.getText());
			        c.setGender(gMale.isSelected() ? "Male" : "Female");
			        c.setDob(DOY.getSelectedItem() + "-" + DOM.getSelectedItem() + "-" + DOD.getSelectedItem());
			        c.setSkill(skill.getSelectedItem().toString());
			        c.setFee(Double.parseDouble(fee.getText()));
			        c.Register();
			        error.setText("");
			        Login lg=new Login();
			        lg.setVisible(true);
			        dispose();
			            
			        	
		        }
		        
		        else {
		        	error.setText("Error: Missing/Invalid Info.");
		        }
		        
		    }
		});

		JButton back = new JButton("Cancel");
		back.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		back.setForeground(new Color(255, 0, 0));
		back.setBounds(419, 422, 89, 23);
		contentPane.add(back);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 150, 191));
		panel.setBounds(0, 0, 105, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("R");
		lblNewLabel.setBounds(41, 28, 23, 31);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblE = new JLabel("E");
		lblE.setBounds(41, 87, 23, 31);
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Arial Black", Font.BOLD, 16));
		panel.add(lblE);
		
		JLabel lblNewLabel_3_1 = new JLabel("G");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(41, 146, 23, 31);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("I");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(47, 205, 11, 21);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("S");
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(41, 254, 23, 31);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("T");
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_3_4.setBounds(41, 313, 23, 31);
		panel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("E");
		lblNewLabel_3_5.setForeground(Color.WHITE);
		lblNewLabel_3_5.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_3_5.setBounds(41, 372, 23, 31);
		panel.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("R");
		lblNewLabel_3_6.setForeground(Color.WHITE);
		lblNewLabel_3_6.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_3_6.setBounds(41, 431, 23, 31);
		panel.add(lblNewLabel_3_6);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login registrationWindow = new Login();
	               registrationWindow.setVisible(true);

	                dispose();
	}
		});

	
	
	
	
	}
}
