import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Display an icon of a frame. Shown in the 
 * left part of the titlebar
 * @author sonikp
 *
 */


public class FrameIconEx extends JFrame
{
	public FrameIconEx()
	{
		initUI();
	}
	
	public void initUI()
	{
		ImageIcon webIcon = new ImageIcon("web.png");
		
		setIconImage(webIcon.getImage());
		
		setTitle("Icon");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			FrameIconEx ex = new FrameIconEx();
			ex.setVisible(true);
		});
	}
}