package Main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import Interactive.StudentIT;
import Interactive.sqlConnection;
import Interactive.sqlStudent;
import Object.Contract;
import Object.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import Interactive.sqlStudent;

public class addStudentForm extends JFrame implements ActionListener {

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
	private JPanel panel_6;
	private JLabel lblStudentid;
	private JTextField contractTF;
	private JTextField studentTF;
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

	
	/**
	 * Create the frame.
	 */

	public addStudentForm() {
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
		contract_idTF.setForeground(Color.BLACK);
		contract_idTF.setEditable(false);
		contract_idTF.setColumns(10);
		
		courseTF = new JTextField();
		courseTF.setColumns(10);
		
		lblCourse = new JLabel("COURSE");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		statusTF = new JTextField();
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
		dayinTF.setColumns(10);
		
		dayoutTF = new JTextField();
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
		
		panel_6 = new JPanel();
		
		lblStudentid = new JLabel("STUDENT_ID");
		lblStudentid.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel_6.add(lblStudentid);
		
		contractTF = new JTextField();
		contractTF.setEditable(false);
		contractTF.setColumns(10);
		
		studentTF = new JTextField();
		studentTF.setEditable(false);
		studentTF.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(contractTF, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(studentTF, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(contractTF, Alignment.LEADING)
						.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentTF, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lblContractid_1 = new JLabel("Contract_ID");
		lblContractid_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel_5.add(lblContractid_1);
		panel_4.setLayout(gl_panel_4);
		tab2.setLayout(gl_tab2);
		applyBtn2.addActionListener(this);
		resetBtn2.addActionListener(this);
		contentPane.setLayout(gl_contentPane);
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
	}
	
	public void apply1Action() throws Exception {
		boolean check = false;
		sqlStudent sqlstd = new sqlStudent();
		Student std = new Student();
		
		if(sqlstd.idstudentExited(student_idTF.getText())) {
			showMess("This Student ID exited!");
		}
		else if(sqlstd.contractExited(contract_idTF.getText())) {
			showMess("This Contract ID exited!");
		}
		else if(sqlstd.fullOfRoom(room_idTF.getText())) {
			showMess("This room is full!");
		}
		else if(sqlstd.courseEx(courseTF.getText()) == false) {
			showMess("Course is a number!");
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
			StudentIT sit = new StudentIT();
			sit.addStudent_hbn(std);
//			StudentIT.addStudent(std);
			showMess("Adding successfully!");
			check = true;
		}
		
		if(check) {
			contractTF.setText(contract_idTF.getText());
			studentTF.setText(student_idTF.getText());
		}
	}
	
	public void apply2Action() throws Exception {
		Contract ctr = new Contract();
		if(dayinTF.getText().length() == 0 || dayoutTF.getText().length() ==0) {
			showMess("Please fill out your form!");
		}
		else {
			ctr.setContract_ID(contractTF.getText());
			ctr.setDay_in(new SimpleDateFormat("dd/MM/yyyy").parse(dayinTF.getText()));
			ctr.setDay_out(new SimpleDateFormat("dd/MM/yyyy").parse(dayoutTF.getText()));
			
			sqlConnection.getconnection();
			sqlStudent.addContract(ctr);
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
		contractTF.setText("");
		courseTF.setText("");
		statusTF.setText("");
	}
	
	public void reset2Action() {
		dayinTF.setText("");
		dayoutTF.setText("");
	}
	
	public void showMess(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
}
