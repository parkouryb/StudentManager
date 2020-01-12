package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RoomForm extends JFrame implements ActionListener{
	public RoomForm() {
		super("Room");
		initComponents();
		setBounds(100, 100, 700, 430);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Nhung
		button1 = new JButton();
		button2 = new JButton();
		label1 = new JLabel();
		panel1 = new JPanel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- button1 ----
		button1.setText("Add New Room");
		button1.setFont(new Font("Garamond", Font.PLAIN, 24));
		button1.setBackground(Color.white);
		button1.setForeground(new Color(0, 5, 51));
		contentPane.add(button1);
		button1.setBounds(45, 205, 280, 110);

		//---- button2 ----
		button2.setText("Find Blank Room");
		button2.setFont(new Font("Garamond", Font.PLAIN, 24));
		button2.setBackground(Color.white);
		button2.setForeground(new Color(0, 5, 51));
		contentPane.add(button2);
		button2.setBounds(365, 205, 280, 110);

		//---- label1 ----
		label1.setText("Student's Room");
		label1.setForeground(new Color(204, 204, 255));
		label1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 48));
		contentPane.add(label1);
		label1.setBounds(155, 35, 470, 135);

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
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 685, 385);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton actButton = (JButton) e.getSource();
		if(actButton.equals(button1)) {
			AddRoomForm addRoomForm = new AddRoomForm();
			addRoomForm.setVisible(true);
		}
		else if(actButton.equals(button2)) {
			SearchRoomForm searchRoomForm = new SearchRoomForm();
			searchRoomForm.setVisible(true);
		}
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
		// Generated using JFormDesigner Evaluation license - Nhung
		private JButton button1;		//add new room
		private JButton button2;		// find room
		private JLabel label1;
		private JPanel panel1;
		// JFormDesigner - End of variables declaration  //GEN-END:variables
}
