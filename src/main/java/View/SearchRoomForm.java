package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interactive.RoomIT;
import Object.Room;

public class SearchRoomForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField genderTF;
	private JTextField room_idTF;
	private JTable table;
	private JButton maleBtn;
	private JButton femaleBtn;
	private JButton clearBtn;
	private JButton okBtn;

	/**
	 * Create the frame.
	 */
	public SearchRoomForm() {
		super("Search Room");
		setBounds(100, 100, 505, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Type", "Room_ID", "Money", "Slots"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 0));
		
		maleBtn = new JButton("Male");
		maleBtn.setBackground(new Color(173, 255, 47));
		maleBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		femaleBtn = new JButton("Female");
		femaleBtn.setBackground(new Color(173, 255, 47));
		femaleBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		genderTF = new JTextField();
		genderTF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genderTF.setBackground(new Color(250, 240, 230));
		genderTF.setEditable(false);
		genderTF.setColumns(10);
		
		room_idTF = new JTextField();
		room_idTF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		room_idTF.setColumns(10);
		
		clearBtn = new JButton("X");
		clearBtn.setBackground(new Color(255, 0, 0));
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		okBtn = new JButton("OK");
		okBtn.setFont(new Font("Tahoma", Font.BOLD, 30));
		okBtn.setBackground(new Color(124, 252, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(femaleBtn, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(room_idTF, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(maleBtn, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(genderTF, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(clearBtn)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(okBtn, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(okBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(clearBtn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
									.addComponent(maleBtn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
									.addComponent(genderTF, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
								.addGap(7)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(femaleBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(room_idTF, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))))
					.addGap(46))
		);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Room");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		maleBtn.addActionListener(this);
		femaleBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		okBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton actButton = (JButton) e.getSource();
		if(actButton.equals(maleBtn)) {
			genderTF.setText("MALE");
		}
		else if (actButton.equals(femaleBtn)) {
			genderTF.setText("FEMALE");
		}
		else if (actButton.equals(clearBtn)) {
			genderTF.setText("");
		}
		else if (actButton.equals(okBtn)) {
			okAction();
		}
	}
	
	public void okAction() {
		if(genderTF.getText().length() == 0 && room_idTF.getText().length() == 0) {
			showMess("Please fill out your form!");
		}
		else if (genderTF.getText().length() != 0 && room_idTF.getText().length() != 0) {
			showMess("Clear and try again!");
		}
		else if (genderTF.getText().length() != 0 && room_idTF.getText().length() == 0) {
			searchGenderRoom();
		}
		else if (genderTF.getText().length() == 0 && room_idTF.getText().length() != 0) {
			searchIdRoom();
		}
	}
	
	public void searchGenderRoom() {
		RoomIT roomIT = new RoomIT();
	
		List<String> idrooms = roomIT.getListRoom();
		List<Room> blankRooms = roomIT.getBlankRoom(idrooms);
		String genderString = genderTF.getText();
		List<Room> genderRooms = roomIT.genderBlankRooms(blankRooms, genderString);
		if(genderRooms == null) showMess("There is no blank rooms left!");
		else loadTable(genderRooms, "Slots");
	}
	
	public void loadTable(List<Room> rooms, String colName) {
		Object[][] data = null;
		int stt = 1;
		int rows = rooms.size();
		String[][] info = new String[rows][5];
		for(int i = 0; i<rows ; i++) {
			int col = 0;
			info[i][col] = String.valueOf(stt);
			col++;
			info[i][col] = rooms.get(i).getType_room();
			col++;
			info[i][col] = rooms.get(i).getRoom_ID();
			col++;
			info[i][col] = String.valueOf(rooms.get(i).getRoom_money()) ;
			col++;
			info[i][col] = String.valueOf(rooms.get(i).getNumber());
			stt++;
		}
		data = info;
		table.setModel(new DefaultTableModel(
				data,
				new String[] {
					"STT", "Type", "Room_ID", "Money", colName
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(2).setPreferredWidth(80);
			table.getColumnModel().getColumn(3).setPreferredWidth(63);
			table.getColumnModel().getColumn(4).setPreferredWidth(30);
			table.setFont(new Font("Tahoma", Font.BOLD, 13));
	}
	
	public void searchIdRoom() {
		RoomIT roomIT = new RoomIT();
		Room room = new Room();
		int number;
		if(room_idTF.getText().compareTo("all") != 0 && roomIT.idRoomExited(room_idTF.getText()) == false) {
			showMess("This room doesn't exist!" + "\n" + "Please try again!");
		}
		else if (room_idTF.getText().length() != 0 && room_idTF.getText().equals("all")) {
			List<String> idList = roomIT.getListRoom();
			List<Room> rooms = roomIT.getAllRoom(idList);
			loadTable(rooms, "Number");
		}
		else {
			List<Room> rooms = new ArrayList<Room>();
			room = roomIT.searchRoom(room_idTF.getText());
			number = room.getNumber();
			room.setNumber(number-1);
			rooms.add(room);
			loadTable(rooms, "Number");
		}
	}
	
	public void showMess(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
