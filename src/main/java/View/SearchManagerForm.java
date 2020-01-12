package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interactive.ManagerIT;
import Interactive.StudentIT;
import Interactive.sqlConnection;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class SearchManagerForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField nameTF;
	private JTextField idTF;
	private JButton searchBtn;
	private JButton deleteBtn;

	/**
	 * Create the frame.
	 */
	public SearchManagerForm() {
		super("Search Manager");
		setForeground(new Color(255, 255, 0));
		setBackground(new Color(255, 255, 0));
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 0));
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		
		searchBtn = new JButton("Search");
		searchBtn.setForeground(new Color(0, 0, 0));
		searchBtn.setBackground(new Color(255, 255, 0));
		searchBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		
		JLabel lblManagerid_1 = new JLabel("Manager_ID");
		lblManagerid_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		panel_3.add(lblManagerid_1);
		
		idTF = new JTextField();
		idTF.setColumns(10);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setForeground(new Color(255, 0, 0));
		deleteBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		deleteBtn.setBackground(new Color(255, 255, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nameTF, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idTF, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(searchBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
						.addComponent(nameTF))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(idTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblManagerid = new JLabel("Manager_Name");
		lblManagerid.setFont(new Font("Times New Roman", Font.BOLD, 19));
		panel_2.add(lblManagerid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Gender", "Position"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblListManager = new JLabel("Manager's List");
		lblListManager.setBackground(new Color(255, 255, 255));
		lblListManager.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblListManager.setForeground(new Color(128, 0, 128));
		panel.add(lblListManager);
		contentPane.setLayout(gl_contentPane);
		
		searchAction();
		searchBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btnButton = (JButton) e.getSource();
		if(btnButton.equals(searchBtn)) {
			searchAct();
		}
		else if (btnButton.equals(deleteBtn)) {
			deleteAct();
		}
	}
	
	public void deleteAct() {
		sqlConnection.getconnection();
		ManagerIT mgIt = new ManagerIT();
		if (idTF.getText().length() == 0) {
			showMess("Please fill out your form!");
		}
		else if (mgIt.idExited(idTF.getText()) == false) {
			showMess("This ID doesn't existed." + "\n" + "Please try again!");
		}
		else {
            int choiced = JOptionPane.showConfirmDialog(null, "Are you sure ?", null, JOptionPane.YES_NO_OPTION);
            if(choiced == JOptionPane.YES_OPTION){              
                mgIt.deleteManager(idTF.getText());  
                showMess("Delete successfully");
                searchAction();
            }else{
                
            }
		}
	}
	
	public void searchAct() {
		sqlConnection.getconnection();
		ManagerIT mgIt = new ManagerIT();
		if (nameTF.getText().length() == 0) {
			showMess("Please fill out your form!");
		} 
		else {
			ResultSet rs = mgIt.searchManager(nameTF.getText());
			loadTable(rs);
		}
	}
	
	public void searchAction() {
			sqlConnection.getconnection();
			ManagerIT mgIt = new ManagerIT();
			ResultSet rs = mgIt.searchManager();
			loadTable(rs);
	}
	
	public void loadTable(ResultSet rs) {
		Object[][] data1 = null;
        int rows = 0;// so hang cua rs
        try {
            rs.last();
            rows = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        try {
            int dem = 0;
            String[][] arr = new String[rows][4];
            while(rs.next()){
                for(int i = 0; i < 4;i++){
                    arr[dem][i] = rs.getString(i+1);
                }
                dem++;
            }
            String[][] arr1 = new String[dem][4];
            arr1 = arr;
            data1 = arr1;
            
        } catch (SQLException ex) {
            
        }
        table.setModel(new DefaultTableModel(
    			data1,
    			new String[] {
    				"ID", "Name", "Gender", "Position"
    			}
    		));
	}
	
	public void showMess(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}
