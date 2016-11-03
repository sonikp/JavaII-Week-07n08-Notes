import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class MnemonicsEx extends JFrame
{
	public MnemonicsEx()
	{
		initUI();
	}
	
	public void initUI()
	{
		JButton btn = new JButton("Button");
		btn.addActionListener((ActionEvent e) -> 
		{
			System.out.println("Button pressed");
		});
		
		btn.setMnemonic(KeyEvent.VK_B);
		
		createLayout(btn);
		
		setTitle("Mnemonic");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void createLayout(JComponent... arg)
	{
		Container pane = getContentPane();
		GroupLayout g1 = new GroupLayout(pane);
		pane.setLayout(g1);
		
		g1.setAutoCreateContainerGaps(true);
		
		g1.setHorizontalGroup(g1.createSequentialGroup().addComponent(arg[0]).addGap(200));
		
		g1.setVerticalGroup(g1.createParallelGroup().addComponent(arg[0]).addGap(200));
		
		pack();
		
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> 
		{
			MnemonicsEx ex = new MnemonicsEx();
			ex.setVisible(true);
		});
	}
}