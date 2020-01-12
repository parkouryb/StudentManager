package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * @author Nhung
 */
public class StudentForm extends JFrame implements ActionListener{
	public StudentForm() {
		super("Student");
		initComponents();
		setBounds(100, 100, 700, 430);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Nhung
		panel1 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label1 = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel1 ========
		{
			panel1.setFont(new Font("Garamond", Font.PLAIN, 22));
			panel1.setBackground(new Color(0, 51, 51));

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel1.setLayout(null);

			//---- button1 ----
			button1.setFont(new Font("Garamond", Font.PLAIN, 22));
			button1.setText("Student and Contract");
			button1.setBackground(Color.white);
			button1.setForeground(new Color(0, 5, 51));
			panel1.add(button1);
			button1.setBounds(60, 165, 540, 45);

			//---- button2 ----
			button2.setFont(new Font("Garamond", Font.PLAIN, 22));
			button2.setText("Search Student");
			button2.setBackground(Color.white);
			button2.setForeground(new Color(0, 5, 51));
			panel1.add(button2);
			button2.setBounds(60, 230, 540, 45);

			//---- button3 ----
			button3.setFont(new Font("Garamond", Font.PLAIN, 22));
			button3.setText("Find No Money Student");
			button3.setBackground(Color.white);
			button3.setForeground(new Color(0, 5, 51));
			panel1.add(button3);
			button3.setBounds(60, 290, 540, 45);

			//---- label1 ----
			label1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 48));
			label1.setText("More Student");
			label1.setForeground(new Color(204, 204, 255));
			panel1.add(label1);
			label1.setBounds(175, 25, 495, 115);

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
		button3.addActionListener(this);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton actButton = (JButton) e.getSource();
		if(actButton.equals(button1)) {
			AddStudentForm addStudentForm = new AddStudentForm();
			addStudentForm.setVisible(true);
		}
		else if(actButton.equals(button3)) {
			SearchPaymentForm searchUnPaidForm = new SearchPaymentForm();
			searchUnPaidForm.setVisible(true);
		}
		else if(actButton.equals(button2)) {
			SearchStudentForm searchStudentForm = new SearchStudentForm();
			searchStudentForm.setVisible(true);
		}
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Nhung
	private JPanel panel1;
	private JButton button1;		//add student
	private JButton button2;		//search student
	private JButton button3;		//find not paid student
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
}
