package frontend;

import Modules.*;
import Database.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CSearch extends JPanel {
	private Customer c;
	private Worker sw;
	private JButton bAppoint;
	private JButton bReview;
	
	ArrayList<Worker> workers;
	private JTable workerTable;
	private DefaultTableModel model;
	
	private static final long serialVersionUID = 1L;

	public CSearch(Customer c) {
		this.c=c;
		setLayout(null);
	
		
		
		    model = new DefaultTableModel();
	        model.addColumn("Name");
	        model.addColumn("Fee");
	        model.addColumn("Rating");

		
		final JComboBox city = new JComboBox();
		city.setFont(new Font("Arial Black", Font.PLAIN, 12));
		city.setForeground(Color.white);
		city.setBackground(new Color(40, 150, 192));
		city.setModel(new DefaultComboBoxModel(new String[] {"Select City", "Islamabad", "Lahore ", "Karachi", "Rawalpindi"}));
		city.setSelectedIndex(0);
		city.setBounds(335, 36, 207, 31);
		add(city);

		final JComboBox skill = new JComboBox();
		
		skill.setFont(new Font("Arial Black", Font.PLAIN, 12));
		skill.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "Plumber", "Electrician", "Carpenter", "Gardener"}));
		skill.setSelectedIndex(0);
		skill.setForeground(Color.white);
		skill.setBackground(new Color(40, 150, 192));
		skill.setBounds(64, 36, 207, 31);
		add(skill);
		
		
		
		JPanel pTable = new JPanel();
        pTable.setBounds(64, 85, 478, 279);
        add(pTable);

        workerTable = new JTable(model);
        workerTable.setFont(new Font("Arial", Font.PLAIN, 12));
        workerTable.setForeground(Color.WHITE);
        workerTable.setBackground(new Color(40, 150, 192));
        workerTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        workerTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        workerTable.getColumnModel().getColumn(2).setPreferredWidth(50);

        workerTable.setModel(model);
        addTableMouseListener();

        pTable.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(workerTable);
        pTable.add(scrollPane, BorderLayout.CENTER);
        addTableMouseListener();
		
		
		bReview = new JButton("View Reivews");
		bReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sw!=null) {
					CView cv=new CView(sw);
					cv.setVisible(true);
				}
				
		}
		});
		bReview.setFont(new Font("Arial Black", Font.BOLD, 11));
		bReview.setForeground(new Color(255, 255, 255));
		bReview.setBackground(new Color(40, 150, 192));
		bReview.setBounds(113, 414, 137, 31);
		add(bReview);
		
		bAppoint = new JButton("Book");
		bAppoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sw!=null && c!=null) {
					CBook cwin=new CBook();
					cwin.intialize(c, sw);
					cwin.setVisible(true);
				}
				
			}
		});
		
		bAppoint.setForeground(Color.WHITE);
		bAppoint.setFont(new Font("Arial Black", Font.BOLD, 11));
		bAppoint.setBackground(new Color(50, 140, 192));
		bAppoint.setBounds(363, 414, 137, 31);
		add(bAppoint);

		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 0, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        skill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (skill.getSelectedIndex() > 0 && city.getSelectedIndex() > 0) {
                    String s = skill.getSelectedItem().toString();
                    String c = city.getSelectedItem().toString();
                    Database db = new Database();
                    model.setRowCount(0);
                    workers = db.getWorker(s, c);
                    for (Worker worker : workers) {
                        model.addRow(new Object[]{worker.getName(), worker.getFee(), worker.getRating()});
                    }

                    workerTable.setModel(model);
                    
                    revalidate();
                    repaint();
                } else {
                    model.setRowCount(0);
                }
            }
        });

        city.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (skill.getSelectedIndex() > 0 && city.getSelectedIndex() > 0) {
                    String s = skill.getSelectedItem().toString();
                    String c = city.getSelectedItem().toString();
                    Database db = new Database();
                    workers = db.getWorker(s, c);
                    model.setRowCount(0);
                    for (Worker worker : workers) {
                        model.addRow(new Object[]{worker.getName(), worker.getFee(), worker.getRating()});
                    }

                    workerTable.setModel(model);
                    
                    revalidate();
                    repaint();
                } else {
                    model.setRowCount(0);
                }
            }
        });
	}
	
	private void addTableMouseListener() {
        workerTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = workerTable.getSelectedRow();
                if (selectedRow != -1) {
                    sw=workers.get(selectedRow);
                }
                else 
                	sw.setCity("");
            }
        });
    }

    
}
