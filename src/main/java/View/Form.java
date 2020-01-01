package View;

import java.awt.*;
import javax.swing.*;

/**
 * @author Nhung
 */
public class Form extends JFrame {
	public Form() {
		initComponents();
		setTitle("Domitory Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			button1.setText("Manager");
			panel1.add(button1);
			button1.setBounds(60, 165, 540, 45);

			//---- button2 ----
			button2.setFont(new Font("Garamond", Font.PLAIN, 22));
			button2.setText("Student");
			panel1.add(button2);
			button2.setBounds(60, 230, 540, 45);

			//---- button3 ----
			button3.setFont(new Font("Garamond", Font.PLAIN, 22));
			button3.setText("Room");
			panel1.add(button3);
			button3.setBounds(60, 290, 540, 45);

			//---- label1 ----
			label1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 48));
			label1.setText("Student Manager ");
			label1.setForeground(new Color(204, 204, 255));
			panel1.add(label1);
			label1.setBounds(125, 25, 475, 115);

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
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Nhung
	private JPanel panel1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	public static void main (String[] args) {
		Form view = new Form();
		view.setVisible(true);
	}
}
