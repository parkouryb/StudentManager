package Main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Main.addManagerForm;

public class MainForm extends JFrame implements ActionListener{
	//Buttons
	private JButton addButton; 
	private JButton searchButton; 
	private JButton topButton;
	private JButton botButton;
	
	//Data of Buttons
	public static String addString = "Add new Student";
	public static String srcString = "Edit or Delete Student";
	public static String top = "Add new Manager";
	public static String bot = "Finding no rent";
		
	//Data Of Jframe
	public static String title = "Quản lý ký túc xá";
	public static int width = 500;
	public static int height = 300;
		
	//Data of JPanel
	public static int hgap = 0;
	public static int vgap = 0;
		
	public MainForm() {
		//Set up frame
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//Set up a Panel
		JPanel content = new JPanel();
		setContentPane(content);
		content.setLayout(new GridLayout(3,1,1,1));
			
		//set up buttons
		topButton = new JButton(top);
		content.add(topButton);
	        
		JPanel content1 = new JPanel();
		content.add(content1);
		content1.setLayout(new GridLayout(1,2,1,1));
	     
		addButton = new JButton(addString);
	    content1.add(addButton);
	        
	    searchButton = new JButton(srcString);
	    content1.add(searchButton);
	    
	    botButton = new JButton(bot);
	    content.add(botButton);
	    
	    //Set up Action
	    topButton.addActionListener(this);
	    addButton.addActionListener(this);
	    searchButton.addActionListener(this);
	    botButton.addActionListener(this);
	        
	        
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn.equals(topButton)) {
			addManagerForm amf = new addManagerForm();
			amf.setVisible(true);
		}
		else if (btn.equals(addButton)) {
			addStudentForm ast = new addStudentForm();
			ast.setVisible(true);
		}
		else if(btn.equals(botButton)) {
			searchPaidForm spf = new searchPaidForm();
			spf.setVisible(true);
		}
	}
}
