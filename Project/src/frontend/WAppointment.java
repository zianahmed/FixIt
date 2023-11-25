package frontend;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modules.*;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class WAppointment extends JPanel {
	Worker w;
	private Service sw=new Service();
	ArrayList<Service> services=new ArrayList<Service>();
	private JTable sTable;
	private DefaultTableModel model;
	
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * Create the panel.
	 */
	public WAppointment(Worker w) {
		this.w=w;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		model = new DefaultTableModel();
        model.addColumn("Customer Name");
        model.addColumn("Type");
        model.addColumn("Date");
        model.addColumn("Details");
		model.addColumn("Status");
		
        JPanel ptable = new JPanel();
		ptable.setBounds(10, 70, 590, 287);
		ptable.setVisible(true);
		ptable.setBackground(Color.WHITE);
		add(ptable);
		
		sTable = new JTable(model);
        sTable.setFont(new Font("Arial", Font.PLAIN, 12));
        sTable.setForeground(Color.WHITE);
        sTable.setBackground(new Color(40, 150, 192));
        sTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        sTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        sTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        sTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        sTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        addTableMouseListener();
        sTable.setModel(model);

        JScrollPane scrollPane = new JScrollPane(sTable); 
        scrollPane.setBounds(0, 0, 590, 287); 
        ptable.add(scrollPane);

		
		
		
		
		
		JComboBox status = new JComboBox();
		status.setForeground(new Color(255, 255, 255));
		status.setModel(new DefaultComboBoxModel(new String[] {"STATUS", "NEW", "ACCEPTED"}));
		status.setBackground(new Color(40, 150, 192));
		status.setFont(new Font("Arial Black", Font.BOLD, 14));
		status.setBounds(215, 28, 195, 40);
		add(status);
		
		JButton detail = new JButton("VIEW DETAILS");
		detail.setFont(new Font("Arial Black", Font.BOLD, 14));
		detail.setForeground(new Color(255, 255, 255));
		detail.setBackground(new Color(40, 150, 192));
		detail.setBounds(236, 379, 156, 40);
		add(detail);
		
		JButton action = new JButton("ACCEPT");
		action.setForeground(Color.WHITE);
		action.setFont(new Font("Arial Black", Font.BOLD, 14));
		action.setBackground(new Color(40, 150, 192));
		action.setBounds(68, 379, 156, 40);
		add(action);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(64, 75, 497, 292);
		add(panel);
		
		JButton cancel = new JButton("CANCEL");
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		cancel.setBackground(new Color(40, 150, 192));
		cancel.setBounds(404, 379, 156, 40);
		add(cancel);
		cancel.setVisible(false);
		action.setVisible(false);
		cancel.setEnabled(false);
		action.setEnabled(false);
	
		
		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sw!=null) {
					CDetails cv=new CDetails();
					cv.Assign(sw,1);
					cv.setVisible(true);
				}
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sw!=null) {
					CCancel cv=new CCancel();
					cv.Assign(sw.getId(),1);
					cv.setVisible(true);
				}
			}
		});

		
		
		action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sw!=null) {
					if ("ACCEPT"==action.getText()) {
						sw.updateStatus(sw.getId(),"Confirmed");
					}
					
					
					if(w!=null) {
						int cid=w.getId();
						String s="Pending";
						services=sw.wService(cid, s);
			            model.setRowCount(0);
			            for (Service service : services) {
	                        model.addRow(new Object[]{service.getcName(),service.getDate(),service.getType(),service.getDetail(),service.getStatus()});
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
				
				if (status.getSelectedIndex()!=1) {
					cancel.setVisible(false);
					action.setVisible(false);
					cancel.setEnabled(false);
					action.setEnabled(false);
				}
				
				if (status.getSelectedItem()=="NEW") {
					cancel.setVisible(true);
					action.setVisible(true);
					cancel.setEnabled(true);
					action.setEnabled(true);
					if(w!=null) {
						int wid=w.getId();
						String s="Pending";
						services=sw.wService(wid, s);
			            model.setRowCount(0);
			            for (Service service : services) {
			                model.addRow(new Object[]{service.getcName(),service.getDate(),service.getType(),service.getDetail(),service.getStatus()});
		                }
	                    
			            sTable.setModel(model);
	                    
	                    revalidate();
	                    repaint();

					}
							
				}
				
				if (status.getSelectedItem()=="ACCEPTED") {
					cancel.setVisible(false);
					action.setVisible(false);
					cancel.setEnabled(false);
					action.setEnabled(false);
					if(w!=null) {
						int wid=w.getId();
						String s[]={"Confirmed","Payment","Review","Completed"};
						model.setRowCount(0);
			            
						for(int i=0;i<4;i++) 
							services.addAll(sw.wService(wid, s[i]));
				        
			            for (Service service : services) {
			                model.addRow(new Object[]{service.getcName(),service.getDate(),service.getType(),service.getDetail(),service.getStatus()});
		                }
			            
			            sTable.setModel(model);
	                    
	                    revalidate();
	                    repaint();

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
		            sw = services.get(selectedRow);  
		        }
		    }
		});
	}

}
