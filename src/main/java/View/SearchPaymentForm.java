package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interactive.StudentIT;
import Interactive.sqlConnection;
import Object.Student;

public class SearchPaymentForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField searchTF;
	private JTable table;
	private JButton trueBtn;
	private JButton falseBtn;
	private JButton searchBtn;
	private JButton payBtn;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblPleaseEnterYour;
	private JTextField student_idTF;

	/**
	 * Create the frame.
	 */
	public SearchPaymentForm() {
		super("Find my Money");
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setBounds(100, 100, 522, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 494, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 0));
		
		student_idTF = new JTextField();
		student_idTF.setColumns(10);
		
		payBtn = new JButton("Pay");
		payBtn.setBackground(new Color(255, 255, 0));
		payBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(student_idTF, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(payBtn, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(student_idTF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(payBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		lblPleaseEnterYour = new JLabel("Please enter your Student's ID here");
		lblPleaseEnterYour.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_3.add(lblPleaseEnterYour);
		panel_2.setLayout(gl_panel_2);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student_ID", "Name", "Room", "Money" ,"Phone"
			}
		));
		scrollPane.setViewportView(table);
		
		searchBtn = new JButton("OK");
		searchBtn.setBackground(Color.YELLOW);
		searchBtn.setFont(new Font("Times New Roman", Font.BOLD, 28));
		
		searchTF = new JTextField();
		searchTF.setBackground(new Color(255, 255, 255));
		searchTF.setEditable(false);
		searchTF.setFont(new Font("Times New Roman", Font.BOLD, 30));
		searchTF.setColumns(10);
		
		trueBtn = new JButton("TRUE");
		trueBtn.setForeground(Color.BLACK);
		trueBtn.setBackground(new Color(0, 255, 0));
		trueBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		falseBtn = new JButton("FALSE");
		falseBtn.setForeground(Color.BLACK);
		falseBtn.setBackground(Color.RED);
		falseBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 103, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(falseBtn, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(trueBtn, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addGap(14)
					.addComponent(searchTF, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchBtn, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addComponent(searchTF, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(trueBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(falseBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStatus)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		searchBtn.addActionListener(this);
		trueBtn.addActionListener(this);
		falseBtn.addActionListener(this);
		payBtn.addActionListener(this);
		
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn.equals(trueBtn)) {
			searchTF.setText("TRUE");
		}
		else if(btn.equals(falseBtn)) {
			searchTF.setText("FALSE");
		}
		else if(btn.equals(searchBtn)) {
			searchAction();
		}
		else if (btn.equals(payBtn)) {
			payAction();
		}
	}
	
	public void payAction() {
		StudentIT studentIT = new StudentIT();
		Student student = new Student();
		if(student_idTF.getText().length() == 0) {
			showMess("Please filll out your form!");
		}
		else if (student_idTF.getText().length() != 0 &&
					studentIT.isPaidMoney(student_idTF.getText())) {
			showMess("This student has already paid!");
		}
		else {
			student = studentIT.searchStudentbyID(student_idTF.getText());
			student.setStatus("TRUE");
			studentIT.deleteStudent(student_idTF.getText());
			studentIT.addStudent(student);
			showMess("Update Successfully!");
		}
	}
	
	public void searchAction() {
		if(searchTF.getText().length() == 0){
			showMess("Please choose your status which you want to find!");
		}
		else {
			sqlConnection.getconnection();
			StudentIT stdIT = new StudentIT();
			
			ResultSet rs = stdIT.getStatus(searchTF.getText());
			loadTable(rs);
		}
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
            String[][] arr = new String[rows][5];
            while(rs.next()){
                for(int i = 0; i < 5;i++){
                    arr[dem][i] = rs.getString(i+1);
                }
                dem++;
            }
            String[][] arr1 = new String[dem][5];
            arr1 = arr;
            data1 = arr1;
            
        } catch (SQLException ex) {
            
        }
        table.setModel(new DefaultTableModel(
    			data1,
    			new String[] {
    				"Student_ID", "Name", "Room", "Money" ,"Phone"
    			}
    		));
	}
	
	public void showMess(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	
}

