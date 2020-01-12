package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interactive.ContractIT;
import Interactive.StudentIT;
import Object.Contract;
import Object.Student;

public class SearchStudentForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField student_idTF;
	private JTable table;
	private JButton deleteBtn;
	private JButton searchBtn;
	private JButton findListBtn;

	/**
	 * Create the frame.
	 */
	public SearchStudentForm() {
		super("Search Student");
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setBounds(100, 100, 539, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(238, 232, 170));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "ID", "Name", "Room", "Phone Number"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(39);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 0));
		
		student_idTF = new JTextField();
		student_idTF.setColumns(10);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBackground(new Color(255, 160, 122));
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		searchBtn.setBackground(new Color(173, 255, 47));
		
		findListBtn = new JButton("List of expired contract");
		findListBtn.setBackground(new Color(221, 160, 221));
		findListBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(findListBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addComponent(student_idTF, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))))
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(student_idTF, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(findListBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblStudentsId = new JLabel("Student's ID ");
		lblStudentsId.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblStudentsId);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		deleteBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		findListBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton newButton = (JButton) e.getSource();
		if(newButton.equals(deleteBtn)) {
			delAction();
		}
		else if (newButton.equals(searchBtn)) {
			searchAction();
		}
		else if (newButton.equals(findListBtn)) {
			findListAction();
		}
	}
	
	public void searchAction() {
		ContractIT contractIT = new ContractIT();
		StudentIT studentIT = new StudentIT();
		Contract contract = new Contract();
		Student student = new Student();
		
		if(student_idTF.getText().length() == 0) {
			showMess("Please fill out your form!");
		}
		else if (student_idTF.getText().length() != 0 && 
				  studentIT.idstudentExited(student_idTF.getText()) == false) {
			showMess("This ID doesn't exist!" + "\n" + "Please try again!");
		}
		else if (student_idTF.getText().length() != 0 && 
					contractIT.contractExited(student_idTF.getText()) == false) {
			showMess("This student doesn't have contract." + "\n"
						+ "Please check his/her contract at 'Student and Contract'");
		}
		else {
			student = studentIT.searchStudentbyID(student_idTF.getText());
			contract = contractIT.searchContract(student_idTF.getText());
			loadTable(student, contract);
		}
	}
	
	public void loadTable(Student student, Contract contract) {
		Object[][] data = null;
		int rows = 13;
		String[][] info = new String[rows][2];
		int col = 0;
		int row = 0 ;
		
		//table col 0
		info[row][col] = "Student_ID";
		row++;
		info[row][col] = "Name";
		row++;
		info[row][col] = "Gender";
		row++;
		info[row][col] = "Birthday";
		row++;
		info[row][col] = "School";
		row++;
		info[row][col] = "Classroom";
		row++;
		info[row][col] = "Phone Number";
		row++;
		info[row][col] = "Hometown";
		row++;
		info[row][col] = "Status";
		row++;
		info[row][col] = "Room_ID";
		row++;
		info[row][col] = "Contract_ID";
		row++;
		info[row][col] = "Day in";
		row++;
		info[row][col] = "Day out";
		row++;
		
		//table col 1
		col++;
		int row1 = 0;
		info[row1][col] = student.getStudent_ID();
		row1++;
		info[row1][col] = student.getName();
		row1++;
		info[row1][col] = student.getGender();
		row1++;
		info[row1][col] = student.getBirthday().toString();
		row1++;
		info[row1][col] = student.getEducational_System();
		row1++;
		info[row1][col] = student.getFaculty();
		row1++;
		info[row1][col] = student.getPhone_Number();
		row1++;
		info[row1][col] = student.getHometown();
		row1++;
		info[row1][col] = student.getStatus();
		row1++;
		info[row1][col] = student.getRoom_ID();
		row1++;
		info[row1][col] = contract.getContract_ID();
		row1++;
		info[row1][col] = contract.getDay_in().toString();
		row1++;
		info[row1][col] = contract.getDay_out().toString();
		row1++;
		
		data = info;
		table.setModel(new DefaultTableModel(
    			data,
    			new String[] {
    				"Menu", "Information"
    			}
    		));
	}
	
	public void findListAction() {
		StudentIT studentIT = new StudentIT();
		ContractIT contractIT = new ContractIT();
		List<Contract> idList = contractIT.getAllContracts();
		List<Contract> contracts = contractIT.getExpiredContract(idList);
		List<Student> expiredStudents = studentIT.getExpiredStudent(contracts);
		if(expiredStudents == null) {
			showMess("There is no expired contract!" + "\n" + "Try again tomorrow!");
		}
		else loadTable(expiredStudents);
	}
	
	public void loadTable(List<Student> students) {
		Object[][] data = null;
		int rows = students.size();
		int stt = 1;
		String[][] std = new String[rows][5];
		for(int i = 0 ; i<rows ; i++) {
			int col = 0;
			std[i][col] = String.valueOf(stt);
			col++;
			std[i][col] = students.get(i).getStudent_ID();
			col++;
			std[i][col] = students.get(i).getName();
			col++;
			std[i][col] = students.get(i).getRoom_ID();
			col++;
			std[i][col] = students.get(i).getPhone_Number();
			stt++;
		}
		data = std;
		table.setModel(new DefaultTableModel(
				data,
				new String[] {
					"STT", "ID", "Name", "Room", "Phone Number"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					true, true, true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setPreferredWidth(39);
			table.getColumnModel().getColumn(4).setResizable(false);
			table.getColumnModel().getColumn(4).setPreferredWidth(90);
			table.setFillsViewportHeight(true);
	}
	
	public void delAction() {
		StudentIT studentIT = new StudentIT();
		ContractIT contractIT = new ContractIT();
		
		if(student_idTF.getText().length() == 0) {
			showMess("Please fill out your form!");
		}
		else if (student_idTF.getText().length() != 0 && 
				  studentIT.idstudentExited(student_idTF.getText()) == false) {
			showMess("This ID doesn't exist!" + "\n" + "Please try again!");
		}
		else {
			int choice = JOptionPane.showConfirmDialog(null, "Are your sure?", 
														"Delete Student", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				studentIT.deleteStudent(student_idTF.getText());
				contractIT.deleteContract(student_idTF.getText());
				showMess("Delete successfully!");
				findListAction();
			}
			else {
				
			}
		}
	}
	
	public void showMess(String cmd) {
		JOptionPane.showMessageDialog(null, cmd);
	}
	
}
