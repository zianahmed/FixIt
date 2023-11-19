package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modules.*;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JComboBox<String> accTypeComboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 748, 451);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Left Panel for "LOGIN" Text
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(40, 150, 191));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 100, 20));

        String loginText = "LOGIN";
        for (char c : loginText.toCharArray()) {
            JLabel label = new JLabel(String.valueOf(c));
            label.setFont(new Font("Arial Black", Font.BOLD, 18));
            label.setForeground(Color.WHITE);
            leftPanel.add(label);
        }

        contentPane.add(leftPanel, BorderLayout.WEST);

        // Center Panel for Login Components
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(7, 2, 0, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        centerPanel.setBackground(Color.WHITE);

        JLabel lblNewLabel_1 = new JLabel("Phone No");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
        centerPanel.add(lblNewLabel_1);

        phoneField = new JTextField();
        centerPanel.add(phoneField);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 14));
        centerPanel.add(lblNewLabel_2);

        passwordField = new JPasswordField();
        centerPanel.add(passwordField);

        accTypeComboBox = new JComboBox<>();
        accTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Customer", "Worker"}));
        centerPanel.add(accTypeComboBox);
        
                final JLabel error = new JLabel("            Error: Account Not Found!");
                error.setForeground(new Color(255, 255, 255));
                error.setFont(new Font("Arial", Font.BOLD, 14));
                centerPanel.add(error);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        centerPanel.add(loginButton);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(createAccountButton);

        contentPane.add(centerPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String phone = phoneField.getText();
                String password = new String(passwordField.getPassword());
                String accType = (String) accTypeComboBox.getSelectedItem();

                if ("Worker".equals(accType)) {
                    Worker w = new Worker();
                    w.setPhone(phone);
                    w.setPassword(password);
                    w.Login();
                    if (w.getCity().equals("")) {
                        error.setForeground(Color.RED);
                        return;
                    }
                    error.setForeground(Color.WHITE);
                } else if ("Customer".equals(accType)) {
                    Customer c = new Customer();
                    c.setPhone(phone);
                    c.setPassword(password);
                    c.Login();
                    if (c.getCity().equals("")) {
                        error.setForeground(Color.RED);
                        return;
                    }
                    error.setForeground(Color.white);
                    CWindow cw = new CWindow(c);
                    cw.setVisible(true);
                    dispose();
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registration registrationWindow = new registration();
                registrationWindow.setVisible(true);
                dispose();
            }
        });
}
}
