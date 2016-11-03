import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Position a JButton on the window and add an action listener to the button
 * @author sonikp
 *
 */

public class QuitButtonEx extends JFrame
{
	public QuitButtonEx()
	{
		initUI();
	}
	
	private void initUI()
	{
		JButton quitButton = new JButton("Quit!");				// create button component, and add string component
		quitButton.addActionListener((ActionEvent event) ->		// add an actionListener to the button
		{
			System.exit(0);					// action terminates the application by calling the System.exit method
		});
		
		createLayout(quitButton);			// child component need to be placed into containers, this delegates the task to createLayout() method
		
		setTitle("Quit Button");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createLayout(JComponent... arg)		// content pane of a JFrame is an area where child components are placed
	{
		Container pane = getContentPane();				
		GroupLayout g1 = new GroupLayout(pane);
		pane.setLayout(g1);
		
		g1.setAutoCreateContainerGaps(true);			// creates gaps between components and the edges of the container. Space or gaps are important part of the design of each application
		
		g1.setHorizontalGroup(g1.createSequentialGroup().addComponent(arg[0]));		// arg[0])
		
		g1.setVerticalGroup(g1.createSequentialGroup().addComponent(arg[0]));	// arg[0])
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> 
		{
			QuitButtonEx ex = new QuitButtonEx();
			ex.setVisible(true);
		});
		
		
	}
}