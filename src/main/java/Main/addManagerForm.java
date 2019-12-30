package Main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Interactive.AccountIT;
import Interactive.StudentIT;
import Interactive.sqlConnection;
import Interactive.sqlManager;
import Object.Account;
import Object.Manager;

public class addManagerForm extends JFrame implements ActionListener{
	
	//text field
	private JTextField id_managerTF = new JTextField(30);
	private JTextField name_managerTF = new JTextField(30);
	private JTextField birthday_managerTF = new JTextField(30) ;
	private JTextField genderTF = new JTextField(30);
	private JTextField positionTF = new JTextField(30);
	private JTextField userNameTF = new JTextField(30);
	private JTextField passwordTF = new JTextField(30);
	
	private JButton submitBtn = new JButton("Submit");
	private JButton resetBtn = new JButton("Reset");
	
	//model 
	public addManagerForm() {
		super("Add a new Manager");
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(10,2,6,6));
		
		content.add(new JLabel("ID:"));			content.add(id_managerTF);
		content.add(new JLabel("Name:"));	    content.add(name_managerTF);
		content.add(new JLabel("Birthday:"));	content.add(birthday_managerTF);
		content.add(new JLabel("Gender:"));	    content.add(genderTF);
		content.add(new JLabel("Position:"));   content.add(positionTF);
		content.add(new JLabel("Username:"));   content.add(userNameTF);
		content.add(new JLabel("Password:"));	content.add(passwordTF);
		content.add(submitBtn);					content.add(resetBtn);
		
		submitBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		
		setContentPane(content);
		pack();
		
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
		sqlManager sqlmg = new sqlManager();
		Manager mg = new Manager();
		Account acc = new Account();
		if(sqlmg.idExited(id_managerTF.getText())){
			showMess("ID exited!");
        }
		
		else if(sqlmg.userExited(userNameTF.getText())) {
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
			StudentIT.addManager(mg);
			AccountIT.addAccount(acc);
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
