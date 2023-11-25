package frontend;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modules.*;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

public class WReview extends JPanel {
	
	Worker w;
	JPanel ptable;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public WReview(Worker w) {
		this.w=w;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel rating = new JLabel("Rating:" + w.getRating());
		rating.setFont(new Font("Arial Black", Font.BOLD, 14));
		rating.setBounds(213, 33, 163, 34);
		add(rating);
		
		ptable = new JPanel();
		ptable.setBackground(new Color(255, 255, 255));
		ptable.setBounds(26, 91, 536, 356);
		add(ptable);
		setTable();
	}
	
	public void setTable() {
		Review rr=new Review();
		ArrayList<Review> rw=rr.getReviews(w.getId());
        String[] columnNames = {"Customer ", "Rating", "Comment", "Date"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        for (Review review : rw) {
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
