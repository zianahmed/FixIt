package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modules.*;

public class WWallet extends JPanel {
	Worker w;
	double am;
	private static final long serialVersionUID = 1L;
	private JTextField accT;
	private JTextField accN;
	private JTextField amount;

	
	
	public WWallet(Worker w) {
		this.w=w;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel bal = new JLabel("Balance: ");
		bal.setFont(new Font("Arial Black", Font.BOLD, 14));
		bal.setBounds(191, 11, 206, 43);
		add(bal);
		
		JLabel lblNewWithdrawal = new JLabel("New Withdrawal ");
		lblNewWithdrawal.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewWithdrawal.setBounds(10, 65, 206, 43);
		add(lblNewWithdrawal);
		
		JLabel lblNewLabel_1 = new JLabel("Account Title: ");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(58, 119, 206, 43);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account Name: ");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_2.setBounds(58, 173, 206, 43);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Bank: ");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_3.setBounds(58, 227, 206, 43);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount: ");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_4.setBounds(58, 281, 206, 43);
		add(lblNewLabel_4);
		
		accT = new JTextField();
		accT.setFont(new Font("Arial Black", Font.PLAIN, 14));
		accT.setBounds(322, 119, 206, 43);
		add(accT);
		accT.setColumns(10);
		
		accN = new JTextField();
		accN.setFont(new Font("Arial Black", Font.PLAIN, 14));
		accN.setColumns(10);
		accN.setBounds(322, 173, 206, 43);
		add(accN);
		
		amount = new JTextField();
		amount.setFont(new Font("Arial Black", Font.PLAIN, 14));
		amount.setColumns(10);
		amount.setBounds(322, 281, 206, 43);
		add(amount);
		
		if(w!=null) {
			am=w.getBal();
			accT.setText(w.getName());
			accN.setText(w.getPhone());
			bal.setText("Balance: " + String.valueOf(am));
		}
		
		
		
		JComboBox bank = new JComboBox();
		bank.setModel(new DefaultComboBoxModel(new String[] {"SadaPay", "EasyPaisa", "JazzCash"}));
		bank.setBackground(new Color(40, 150, 192));
		bank.setForeground(new Color(255, 255, 255));
		bank.setFont(new Font("Arial Black", Font.BOLD, 14));
		bank.setBounds(322, 227, 206, 43);
		add(bank);
		
		
		JButton wButton = new JButton("WITHDRAW");
		wButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		wButton.setForeground(new Color(255, 255, 255));
		wButton.setBackground(new Color(40, 150, 192));
		wButton.setBounds(216, 375, 156, 43);
		add(wButton);
		
		JLabel err = new JLabel("Error: Missing/Invalid Info");
		err.setForeground(Color.WHITE);
		err.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		err.setBounds(212, 320, 163, 43);
		add(err);
		
		wButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double wam=Double.MAX_VALUE;
			if (amount.getText().equals(""));
			else  
				wam= Double.valueOf(amount.getText());
			
			if(wam>am)
				err.setForeground(Color.red);
			else if(accT.getText().equals(""))
				err.setForeground(Color.red);
			else if(accN.getText().equals(""))
				err.setForeground(Color.red);
			else {
				Withdraw wd=new Withdraw();
				wd.setAccNum(accN.getText());
				wd.setAccTitle(accT.getText());
				wd.setBank(bank.getSelectedItem().toString());
				wd.setAmount(wam);
				wd.setWid(w.getId());
				wd.makeWithdraw();
				am-=wam;
				bal.setText("Balance: "+ am);
				
			}	
			}
		});
		
	}
}
