import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleMenuEx extends JFrame
{
	public SimpleMenuEx()
	{
		initUI();
	}
	
	public void initUI()
	{
		createMenuBar();
		
		setTitle("Simple Menu Bar");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		ImageIcon icon = new ImageIcon("exit.png");
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem eMenuItem = new JMenuItem("Exit", icon);
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Exit Application");
		eMenuItem.addActionListener((ActionEvent event) -> 
		{
			System.exit(0);
		});
		
		JMenuItem eMenuHelpItem = new JMenuItem("Help", icon);
		eMenuHelpItem.setMnemonic(KeyEvent.VK_H);
		eMenuHelpItem.setToolTipText("Help Application");
		eMenuHelpItem.addActionListener((ActionEvent event) -> 
		{
			System.out.println("do you need help?");
		});
		
		file.add(eMenuItem);
		file.add(eMenuHelpItem);
		
		menuBar.add(file);
		
		setJMenuBar(menuBar);
		
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> 
		{
			SimpleMenuEx ex = new SimpleMenuEx();
			ex.setVisible(true);
		});
	}
}