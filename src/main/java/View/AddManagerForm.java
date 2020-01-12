package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interactive.AccountIT;
import Interactive.ManagerIT;
import Interactive.sqlConnection;
import Object.Account;
import Object.Manager;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddManagerForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField id_managerTF;
	private JTextField name_managerTF;
	private JTextField genderTF;
	private JTextField birthday_managerTF;
	private JTextField positionTF;
	private JTextField userNameTF;
	private JTextField passwordTF;
	
	private JButton submitBtn;
	private JButton resetBtn;

	/**
	 * Create the frame.
	 */
	public AddManagerForm() {
		super("Add new manager");
		setForeground(new Color(255, 99, 71));
		setBackground(new Color(255, 99, 71));
		setBounds(100, 100, 519, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 0));
		
		id_managerTF = new JTextField();
		id_managerTF.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_2.add(lblName);
		
		name_managerTF = new JTextField();
		name_managerTF.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_3.add(lblGender);
		
		genderTF = new JTextField();
		genderTF.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.YELLOW);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblBirthday);
		
		birthday_managerTF = new JTextField();
		birthday_managerTF.setColumns(10);
		
		positionTF = new JTextField();
		positionTF.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.YELLOW);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_5.add(lblPosition);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.YELLOW);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_6.add(lblUsername);
		
		userNameTF = new JTextField();
		userNameTF.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.YELLOW);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_7.add(lblPassword);
		
		passwordTF = new JTextField();
		passwordTF.setColumns(10);
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setForeground(new Color(0, 0, 0));
		submitBtn.setBackground(new Color(0, 255, 0));
		submitBtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		resetBtn = new JButton("RESET");
		resetBtn.setForeground(new Color(0, 0, 0));
		resetBtn.setBackground(new Color(255, 0, 0));
		resetBtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(birthday_managerTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(196, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(name_managerTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(id_managerTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(genderTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(submitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(userNameTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(positionTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
									.addGap(11))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(id_managerTF)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(name_managerTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(genderTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(birthday_managerTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(positionTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(userNameTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblManagerid = new JLabel("Manager_ID");
		lblManagerid.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_1.add(lblManagerid);
		
		JLabel lblAddManager = new JLabel("Add Manager");
		lblAddManager.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lblAddManager);
		contentPane.setLayout(gl_contentPane);
		
		submitBtn.addActionListener(this);
		resetBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn.equals(submitBtn)) {
			try {
				submitNewManager();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(btn.equals(resetBtn)) {
			resetManager();
		}
	}
	
	public void submitNewManager() throws Exception{
		AccountIT accIT = new AccountIT();
		ManagerIT mgIT = new ManagerIT();
		Manager mg = new Manager();
		Account acc = new Account();
		
		if(mgIT.idExited(id_managerTF.getText())){
			showMess("ID exited!");
        }
		
		else if(mgIT.userExited(userNameTF.getText())) {
			showMess("Username exited!");
		}
		else if(id_managerTF.getText().length() == 0 || name_managerTF.getText().length() == 0 
				|| birthday_managerTF.getText().length() == 0 || genderTF.getText().length() == 0
				|| positionTF.getText().length() == 0 || userNameTF.getText().length() == 0
				|| passwordTF.getText().length() == 0) {
			showMess("Let fill out your form fully! ");
		}
		else {
			mg.setManager_ID(id_managerTF.getText());
			mg.setName(name_managerTF.getText());
			mg.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(birthday_managerTF.getText()));
			mg.setGender(genderTF.getText());
			mg.setPosition(positionTF.getText());
			
			acc.setUsername(userNameTF.getText());
			acc.setPassword(passwordTF.getText());
			sqlConnection.getconnection();
			mgIT.addManager(mg);
			accIT.addAccount(acc);
			showMess("Adding successfully!");
		}
	}
	
	public void resetManager() {
		id_managerTF.setText("");
		name_managerTF.setText("");
		birthday_managerTF.setText("");
		genderTF.setText("");
		positionTF.setText("");
		userNameTF.setText("");
		passwordTF.setText("");
	}
	
	public void showMess(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
}
