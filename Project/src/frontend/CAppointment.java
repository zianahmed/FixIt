package frontend;

import Modules.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CAppointment extends JPanel {
	private Customer c;
	private Service sw;
	ArrayList<Service> services;
	private JTable sTable;
	private DefaultTableModel model;
	
	private static final long serialVersionUID = 1L;

	
	public CAppointment(Customer c) {
		this.c=c;
		this.sw = new Service();
		setLayout(null);
		
		
	    model = new DefaultTableModel();
        model.addColumn("Worker Name");
        model.addColumn("Type");
        model.addColumn("Date");
        model.addColumn("Fee");
		
        JPanel ptable = new JPanel();
		ptable.setBounds(10, 70, 590, 287);
		ptable.setVisible(true);
		add(ptable);
		
		sTable = new JTable(model);
        sTable.setFont(new Font("Arial", Font.PLAIN, 12));
        sTable.setForeground(Color.WHITE);
        sTable.setBackground(new Color(40, 150, 192));
        sTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        sTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        sTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        sTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        
        sTable.setModel(model);
        addTableMouseListener();

        sTable.setModel(model);
        addTableMouseListener();

        JScrollPane scrollPane = new JScrollPane(sTable); 
        scrollPane.setBounds(0, 0, 590, 287); 
        ptable.add(scrollPane);
        
        
		JComboBox status = new JComboBox();
		
		status.setBackground(new Color(40, 150, 192));
		status.setForeground(new Color(255, 255, 255));
		status.setModel(new DefaultComboBoxModel(new String[] {"Status", "Pending", "Confirmed", "Payment", "Review", "Completed"}));
		status.setFont(new Font("Arial Black", Font.BOLD, 12));
		status.setBounds(212, 23, 185, 31);
		add(status);
		
		
		
		
		
		
		JButton detail = new JButton("DETAILS");
		detail.setEnabled(false);
		detail.setFont(new Font("Arial Black", Font.BOLD, 12));
		detail.setBackground(new Color(40, 150, 192));
		detail.setForeground(new Color(255, 255, 255));
		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sw!=null) {
					CDetails cv=new CDetails();
					cv.Assign(sw);
					cv.setVisible(true);
				}
			}
		});
		detail.setBounds(100, 383, 185, 31);
		add(detail);
		
		JButton action = new JButton("ACTION");
		action.setEnabled(false);
		action.setForeground(Color.WHITE);
		action.setFont(new Font("Arial Black", Font.BOLD, 12));
		action.setBackground(new Color(40, 150, 192));
		action.setBounds(355, 383, 185, 31);
		add(action);
		action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sw!=null) {
					if ("CANCEL"==action.getText()) {
						CCancel cv=new CCancel();
						cv.Assign(sw.getId(),1);
						cv.setVisible(true);
					}
					
					else if("COMPLETE"==action.getText()) {
						CCancel cv=new CCancel();
						sw.updateStatus(sw.getId(),"Payment");
						cv.Assign(sw.getId(),2);
						cv.setVisible(true);
					}
					
					else if("REVIEW"==action.getText()) {
						CReview cr=new CReview();
						cr.Assign(sw);
						cr.setVisible(true);
					}
					
					if(c!=null) {
						int cid=c.getId();
						String s=status.getSelectedItem().toString();
						services=sw.cService(cid, s);
			            model.setRowCount(0);
			            for (Service service : services) {
	                        model.addRow(new Object[]{service.getwName(),service.getType(),service.getDate(),service.getDate(),service.getFee()});
	                    }
	                    
	                    sTable.setModel(model);
	                    
	                    revalidate();
	                    repaint();

					}
					
				}
			}
		});
		
		status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(status.getSelectedIndex()==0) { 
					model.setRowCount(0);
					detail.setEnabled(false);
					action.setEnabled(false);	
					action.setText("");
				} 
				
				else if (status.getSelectedIndex()>0) {
					if(c!=null) {
						int cid=c.getId();
						String s=status.getSelectedItem().toString();
						services=sw.cService(cid, s);
			            model.setRowCount(0);
			            for (Service service : services) {
	                        model.addRow(new Object[]{service.getwName(),service.getType(),service.getDate(),service.getDate(),service.getFee()});
	                    }
	                    
	                    sTable.setModel(model);
	                    
	                    revalidate();
	                    repaint();

					}
					
					
					if (status.getSelectedIndex()==1) {
						detail.setEnabled(true);
						action.setEnabled(true);
						action.setText("CANCEL");
						
					}
					else if	(status.getSelectedIndex()==2) {
						detail.setEnabled(true);
						action.setEnabled(true);
						action.setText("COMPLETE");
					}
					else if	(status.getSelectedIndex()==3) {
						detail.setEnabled(true);
						action.setEnabled(true);
						action.setText("PAY");
					}
					else if	(status.getSelectedIndex()==4) {
						detail.setEnabled(true);
						action.setEnabled(true);
						action.setText("REVIEW");
					}
					else if	(status.getSelectedIndex()==5) {
						detail.setEnabled(true);
						action.setEnabled(false);
						action.setText("");
					}
					
				}
			}
		});
	}
		private void addTableMouseListener() {
	        sTable.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int selectedRow = sTable.getSelectedRow();
	                if (selectedRow != -1) {
	                	sw=services.get(sTable.getSelectedRow());
	                }
	            }
	        });

		
	}
}
