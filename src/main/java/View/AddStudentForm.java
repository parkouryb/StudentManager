package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Interactive.ContractIT;
import Interactive.RoomIT;
import Interactive.StudentIT;
import Interactive.sqlConnection;
import Object.Contract;
import Object.Student;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddStudentForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField hometownTF;
	private JLabel classlb;
	private JLabel homelb;
	private JLabel phonelb;
	private JTextField phoneTF;
	private JTextField classTF;
	private JTextField schoolTF;
	private JTextField birthdayTF;
	private JTextField genderTF;
	private JTextField nameTF;
	private JTextField student_idTF;
	private JLabel schoollb;
	private JLabel birthdaylb;
	private JLabel genderlb;
	private JLabel namelb;
	private JLabel student_idlb;
	private JLabel lblRoomid;
	private JTextField room_idTF;
	private JTextField contract_idTF;
	private JTextField courseTF;
	private JLabel lblCourse;
	private JTextField statusTF;
	private JLabel lblStatus;
	private JPanel tab2;
	private JPanel panel_3;
	private JLabel lblStudent;
	private JButton applyBtn1;
	private JButton resetBtn1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblContractid_1;
	private JTextField studentTF;
	private JTextField contractTF;
	private JLabel lblNewLabel;
	private JLabel lblDayOut;
	private JTextField dayinTF;
	private JTextField dayoutTF;
	private JButton applyBtn2;
	private JButton resetBtn2;
	private JButton closeBtn;
	private JButton contractBtn;
	private JButton trueBtn;
	private JButton falseBtn;
	private JButton contract_idBtn;
	private JPanel panel;
	private JButton searchBtn;
	private JPanel panel_1;
	private JTable table;

	
	/**
	 * Create the frame.
	 */

	public AddStudentForm() {
		super("Add a new student");
		setResizable(false);
		setBounds(100, 100, 577, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane topPane = new JTabbedPane(JTabbedPane.TOP);
		topPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		closeBtn = new JButton("CLOSE");
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		closeBtn.setBackground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(closeBtn)
							.addGap(29))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(topPane, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(topPane, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(closeBtn, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel tab1 = new JPanel();
		topPane.addTab("NEW STUDENT", null, tab1, null);
		topPane.setForegroundAt(0, Color.BLACK);
		
		hometownTF = new JTextField();
		hometownTF.setColumns(10);
		
		classlb = new JLabel("CLASS");
		classlb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		homelb = new JLabel("HOMETOWN");
		homelb.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		phonelb = new JLabel("PHONE");
		phonelb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		phoneTF = new JTextField();
		phoneTF.setColumns(10);
		
		classTF = new JTextField();
		classTF.setColumns(10);
		
		schoolTF = new JTextField();
		schoolTF.setColumns(10);
		
		birthdayTF = new JTextField();
		birthdayTF.setColumns(10);
		
		genderTF = new JTextField();
		genderTF.setColumns(10);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		
		student_idTF = new JTextField();
		student_idTF.setColumns(10);
		
		schoollb = new JLabel("SCHOOL");
		schoollb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		birthdaylb = new JLabel("BIRTHDAY");
		birthdaylb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		genderlb = new JLabel("GENDER");
		genderlb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		namelb = new JLabel("NAME");
		namelb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		student_idlb = new JLabel("ID");
		student_idlb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		lblRoomid = new JLabel("ROOM_ID");
		lblRoomid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		room_idTF = new JTextField();
		room_idTF.setColumns(10);
		
		contract_idTF = new JTextField();
		contract_idTF.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contract_idTF.setBackground(new Color(255, 255, 255));
		contract_idTF.setForeground(new Color(0, 0, 0));
		contract_idTF.setEditable(false);
		contract_idTF.setColumns(10);
		
		courseTF = new JTextField();
		courseTF.setColumns(10);
		
		lblCourse = new JLabel("COURSE");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		statusTF = new JTextField();
		statusTF.setBackground(new Color(255, 255, 255));
		statusTF.setForeground(Color.BLACK);
		statusTF.setEditable(false);
		statusTF.setFont(new Font("Times New Roman", Font.BOLD, 14));
		statusTF.setColumns(10);
		
		lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		
		applyBtn1 = new JButton("Apply");
		applyBtn1.setForeground(Color.BLACK);
		applyBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		applyBtn1.setBackground(Color.YELLOW);
		applyBtn1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		resetBtn1 = new JButton("Reset");
		resetBtn1.setForeground(Color.BLACK);
		resetBtn1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		resetBtn1.setBackground(Color.YELLOW);
		
		contractBtn = new JButton("Contract_ID");
		
		trueBtn = new JButton("TRUE");
		trueBtn.setForeground(Color.BLACK);
		trueBtn.setBackground(Color.GREEN);
		trueBtn.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		falseBtn = new JButton("FALSE");
		falseBtn.setForeground(Color.BLACK);
		falseBtn.setBackground(Color.RED);
		falseBtn.setFont(new Font("Times New Roman", Font.BOLD, 11));
		GroupLayout gl_tab1 = new GroupLayout(tab1);
		gl_tab1.setHorizontalGroup(
			gl_tab1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tab1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_tab1.createSequentialGroup()
							.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
								.addComponent(namelb, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(birthdaylb, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(genderlb, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(schoollb, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(classlb, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(homelb, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
								.addComponent(phonelb, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(student_idlb, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
								.addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(hometownTF, Alignment.LEADING)
									.addComponent(classTF, Alignment.LEADING)
									.addComponent(schoolTF, Alignment.LEADING)
									.addComponent(birthdayTF, Alignment.LEADING)
									.addComponent(genderTF, Alignment.LEADING)
									.addComponent(nameTF, Alignment.LEADING)
									.addComponent(student_idTF, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
							.addGap(27)
							.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_tab1.createSequentialGroup()
									.addComponent(contractBtn)
									.addGap(22)
									.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
										.addComponent(contract_idTF, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
										.addComponent(courseTF, 85, 115, Short.MAX_VALUE)
										.addComponent(room_idTF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
								.addGroup(gl_tab1.createSequentialGroup()
									.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblRoomid, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(statusTF, Alignment.TRAILING)
										.addGroup(gl_tab1.createSequentialGroup()
											.addComponent(trueBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(falseBtn, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap())
						.addGroup(gl_tab1.createSequentialGroup()
							.addComponent(applyBtn1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetBtn1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_tab1.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addGap(100))))
		);
		gl_tab1.setVerticalGroup(
			gl_tab1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tab1.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(student_idTF, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addGroup(gl_tab1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRoomid, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(room_idTF, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
						.addComponent(student_idlb, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
							.addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(namelb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tab1.createParallelGroup(Alignment.BASELINE)
							.addComponent(contract_idTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(contractBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
							.addComponent(genderTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(genderlb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(courseTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
						.addComponent(birthdayTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(birthdaylb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_tab1.createParallelGroup(Alignment.BASELINE)
							.addComponent(trueBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(falseBtn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab1.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
								.addComponent(schoolTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(schoollb, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
								.addComponent(classTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(classlb, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
								.addComponent(hometownTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(homelb, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
								.addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(phonelb, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_tab1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(statusTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tab1.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetBtn1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(applyBtn1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(10))
		);
		
		lblStudent = new JLabel("NEW STUDENT");
		lblStudent.setForeground(Color.BLACK);
		lblStudent.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_3.add(lblStudent);
		tab1.setLayout(gl_tab1);
		
		applyBtn1.addActionListener(this);
		resetBtn1.addActionListener(this);
		trueBtn.addActionListener(this);
		falseBtn.addActionListener(this);
		contractBtn.addActionListener(this);
		
		tab2 = new JPanel();
		topPane.addTab("STUDENT's CONTRACT", null, tab2, null);
		topPane.setEnabledAt(1, true);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.YELLOW);
		
		lblNewLabel = new JLabel("DAY IN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		
		lblDayOut = new JLabel("DAY OUT");
		lblDayOut.setFont(new Font("Times New Roman", Font.BOLD, 27));
		
		dayinTF = new JTextField();
		dayinTF.setBackground(new Color(255, 255, 255));
		dayinTF.setColumns(10);
		
		dayoutTF = new JTextField();
		dayoutTF.setBackground(new Color(255, 255, 255));
		dayoutTF.setColumns(10);
		
		applyBtn2 = new JButton("Apply");
		applyBtn2.setBackground(Color.YELLOW);
		applyBtn2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		resetBtn2 = new JButton("Reset");
		resetBtn2.setBackground(Color.YELLOW);
		resetBtn2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_tab2 = new GroupLayout(tab2);
		gl_tab2.setHorizontalGroup(
			gl_tab2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab2.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_tab2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_tab2.createSequentialGroup()
							.addComponent(applyBtn2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetBtn2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_tab2.createSequentialGroup()
							.addGroup(gl_tab2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblDayOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_tab2.createParallelGroup(Alignment.LEADING)
								.addComponent(dayoutTF, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(dayinTF, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_tab2.setVerticalGroup(
			gl_tab2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab2.createSequentialGroup()
					.addGap(62)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_tab2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dayinTF)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_tab2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDayOut, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayoutTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_tab2.createParallelGroup(Alignment.LEADING)
						.addComponent(applyBtn2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetBtn2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		
		panel_5 = new JPanel();
		
		studentTF = new JTextField();
		studentTF.setFont(new Font("Times New Roman", Font.BOLD, 14));
		studentTF.setColumns(10);
		
		contractTF = new JTextField();
		contractTF.setBackground(new Color(255, 255, 255));
		contractTF.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contractTF.setEditable(false);
		contractTF.setColumns(10);
		
		contract_idBtn = new JButton("Contract_ID");
		contract_idBtn.setBackground(new Color(124, 252, 0));
		contract_idBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(contract_idBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(studentTF, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(contractTF, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(studentTF)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(contract_idBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(contractTF, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lblContractid_1 = new JLabel("Student_ID");
		lblContractid_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel_5.add(lblContractid_1);
		panel_4.setLayout(gl_panel_4);
		tab2.setLayout(gl_tab2);
		
		panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		topPane.addTab("Un-COOPERATED", null, panel, null);
		
		searchBtn = new JButton("SEARCH");
		searchBtn.setBackground(new Color(255, 255, 0));
		searchBtn.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(159)
							.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(32)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
		);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT" ,"Student_ID", "Name", "Phone"
			}
		));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		applyBtn2.addActionListener(this);
		resetBtn2.addActionListener(this);
		contract_idBtn.addActionListener(this);
		searchBtn.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn.equals(applyBtn1)) {
			try {
				apply1Action();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(btn.equals(resetBtn1)) {
			reset1Action();
		}
		else if(btn.equals(applyBtn2)) {
			try {
				apply2Action();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(btn.equals(resetBtn2)) {
			reset2Action();
		}
		else if(btn.equals(trueBtn)) {
			statusTF.setText("TRUE");
		}
		else if(btn.equals(falseBtn)) {
			statusTF.setText("FALSE");
		}
		else if(btn.equals(contractBtn)) {
			if(student_idTF.getText().length()==0) {
				showMess("Fill your StudentID,please!");
			}
			else {
				contract_idTF.setText(student_idTF.getText());
			}
		}
		else if (btn.equals(contract_idBtn)) {
			checkTheContract();
		}
		else if (btn.equals(searchBtn)) {
			searchAction();
		}
	}
	
	public void searchAction() {
		StudentIT studentIT = new StudentIT();
		List<String> idList = studentIT.getIdUnCooper();
		System.out.println(idList);
		if(idList == null) {
			showMess("There is no Un-Cooperated!");
		}
		else {
			List<Student> students = studentIT.getStudentUnCooper(idList);
			loadTable(students);
			showMess("Search successfully!");
		}
	}
	
	public void loadTable(List<Student> students) {
		Object[][] dataObject = null;
		int rows = students.size();
		String[][] list = new String[rows][4];
		int stt = 1;
		for(int i = 0; i < rows ; i++) {
			int dem = 0 ;
			list[i][dem] = String.valueOf(stt);
			dem++;
			list[i][dem] = students.get(i).getStudent_ID(); 
			dem++;
			list[i][dem] = students.get(i).getName();
			dem++;
			list[i][dem] = students.get(i).getPhone_Number();
			stt++;
		}
		String[][] list1 = new String[rows][4];
		list1 = list;
		dataObject = list1;
		table.setModel(new DefaultTableModel(
    			dataObject,
    			new String[] {
    				"STT" ,"Student_ID", "Name", "Phone"
    			}
    		));
	}
	
	public void apply1Action() throws Exception {
		boolean check = false;
		StudentIT stdIT = new StudentIT();
		Student std = new Student();
		RoomIT roomIT = new RoomIT();
		ContractIT contractIT = new ContractIT();
		
		if(stdIT.idstudentExited(student_idTF.getText())) {
			showMess("This Student ID exited!");
		}
		else if(contractIT.contractExited(contract_idTF.getText())) {
			showMess("This Contract ID exited!");
		}
		else if(roomIT.fullOfRoom(room_idTF.getText())) {
			showMess("This room is full!");
		}
		else if(stdIT.courseEx(courseTF.getText()) == false) {
			showMess("Course is a number!");
		}
		else if (roomIT.idRoomExited(room_idTF.getText()) == false) {
			showMess("This room doesn't existed." + "\n" + "Please try again!");
		}
		else if(student_idTF.getText().length() == 0 || nameTF.getText().length() == 0 ||
				genderTF.getText().length() == 0 || schoolTF.getText().length() == 0 ||
				classTF.getText().length() == 0 || birthdayTF.getText().length() == 0 ||
				phoneTF.getText().length() == 0 || hometownTF.getText().length() == 0 ||
				room_idTF.getText().length() == 0 || contract_idTF.getText().length() == 0 ||
				courseTF.getText().length() == 0 || statusTF.getText().length() == 0) {
			showMess("Let fill out your form fully!");
		}
		else {
			std.setStudent_ID(student_idTF.getText());
			std.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(birthdayTF.getText()));
			std.setContract_ID(contract_idTF.getText());
			std.setCourse(Integer.parseInt(courseTF.getText()));
			std.setEducational_System(schoolTF.getText());
			std.setFaculty(classTF.getText());
			std.setGender(genderTF.getText());
			std.setHometown(hometownTF.getText());
			std.setName(nameTF.getText());
			std.setPhone_Number(phoneTF.getText());
			std.setRoom_ID(room_idTF.getText());
			std.setStatus(statusTF.getText());
			
			sqlConnection.getconnection();
			stdIT.addStudent(std);
			showMess("Adding successfully!");
			check = true;
		}
		
		if(check) {
			studentTF.setText(contract_idTF.getText());
			contractTF.setText(student_idTF.getText());
		}
	}
	
	public void apply2Action() throws Exception {
		Contract ctr = new Contract();
		ContractIT contractIT = new ContractIT();
		
		if(dayinTF.getText().length() == 0 || dayoutTF.getText().length() ==0
			||	contractTF.getText().length() ==0) {
			showMess("Please fill out your form!");
		}
		else {
			ctr.setContract_ID(studentTF.getText());
			ctr.setDay_in(new SimpleDateFormat("dd/MM/yyyy").parse(dayinTF.getText()));
			ctr.setDay_out(new SimpleDateFormat("dd/MM/yyyy").parse(dayoutTF.getText()));
			
			sqlConnection.getconnection();
			contractIT.addContract(ctr);
			showMess("Adding successfully!");
		}
	}
	
	public void reset1Action() {
		student_idTF.setText("");
		nameTF.setText("");
		genderTF.setText("");
		schoolTF.setText("");
		classTF.setText("");
		birthdayTF.setText("");
		phoneTF.setText("");
		hometownTF.setText("");
		room_idTF.setText("");
		studentTF.setText("");
		courseTF.setText("");
		statusTF.setText("");
	}
	
	public void reset2Action() {
		dayinTF.setText("");
		dayoutTF.setText("");
	}
	
	public void checkTheContract() {
		ContractIT ctrIt = new ContractIT();
		Contract ctr = new Contract();
		if(ctrIt.contractExited(studentTF.getText()) == false) {
			showMess("This contract doesn't existed." + "\n" + "Please fill out your form!");
			contractTF.setText(studentTF.getText());
			dayinTF.setEditable(true);
			dayoutTF.setEditable(true);
		}
		else {
			showMess("Search successfully!");
			ctr = ctrIt.searchContract(studentTF.getText());
			dayinTF.setText((ctr.getDay_in()).toString());
			dayoutTF.setText(ctr.getDay_out().toString());
			dayinTF.setEditable(false);
			dayoutTF.setEditable(false);
		}
	}
	
	public void showMess(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

}
