import java.awt.EventQueue;
import javax.swing.JFrame;

public class SimpleEx extends JFrame
{
	public SimpleEx()
	{
		initUI();
	}
	
	private void initUI()
	{
		setTitle("Simple Example");		// set title
		setSize(300,200);				// size
		setLocationRelativeTo(null);	// center
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// close window when X clicked
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			SimpleEx ex = new SimpleEx();
			ex.setVisible(true);
		}
		);
	}
}