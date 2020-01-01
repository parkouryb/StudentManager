package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interactive.GetPassword;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;

public class LoginForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField passwordTF;
	private JTextField userTF;
	private JButton loginBtn;
	private JButton exitBtn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("Domitory Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		passwordTF = new JTextField();
		passwordTF.setColumns(10);
		
		userTF = new JTextField();
		userTF.setColumns(10);
		
		loginBtn = new JButton("LOGIN");
		loginBtn.setBackground(Color.CYAN);
		loginBtn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		exitBtn = new JButton("EXIT");
		exitBtn.setBackground(Color.CYAN);
		exitBtn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addComponent(userTF, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(93))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(userTF, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordTF, Alignment.TRAILING)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblLoginForm = new JLabel("LOGIN FORM");
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 36));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblLoginForm, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblLoginForm, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		exitBtn.addActionListener(this);
		loginBtn.addActionListener(this);
	}
	// cai nay la cai cua m ne, con cai login la t code giao dien thoi

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn.equals(exitBtn)) {
			showMess("Are you sure want to quit?");
			System.exit(0);
		}
		else if(btn.equals(loginBtn)) {
			String taikhoan = userTF.getText();	
			String matkhau = passwordTF.getText();
			System.out.print(GetPassword.getlogin(taikhoan,matkhau));
			
			if(GetPassword.getlogin(taikhoan,matkhau)== true)
			{
				MainForm main = new MainForm();
                main.setVisible(true);
			}
			else
			{
				showMess("Please check your user or password!");
			}
		}
	}
	
	public static void showMess(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
