package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Interactive.AccountIT;
import View.MainForm;

/**
 * @author Nhung
 */
public class LoginForm extends JFrame implements ActionListener {
	public LoginForm() {
		initComponents();
		setTitle("Domitory Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 460);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Nhung
		panel1 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		label2 = new JLabel();
		button1 = new JButton();
		label3 = new JLabel();
		button2 = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel1 ========
		{
			panel1.setBackground(new Color(0, 51, 51));

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel1.setLayout(null);

			//---- label1 ----
			label1.setText("Username");
			label1.setFont(new Font("Garamond", Font.PLAIN, 22));
			label1.setForeground(new Color(204, 204, 255));
			panel1.add(label1);
			label1.setBounds(70, 75, 225, 60);
			panel1.add(textField1);
			textField1.setBounds(70, 125, 440, 50);
			panel1.add(textField2);
			textField2.setBounds(70, 240, 440, 50);

			//---- label2 ----
			label2.setText("Password");
			label2.setFont(new Font("Garamond", Font.PLAIN, 22));
			label2.setForeground(new Color(204, 204, 255));
			panel1.add(label2);
			label2.setBounds(70, 185, 265, 75);

			//---- button1 ----
			button1.setText("Sign in");
			button1.setBackground(Color.white);
			button1.setFont(new Font("Garamond", Font.PLAIN, 20));
			button1.setForeground(new Color(0, 5, 51));
			panel1.add(button1);
			button1.setBounds(170, 330, 155, 35);

			//---- label3 ----
			label3.setText("LOGIN ");
			label3.setHorizontalAlignment(SwingConstants.CENTER);
			label3.setForeground(new Color(204, 204, 255));
			label3.setFont(new Font("Garamond", Font.BOLD, 26));
			panel1.add(label3);
			label3.setBounds(165, 20, 270, 70);

			//---- button2 ----
			button2.setText("Sign up");
			button2.setBackground(Color.white);
			button2.setFont(new Font("Garamond", Font.PLAIN, 20));
			button2.setForeground(new Color(0, 5, 51));
			panel1.add(button2);
			button2.setBounds(370, 330, 141, 35);

			{ // compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel1.getComponentCount(); i++) {
					Rectangle bounds = panel1.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel1.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel1.setMinimumSize(preferredSize);
				panel1.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(panel1, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn.equals(button1)) {
			AccountIT accIT = new AccountIT();
			String taikhoan = textField1.getText();	
			String matkhau = textField2.getText();
			
			if(accIT.Login(taikhoan,matkhau)) {
				MainForm main = new MainForm();
				main.setVisible(true);
			}	
			else
			{
				showMess("Please check your user or password!");
			}
		}
		else if (btn.equals(button2)) {
			
		}
	}
	
	public void showMess(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Nhung
	private JPanel panel1;
	private JLabel label1;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel label2;
	private JButton button1;
	private JLabel label3;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public void DataTest() {
		AccountIT ait = new AccountIT();
		ait.openSSF();
		for (int i = 1;i <= 50;++ i) {
			ait.Registration("admin" + i, "1", "1");
		}
		ait.closeSSF();

	}

	public static void main (String[] args) {

		LoginForm login = new LoginForm();
		login.DataTest();
		login.setVisible(true);
	}
	
}
