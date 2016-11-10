// ControlFrame.java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class ImageControlFrameTest extends JFrame
{
	private JPanel mainPanel;
	private Picture chosenImage;
	
	private final JPanel calcPanel;
	private JSlider widthJSlider;
	private JSlider widthJSliderRect;
	private JLabel image;
	
	public ImageControlFrameTest(String title)
	{
		super( title );
	    mainPanel = new JPanel( new BorderLayout() );
	    mainPanel.setSize(200, 250);   
	    
	    // investigate
	    calcPanel = new JPanel( new FlowLayout() );    
	    calcPanel.setSize(200, 200);  
	    

	    // drawing test for show Picture to draw a rectangle
	    final ImageControlPanel drawImagePanel = new ImageControlPanel();
	    drawImagePanel.setSize(200, 200);
	    
	    this.setContentPane( mainPanel );
	    
	    JMenu fileMenu = new JMenu( "File" );
	    fileMenu.setMnemonic( 'F' );
	    
	    JMenuItem showItem = new JMenuItem( "Show..." );
	    showItem.setMnemonic( 'S' );
	    fileMenu.add( showItem );
	    showItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
//	        	JFileChooser fc = new JFileChooser();
//	            int result = fc.showOpenDialog(null);
//	            if (result == JFileChooser.APPROVE_OPTION) 
	            {
//	                File file = fc.getSelectedFile();
//	                String sname = file.getAbsolutePath(); //THIS WAS THE PROBLEM
	                String sname = "/Users/Shared/Java-Libraries/CourseCD/mediasources/gokart.png";
	                image = new JLabel("", new ImageIcon(sname), JLabel.CENTER);
	                mainPanel.add(image, BorderLayout.CENTER);
	                mainPanel.revalidate(); //ADD THIS AS WELL
	                mainPanel.repaint();  //ADD THIS AS WELL
	            }
	        	
	        }
	     }  // End of anonymous inner class
	     );
	    
	    final JMenuBar bar = new JMenuBar();  	// Create a JMenuBar so we can attach menus to it.
	    setJMenuBar( bar );  					// Attach the JMenuBar to the ControlFrame.
	    bar.add( fileMenu );  					// Add the file menu to the JMenuBar.
	    
	    
	    JMenuItem exitItem = new JMenuItem( "Exit" );
	    exitItem.setMnemonic( 'x' );
	    fileMenu.add( exitItem );
	    exitItem.addActionListener(
	      new ActionListener()
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	          System.exit( 0 );
	        }
	      }
	    );
	    
	    
	    // exit operations
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	    setSize( 200, 250 );
	    setVisible( true );
	    validate();
	}
	
}