// package
package mainPackage;

// libs
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// main class
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// jframe objects
	private JPanel contentPane;
	private JTextField inputField;
	private JButton getNeighbours;

	// main function
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUI frame = new GUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				
				}
			}
			
		});
	}
	
	
	// window
	public GUI() {
		// window setup
		setTitle("ArrayNeighbours");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// label
		JLabel lblEnterANumber = new JLabel("Enter a number (1-41):\r\n");
		lblEnterANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterANumber.setBounds(126, 67, 177, 29);
		contentPane.add(lblEnterANumber);
		
		
		// input field 
		inputField = new JTextField();
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				
				 if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					 
					 // checks if input is actually an integer
					 try {
						 
						 int rows = Integer.parseInt(inputField.getText());
						 
						 // checks if number isnt too big (computing time uwu)
						 if (rows <= 41) {
						 
							 // case switch - checks if the number is uneven, if uneven then we do the default operation
							 switch(rows % 2) 
							 {
							 	
							 	// runs if number is even
							 	case 0:
							 		JOptionPane.showMessageDialog(null, "Please fill in an uneven number");
							 		break;
							 	
							 	// default operation
							 	default:	 		
	
									 // configure variables
									 ArrayList<String> array = GetArray.create2DArray(rows);
									 String printableArray = "";
									 int reset = -1;
									 
									 array.set((array.size() / 2) - 1, "_");
									 
									 
									 // create array grid
									 for (int item = 0; item != array.size(); item++) {
										 
										 reset++;
										 
										 // checks if we havent hit the reset breakpoint yet
										 if (reset != rows) {
											 
											 // adds item to the string
											 printableArray += array.get(item).replace("0", "\u00A4").replace("1", "c") + " ";
											 
											 // sets variable 'reset' to 0 so we can print the new items in the next row
											 if (reset == rows+1) {
												 
												 reset = 0;
												 
											 }
											 
										 }
										 // adds a new line in the string so we can start adding the new items on the next line
										 else {
											 
											 printableArray += "\n";
											 
										 }
										 
									 }
										
			
									 // creates label with the array grid
									 contentPane.removeAll();
									 repaint();
									
									 setBounds(100, 100, 720, 720);
									 setLocationRelativeTo(null);

									 JLabel outputLabel = new JLabel("");
									 outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
									 outputLabel.setBounds(10, 11, 694, 669);
									 contentPane.add(outputLabel);
									 
									 // makes sure every new line is actually a new line
									 outputLabel.setText("<html>" + printableArray.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
									
									 
									 // get neighbors button 
									 getNeighbours = new JButton("Get Neighbours");
									 
									 getNeighbours.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent arg0) {
											
											String[] nOption = {"4", "8"};
											int nPick = JOptionPane.showOptionDialog(null, "Pick the amount of neighnours you want to review", "Neighbours", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, nOption, nOption);
											
											if (nPick != -1) {
												
												if (nPick == 0) {
													
													ArrayList<String> pos = GetNeighbours.requestN4(array);
													
													String printablePos = ("Right: " + pos.get(0) + "\n" + "Left: " + pos.get(1) + "\n" + "Mid: " + pos.get(2) + "\n" + "Top: " + pos.get(3) + "\n" + "Bottom: " + pos.get(4) + "\n").replace("0", "\u00A4").replace("1", "c");
													System.out.println(printablePos);
												
												}
												
												else {
													
													ArrayList<String> pos = GetNeighbours.requestN8(array);
													
												}
												
											} // pick -1 option
											
										} // closes action listener
									});
									 
									 getNeighbours.setBounds(0, 0, 150, 25);
									 contentPane.add(getNeighbours);
																	 									 
							 } // case switch
						 } // if number is too big it will run this
						 
						 else {
							 
							 JOptionPane.showMessageDialog(null, "Please fill in an integer between 1 and 41");
							 
						 }
						 						 
					 // error handling 
					 } catch (Exception e) {
						 
						 JOptionPane.showMessageDialog(null, "Please fill in an integer between 1 and 41");
						 
					 } 
					
					 
				 } // closes if statement
				
			}
		}); // action listener kinda stuff
		
		inputField.setBounds(157, 113, 119, 52);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		// request focus
		inputField.setFocusable(true);
		inputField.requestFocus();
		
	}
}
