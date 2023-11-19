package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modules.*;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.*;
import Database.Database;

public class CView extends JFrame {
	static Worker w;
	JPanel ptable;
	ArrayList<Review> r;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CView frame = new CView(w);
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
	public CView(Worker worker) {
		w=worker;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 150, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ptable = new JPanel();
		ptable.setBounds(10, 144, 536, 303);
		contentPane.add(ptable);
		if (w!=null) {
			JLabel lblNewLabel = new JLabel("Name:"+ w.getName());
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblNewLabel.setBounds(31, 11, 231, 29);
			contentPane.add(lblNewLabel);
			
			JLabel lblSkill = new JLabel("Skill:" + w.getSkill());
			lblSkill.setForeground(Color.WHITE);
			lblSkill.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblSkill.setBounds(31, 51, 231, 29);
			contentPane.add(lblSkill);
			
			JLabel lblNewLabel_1_1 = new JLabel("Rating:"+ w.getRating());
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblNewLabel_1_1.setBounds(31, 90, 231, 29);
			contentPane.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Phone No:" + w.getPhone());
			lblNewLabel_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblNewLabel_1_1_1.setBounds(293, 11, 231, 29);
			contentPane.add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("City:"+ w.getCity());
			lblNewLabel_1_1_2.setForeground(Color.WHITE);
			lblNewLabel_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblNewLabel_1_1_2.setBounds(293, 51, 231, 29);
			contentPane.add(lblNewLabel_1_1_2);
			
			JLabel lblNewLabel_1_1_3 = new JLabel("Fee:"+ w.getFee());
			lblNewLabel_1_1_3.setForeground(Color.WHITE);
			lblNewLabel_1_1_3.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblNewLabel_1_1_3.setBounds(293, 90, 231, 29);
			contentPane.add(lblNewLabel_1_1_3);
			Database db=new Database();
			r=db.getReview(w.getId());
			setTable(r);
		}
	}

	public void setTable(ArrayList<Review> r) {
        String[] columnNames = {"Customer ", "Rating", "Comment", "Date"};

        DefaultTableModel model = new DefaultTableModel(null, columnNames);

        for (Review review : r) {
        	String Rating="";
        	for(int i=0;i<review.getRating();i++) {
        		Rating+="*";
        	}
            Object[] rowData = {review.getcName(), Rating, review.getComment(), review.getDate()};
            model.addRow(rowData);
        }

        
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(55); 
        table.getColumnModel().getColumn(2).setPreferredWidth(295);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE); 
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(new Color(40,150,190));
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(table);

        ptable.removeAll();
        ptable.setLayout(new BorderLayout());
        ptable.add(scrollPane, BorderLayout.CENTER);
        ptable.revalidate();
        ptable.repaint();
    }
	
}
