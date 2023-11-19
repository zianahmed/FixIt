package frontend;

import Modules.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CWindow extends JFrame {
	private JLabel welcomeLabel;
	private Customer c;
	private JPanel centerPanel;
    private static final long serialVersionUID = 1L;

    public CWindow(Customer customer) {
    	c=customer;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 600);

        // Top Panel for Welcome Message
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(40, 150, 191));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        welcomeLabel = new JLabel("F  I  X  I  T");
        welcomeLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel);

        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Left Panel for Buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(40, 150, 191));
        leftPanel.setLayout(new GridLayout(4, 1, 10, 10));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton bSearch = createButton("Search");
        JButton bAppointment = createButton("Appointment");
        JButton bHome = createButton("Home");
        JButton bExit = createButton("Exit");

        leftPanel.add(bHome);
        leftPanel.add(bSearch);
        leftPanel.add(bAppointment);
        leftPanel.add(bExit);

        getContentPane().add(leftPanel, BorderLayout.WEST);

        // Center Panel for Customer Information
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1, 0, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        addLabel(centerPanel, "Name: " + customer.getName());
        addLabel(centerPanel, "Phone: " + customer.getPhone());
        addLabel(centerPanel, "City: " + customer.getCity());
        addLabel(centerPanel, "Gender: " + customer.getGender());
        addLabel(centerPanel, "DOB: " + customer.getDob());

        getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    private void HomeButton(Customer customer) {
    	
    	getContentPane().remove(centerPanel); // Remove the current centerPanel
    	centerPanel = new JPanel();
	    
	    
	    centerPanel.setLayout(new GridLayout(5, 1, 0, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        addLabel(centerPanel, "Name: " + customer.getName());
        addLabel(centerPanel, "Phone: " + customer.getPhone());
        addLabel(centerPanel, "City: " + customer.getCity());
        addLabel(centerPanel, "Gender: " + customer.getGender());
        addLabel(centerPanel, "DOB: " + customer.getDob());

        getContentPane().add(centerPanel, BorderLayout.CENTER);
	    
	    getContentPane().revalidate();
	    getContentPane().repaint();
	    
    }
    
    private JButton createButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setFont(new Font("Arial Black", Font.BOLD, 12));
        button.setBackground(new Color(0, 128, 192));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonText=="Exit") {
                	Login lg=new Login();
                	lg.setVisible(true);
                	dispose();
                }
                if (buttonText.equals("Search")) {
                	   	welcomeLabel.setText("S  E  A  R  C  H");
                		getContentPane().remove(centerPanel); 
                	    
                	    centerPanel = new CSearch(c);
                	    centerPanel.setVisible(true);
                	    
                	    getContentPane().add(centerPanel, BorderLayout.CENTER);
                	    
                	    getContentPane().revalidate();
                	    getContentPane().repaint();
                }
                if (buttonText.equals("Home")) {
                   	welcomeLabel.setText("F  I  X  I  T");
                	HomeButton(c);
                }
                if (buttonText.equals("Appointment")) {
                   	welcomeLabel.setText("A P P O I N T M E N T");
                	getContentPane().remove(centerPanel); 
            	    
            	    centerPanel = new CAppointment(c);
            	 
            	    centerPanel.setVisible(true);
            	    getContentPane().add(centerPanel, BorderLayout.CENTER);
            	    
            	    getContentPane().revalidate();
            	    getContentPane().repaint();
            }
            }
        });
        return button;
    }

    private void addLabel(JPanel panel, String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial Black", Font.BOLD, 14));
        panel.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Customer customer = new Customer();
            customer.setName("");
            customer.setPhone("");
            customer.setCity("");
            customer.setGender("");
            customer.setDob("");

            CWindow cWindow = new CWindow(customer);
        });
    }
}
