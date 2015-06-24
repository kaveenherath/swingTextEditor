import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TextEditor extends JFrame implements ActionListener {

	
	//TODO add save, load, clear, find 
	public JTextArea tArea;
	public JTextField tField;
	private String title;
	private int height;
	private int width;

	private JButton clear;
	private JButton load;
	private JButton save;
	private JButton find;

	private Box box = Box.createVerticalBox();
	

	public TextEditor(String title, int width, int height) {

		this.title = title;
		this.width = width;
		this.height = height;
		setUp();
	}

	private void setUp() {
		setTitle(title);
		setSize(width, height);
		
		
		setUpButtons();
		
		tArea = new JTextArea(width - 10, height - 10);
		tField = new JTextField("This is a text field");
		tField.setSize(10, 10);
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.LINE_AXIS));
		
		tArea.setSelectedTextColor(Color.BLACK);
		
		Font font = new Font("Verdana", Font.BOLD, 12);
		tArea.setFont(font);
		tArea.setForeground(Color.BLUE);
		
		JScrollPane scrollPane = new JScrollPane(tArea);
		
		c.add(tField);
		c.add(scrollPane);
		c.add(box);
		
		
		setVisible(true);

	}

	private void setUpButtons() {
		clear = new JButton("Clear");
		box.add(clear);
		box.add(Box.createVerticalStrut(40));
		
		load = new JButton("Load");
		box.add(load);
		box.add(Box.createVerticalStrut(40));
		
		save = new JButton("Save");
		box.add(save);
		box.add(Box.createVerticalStrut(40));
		
		find = new JButton("Find");
		box.add(find);
		box.add(Box.createVerticalStrut(40));
		
		addActionListeners();
		
	}
	
	private void loadFile()
	{
		JFileChooser jFile = new JFileChooser();
		jFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jFile.showOpenDialog(this);
		Scanner sc = null;
		
		try {
			if (returnVal == JFileChooser.APPROVE_OPTION) 
				sc= new Scanner(jFile.getSelectedFile());
			 
		}
		catch(Exception e){}
		
		
		String line = "";
		while(sc.hasNext())
			line+=sc.nextLine()+"\n";
		tArea.setText(line);
		
		
	}
	
	
	private void addActionListeners()
	{
		clear.addActionListener(this);
		load.addActionListener(this);
		save.addActionListener(this);
		find.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {

		if(event.getSource().equals(clear)){
			tArea.setText("");
		}
		
		else if (event.getSource().equals(load))
		{
			loadFile();
		}
		else if (event.getSource().equals(save))
		{
			
		}
		else if (event.getSource().equals(find))
		{
			
		}
		
		
	}

}
