package frontend;

import Modules.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WWindow extends JFrame {
	private JLabel welcomeLabel;
	private Worker w;
	private JPanel centerPanel;
    private JButton ub;
	private static final long serialVersionUID = 1L;

    
    
    public WWindow(Worker ww) {
    	w=ww;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 600);

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
        leftPanel.setLayout(new GridLayout(5, 1, 10, 10));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton bWallet = createButton("Wallet");
        JButton bAppointment = createButton("Appointment");
        JButton bHome = createButton("Home");
        JButton bExit = createButton("Exit");
        JButton bReview = createButton("Reviews");

        leftPanel.add(bHome);
        leftPanel.add(bAppointment);
        leftPanel.add(bReview);
        leftPanel.add(bWallet);
        leftPanel.add(bExit);

        getContentPane().add(leftPanel, BorderLayout.WEST);

        centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        centerPanel.setBackground(Color.white);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JLabel nl = new JLabel("Name: ");
        nl.setFont(new Font("Arial Black", Font.BOLD, 14));
        nl.setBounds(82, 79, 218, 45);
        centerPanel.add(nl);
        
        JLabel pl = new JLabel("Phone No: ");
        pl.setFont(new Font("Arial Black", Font.BOLD, 14));
        pl.setBounds(382, 79, 218, 45);
        centerPanel.add(pl);
        
        JLabel gl = new JLabel("Gender: ");
        gl.setFont(new Font("Arial Black", Font.BOLD, 14));
        gl.setBounds(82, 135, 218, 45);
        centerPanel.add(gl);
        
        JLabel dl = new JLabel("DOB:  ");
        dl.setFont(new Font("Arial Black", Font.BOLD, 14));
        dl.setBounds(382, 135, 218, 45);
        centerPanel.add(dl);
        
        JLabel cl = new JLabel("City: ");
        cl.setFont(new Font("Arial Black", Font.BOLD, 14));
        cl.setBounds(82, 185, 218, 45);
        centerPanel.add(cl);

        JLabel sl = new JLabel("Skill: ");
        sl.setFont(new Font("Arial Black", Font.BOLD, 14));
        sl.setBounds(382, 191, 218, 45);
        centerPanel.add(sl);
        
        JLabel fl = new JLabel("Fee: ");
        fl.setFont(new Font("Arial Black", Font.BOLD, 14));
        fl.setBounds(233, 241, 218, 45);
        centerPanel.add(fl);
        
        ub = new JButton("UPDATE");
        ub.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CInfo ww=new CInfo(w);
        		ww.setVisible(true);
        	}
        });
        
        ub.setForeground(new Color(255, 255, 255));
        ub.setBackground(new Color(40, 150, 192));
        ub.setFont(new Font("Arial Black", Font.BOLD, 14));
        ub.setBounds(260, 323, 161, 37);
        centerPanel.add(ub);
        

        if(w!=null) {
        	nl.setText("Name: " + w.getName());
        	pl.setText("Phone No: " + w.getPhone());
        	gl.setText("Gender: " + w.getGender());
        	cl.setText("City: "+w.getCity());
        	dl.setText("DOB: " + w.getDob());
        	sl.setText("Skill: "+w.getSkill());
        	fl.setText("Fee: " + String.valueOf(w.getFee()));
        }
        
        
        setVisible(true);
    }

    private void HomeButton(Worker w) {
    	
    	getContentPane().remove(centerPanel); 
    	centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.white);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JLabel nl = new JLabel("Name: ");
        nl.setFont(new Font("Arial Black", Font.BOLD, 14));
        nl.setBounds(82, 79, 218, 45);
        centerPanel.add(nl);
        
        JLabel pl = new JLabel("Phone No: ");
        pl.setFont(new Font("Arial Black", Font.BOLD, 14));
        pl.setBounds(382, 79, 218, 45);
        centerPanel.add(pl);
        
        JLabel gl = new JLabel("Gender: ");
        gl.setFont(new Font("Arial Black", Font.BOLD, 14));
        gl.setBounds(82, 135, 218, 45);
        centerPanel.add(gl);
        
        JLabel dl = new JLabel("DOB:  ");
        dl.setFont(new Font("Arial Black", Font.BOLD, 14));
        dl.setBounds(382, 135, 218, 45);
        centerPanel.add(dl);
        
        JLabel cl = new JLabel("City: ");
        cl.setFont(new Font("Arial Black", Font.BOLD, 14));
        cl.setBounds(82, 185, 218, 45);
        centerPanel.add(cl);
        
        JLabel sl = new JLabel("Skill: ");
        sl.setFont(new Font("Arial Black", Font.BOLD, 14));
        sl.setBounds(382, 191, 218, 45);
        centerPanel.add(sl);
        
        JLabel fl = new JLabel("Fee: ");
        fl.setFont(new Font("Arial Black", Font.BOLD, 14));
        fl.setBounds(233, 241, 218, 45);
        centerPanel.add(fl);
        
        
        
        centerPanel.add(ub);

        if(w!=null) {
        	nl.setText("Name: " + w.getName());
        	pl.setText("Phone No: " + w.getPhone());
        	gl.setText("Gender: " + w.getGender());
        	cl.setText("City: " + w.getCity());
        	dl.setText("DOB: " + w.getDob());
        	sl.setText("Skill: "+w.getSkill());
        	fl.setText("Fee: " + String.valueOf(w.getFee()));
        }
        
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
                if (buttonText.equals("Wallet")) {
                	   	welcomeLabel.setText("W  A  L  L  E  T");
                	   	getContentPane().remove(centerPanel); 
                	    
                	    centerPanel = new WWallet(w);
                	 
                	    centerPanel.setVisible(true);
                	    getContentPane().add(centerPanel, BorderLayout.CENTER);
                	    
                	    getContentPane().revalidate();
                	    getContentPane().repaint();
                    	
                }
                if (buttonText.equals("Home")) {
                   	welcomeLabel.setText("F  I  X  I  T");
                	HomeButton(w);
                }
                if (buttonText.equals("Reviews")) {
                   	welcomeLabel.setText("R  E  V  I  E  W");
                   	getContentPane().remove(centerPanel); 
            	    
            	    centerPanel = new WReview(w);
            	 
            	    centerPanel.setVisible(true);
            	    getContentPane().add(centerPanel, BorderLayout.CENTER);
            	    
            	    getContentPane().revalidate();
            	    getContentPane().repaint();
                	
                }
                if (buttonText.equals("Appointment")) {
                   	welcomeLabel.setText("A P P O I N T M E N T");
                   	getContentPane().remove(centerPanel); 
            	    
            	    centerPanel = new WAppointment(w);
            	 
            	    centerPanel.setVisible(true);
            	    getContentPane().add(centerPanel, BorderLayout.CENTER);
            	    
            	    getContentPane().revalidate();
            	    getContentPane().repaint();
            
                }
            }
        });
        return button;
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Worker w = new Worker();
            w.setName("");
            w.setPhone("");
            w.setCity("");
            w.setGender("");
            w.setDob("");
            WWindow ww=new WWindow(w);
        });
    }
}
