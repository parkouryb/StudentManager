package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interactive.ContractIT;
import Interactive.RoomIT;
import Interactive.StudentIT;
import Object.Contract;
import Object.Room;
import Object.Student;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class AddRoomForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField room_idTF;
	private JTextField moneyTF;
	private JTextField numberTF;
	private JTextField typeTF;
	private JButton femaleBtn;
	private JButton maleBtn;
	private JButton submitBtn;
	private JButton resetBtn;

	/**
	 * Create the frame.
	 */
	public AddRoomForm() {
		super("Add a new room");
		setBackground(new Color(255, 255, 0));
		setResizable(false);
		setBounds(100, 100, 497, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 255, 47));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 0));
		
		room_idTF = new JTextField();
		room_idTF.setFont(new Font("Times New Roman", Font.BOLD, 11));
		room_idTF.setForeground(new Color(255, 0, 0));
		room_idTF.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		
		moneyTF = new JTextField();
		moneyTF.setFont(new Font("Times New Roman", Font.BOLD, 11));
		moneyTF.setForeground(new Color(255, 0, 0));
		moneyTF.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setForeground(new Color(139, 0, 0));
		lblNumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_3.add(lblNumber);
		
		numberTF = new JTextField();
		numberTF.setFont(new Font("Times New Roman", Font.BOLD, 11));
		numberTF.setForeground(new Color(255, 0, 0));
		numberTF.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.YELLOW);
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(new Color(139, 0, 0));
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblType);
		
		typeTF = new JTextField();
		typeTF.setBackground(new Color(255, 255, 255));
		typeTF.setEditable(false);
		typeTF.setFont(new Font("Times New Roman", Font.BOLD, 20));
		typeTF.setForeground(new Color(255, 0, 0));
		typeTF.setColumns(10);
		
		maleBtn = new JButton("MALE");
		maleBtn.setForeground(new Color(128, 0, 0));
		maleBtn.setBackground(new Color(173, 255, 47));
		
		femaleBtn = new JButton("FEMALE");
		femaleBtn.setForeground(new Color(128, 0, 0));
		femaleBtn.setBackground(new Color(173, 255, 47));
		
		resetBtn = new JButton("RESET");
		resetBtn.setBackground(new Color(255, 69, 0));
		resetBtn.setForeground(new Color(255, 255, 255));
		resetBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setForeground(new Color(25, 25, 112));
		submitBtn.setBackground(new Color(127, 255, 0));
		submitBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(numberTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
								.addComponent(panel_1, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(room_idTF)
										.addComponent(moneyTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(34)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(femaleBtn, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(maleBtn, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
										.addComponent(typeTF, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(maleBtn)
								.addComponent(femaleBtn))
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(room_idTF)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addComponent(moneyTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addComponent(numberTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(typeTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
							.addGap(46))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		
		JLabel lblMoney = new JLabel("Money");
		lblMoney.setForeground(new Color(139, 0, 0));
		lblMoney.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_2.add(lblMoney);
		
		JLabel lblRoomid = new JLabel("Room_ID");
		lblRoomid.setForeground(new Color(139, 0, 0));
		lblRoomid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblRoomid);
		
		JLabel lblNewLabel = new JLabel("NEW ROOM");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addComponent(lblNewLabel)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		femaleBtn.addActionListener(this);
		maleBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		submitBtn.addActionListener(this);
		
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn.equals(maleBtn)) {
			typeTF.setText("MALE");
		}
		else if (btn.equals(femaleBtn)) {
			typeTF.setText("FEMALE");
		}
		else if (btn.equals(resetBtn)) {
			resetAction();
		}
		else if (btn.equals(submitBtn)) {
			submitAction();
		}
	}
	
	public void submitAction() {
		StudentIT stdIT = new StudentIT();
		ContractIT contractIT = new ContractIT();
		RoomIT roomIT = new RoomIT();
		Room room = new Room();
		
		if(roomIT.idRoomExited(room_idTF.getText())) {
			showMess("This room has already exited!");
		}
		else if (room_idTF.getText().length() == 0 || typeTF.getText().length() == 0
				|| moneyTF.getText().length() == 0 || numberTF.getText().length() == 0) {
			showMess("Please fill out your form!");
		}
		else {
			room.setRoom_ID(room_idTF.getText());
			room.setRoom_money(Float.parseFloat(moneyTF.getText()));
			room.setNumber(Integer.parseInt(numberTF.getText()) +1 );
			room.setType_room(typeTF.getText());
			roomIT.addRoom(room);
			
			String demo = "demo";
			Student std = new Student(room_idTF.getText(),room_idTF.getText(), demo);
			stdIT.addStudent(std);
			Contract contract = new Contract(room_idTF.getText());
			contractIT.addContract(contract);
			showMess("Add new room successfully!");
		}
	}
	
	public void resetAction() {
		room_idTF.setText("");
		moneyTF.setText("");
		typeTF.setText("");
		numberTF.setText("");
	}
	
	public void showMess(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}

