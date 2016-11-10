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


public class ImageControlFrame extends JFrame
{
	private JPanel mainPanel;
	private Picture chosenImage;
	
	private final JPanel calcPanel;
	private JSlider widthJSlider;
	private JSlider widthJSliderRect;
	private JLabel image;
	
	public ImageControlFrame(String title)
	{
		super( title );
	    mainPanel = new JPanel( new BorderLayout() );
	    mainPanel.setSize(200, 250);    
	    
	    
	    calcPanel = new JPanel( new FlowLayout() );    
	    calcPanel.setSize(200, 200);  
	    
	    
	    final DrawControlPanel drawPanel = new DrawControlPanel();
	    drawPanel.setSize(200, 200);    
	    
	    
	    // drawing test for show Picture to draw a rectangle
	    final ImageControlPanel drawImagePanel = new ImageControlPanel();
	    drawImagePanel.setSize(200, 200);
	    
	    // attempting to access class object method ImageControlPicture
	    ImageControlPicture importImage = new ImageControlPicture();
	    
	    
	    
	    // displaying an image file
	    //FileChooser.setMediaPath("/Users/Shared/Java-Libraries/CourseCD/mediasources/");
	    //final DrawPictureControlPanel getPiccy = new DrawPictureControlPanel(FileChooser.pickAFile());
	    //final DrawPictureControlPanel getPiccy = null;
	    //getPiccy = new DrawPictureControlPanel(FileChooser.pickAFile());
	    
	    // try load image
	    //Picture p = new Picture(FileChooser.getMediaPath("gokart.png"));
	    //Picture p = new Picture(FileChooser.pickAFile());
	    
	    
	    this.setContentPane( mainPanel );
	    
	    JMenu fileMenu = new JMenu( "File" );
	    fileMenu.setMnemonic( 'F' );
	    
	    JMenu editMenu = new JMenu( "Edit" );
	    editMenu.setMnemonic( 'E' );
	    fileMenu.add( editMenu );
	    
	    JMenuItem chooseFunction = new JMenuItem( "ChooseFile" );
	    chooseFunction.setMnemonic( 'o' );
	    editMenu.add( chooseFunction );
	    chooseFunction.addActionListener(
		    new ActionListener()
		    {
		    	public void actionPerformed ( ActionEvent event )
		    	{
		    		drawImagePanel.setBackground( Color.BLUE );
			        mainPanel.add( drawImagePanel, BorderLayout.CENTER );
			        
			        validate();
			        repaint();
		    		
		    		/*
		    		FileChooser.setMediaPath("/Users/Shared/Java-Libraries/CourseCD/mediasources/");
		    		chosenImage = new Picture(FileChooser.pickAFile());
		    		chosenImage.show();
		    		*/
		    		
		    	}
		    }
	    
	    		
	    );
	    
	    JMenuItem newImage = new JMenuItem( "NewImageFromDifferentClass" );
	    newImage.setMnemonic( 'D' );
	    editMenu.add(newImage);
	    newImage.addActionListener(
	  	      new ActionListener()
	  	      {
	  	    	  public void actionPerformed( ActionEvent event )
	  	    	  {
	  	    		
	  	    		  
	  	    		FileChooser.setMediaPath("/Users/Shared/Java-Libraries/CourseCD/mediasources/");
	  	    		ImageControlPicture subject = new ImageControlPicture(FileChooser.getMediaPath("gokart.png"));
	  	    		subject.clearBlue();
	  	    		subject.show();
	  	    		
	  	    		// Attempted to make the object a global object not a method object
	  	    		//importImage.show();
	  	    		  
	  	    	  }
	  	      }

	  	    );
	    
	    
	    editMenu.addActionListener(
	      new ActionListener()
	      {
	    	  public void actionPerformed( ActionEvent event )
	    	  {
	    		  JOptionPane.showMessageDialog( ImageControlFrame.this, 
	    				  "Project 5 Week 7", "Project", JOptionPane.PLAIN_MESSAGE );
	    	  }
	      }

	    );
	    
	     
	    
	    JMenuItem aboutItem = new JMenuItem( "About..." );
	    aboutItem.setMnemonic( 'A' );
	    fileMenu.add( aboutItem );
	    aboutItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	        	
	        	JOptionPane.showMessageDialog( ImageControlFrame.this,
	                                      "This application provides enhanced\n control over multimedia projects.",
	                                      "About", JOptionPane.PLAIN_MESSAGE );
	        }
	     }  // End of anonymous inner class
	    );
	    
	    //  
	    JMenuItem projectItem = new JMenuItem( "Project..." );
	    projectItem.setMnemonic( 'P' );
	    fileMenu.add( projectItem );
	    projectItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	          JOptionPane.showMessageDialog( ImageControlFrame.this,
	                                      "Project 5 Week 7", "Project", JOptionPane.PLAIN_MESSAGE );
	        }
	     }  // End of anonymous inner class
	    );	
	      
	    final JMenuBar bar = new JMenuBar();  	// Create a JMenuBar so we can attach menus to it.
	    setJMenuBar( bar );  					// Attach the JMenuBar to the ControlFrame.
	    bar.add( fileMenu );  					// Add the file menu to the JMenuBar.
	    bar.add( editMenu );  					// -----ex added edit menu to main bar
	  
	    
	    
	    final JMenu colorMenu = new JMenu( "Color" );
	    colorMenu.setMnemonic( 'C' );
	    
	    
	    JMenuItem redItem = new JMenuItem( "Red" );
	    colorMenu.add( redItem );
	    redItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	          drawPanel.setFillColor( Color.RED );
	          drawImagePanel.setFillColor( Color.RED );
	          repaint();
	        }
	     }  // End of anonymous inner class
	    );
	    
	    JMenuItem blueItem = new JMenuItem( "Blue" );
	    colorMenu.add( blueItem );
	    blueItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	          drawPanel.setFillColor( Color.BLUE );
	          drawImagePanel.setFillColor( Color.BLUE );
	          repaint();
	        }
	     }  // End of anonymous inner class
	    );
	    
	    JMenuItem magentaItem = new JMenuItem( "Magenta" );
	    colorMenu.add( magentaItem );
	    magentaItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	          drawPanel.setFillColor( Color.MAGENTA );
	          drawImagePanel.setFillColor( Color.MAGENTA );
	          repaint();
	        }
	     }  // End of anonymous inner class
	    );
	    
	    JMenuItem cyanItem = new JMenuItem( "Cyan" );
	    colorMenu.add( cyanItem );
	    cyanItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	          drawPanel.setFillColor( Color.CYAN );
	          drawImagePanel.setFillColor( Color.CYAN );
	          repaint();
	        }
	     }  // End of anonymous inner class
	    );
	     
	    
		    
	    
	    
	    JMenuItem drawPanelItem = new JMenuItem( "DrawPanel" );
	    drawPanelItem.setMnemonic( 'D' );
	    fileMenu.add( drawPanelItem );
	    drawPanelItem.addActionListener(
	      new ActionListener()
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	                  
	          // remove items
	          //mainPanel.remove( calcPanel );
	          mainPanel.remove( drawImagePanel );
	          mainPanel.remove( widthJSliderRect );
	          
	          // create new surface
	          bar.add( colorMenu ); 
	          drawPanel.setBackground( Color.WHITE );
	          mainPanel.add( drawPanel, BorderLayout.CENTER );
	          mainPanel.add( widthJSlider, BorderLayout.SOUTH );          
	          validate();
	          repaint();
	        }
	      }
	    );
	    
	     
	    
	    JMenuItem showPicture = new JMenuItem( "ShowPicture" );
	    showPicture.setMnemonic( 'S' );
	    fileMenu.add( showPicture );
	    showPicture.addActionListener(
	      new ActionListener()
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	        	// remove all
		        mainPanel.removeAll();
	         
		        FileChooser.setMediaPath("/Users/Shared/Java-Libraries/CourseCD/mediasources/");
  	    		ImageControlPicture subject = new ImageControlPicture(FileChooser.getMediaPath("gokart.png"));
  	    		
  	    		JFileChooser fc = new JFileChooser();
  	    		String imageName = "/Users/Shared/Java-Libraries/CourseCD/mediasources/gokart.png";
  	    		image = new JLabel("", new ImageIcon(imageName), JPanel.WIDTH);
  	    		
  	    		mainPanel.add(image, BorderLayout.CENTER);
		        
		        
	        	/*
	          	// remove individual items drawPanel
	          	bar.remove( colorMenu );  
	          	mainPanel.remove( drawPanel );
	          	mainPanel.remove( widthJSlider );
	          	// remove calcPanel
	          	mainPanel.remove( calcPanel );
	        	 */
		        
		        /*
		        FileChooser.setMediaPath("/Users/Shared/Java-Libraries/CourseCD/mediasources/");
  	    		ImageControlPicture subject = new ImageControlPicture(FileChooser.getMediaPath("gokart.png"));
  	    		subject.clearBlue();
  	    		subject.show();
  	    		JPanel jp = new JPanel();
  	    		jp.getGraphics().
  	    		*/
	          /*
		        // create new panel
		        bar.add( colorMenu ); 
		        drawImagePanel.setBackground( Color.WHITE );
		        mainPanel.add( drawImagePanel, BorderLayout.CENTER );
		        mainPanel.add( widthJSliderRect, BorderLayout.SOUTH );
				*/
	          

	          
		         validate();
		         repaint();
	          
	        }
	      }
	    );
	    
	    /*
	     // backup of method before JPanel manipulation
	    JMenuItem showPicture = new JMenuItem( "ShowPicture" );
	    showPicture.setMnemonic( 'S' );
	    fileMenu.add( showPicture );
	    showPicture.addActionListener(
	      new ActionListener()
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	        	// remove all
		        mainPanel.removeAll();
	         
	          
	        	
	          	// remove individual items drawPanel
	          	bar.remove( colorMenu );  
	          	mainPanel.remove( drawPanel );
	          	mainPanel.remove( widthJSlider );
	          	// remove calcPanel
	          	mainPanel.remove( calcPanel );
	        	 
		        
	          
		        // create new panel
		        bar.add( colorMenu ); 
		        drawImagePanel.setBackground( Color.WHITE );
		        mainPanel.add( drawImagePanel, BorderLayout.CENTER );
		        mainPanel.add( widthJSliderRect, BorderLayout.SOUTH );

	          

	          
		         validate();
		         repaint();
	          
	        }
	      }
	    );
	    
	    */
	    
	    
	    
	    
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
	    
	    
	    
	    // Oval control
	    widthJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 100, drawPanel.getOvalWidth() );
	    widthJSlider.setMajorTickSpacing( 10 );
	    widthJSlider.setPaintTicks( true );
	    
	    widthJSlider.addChangeListener(
	      new ChangeListener()
	      {
	        public void stateChanged( ChangeEvent e )
	        {
	          drawPanel.setOvalWidth( widthJSlider.getValue() );
	          repaint();
	        }
	      }
	    );
	    
	    
	    // Rectangle control
	    widthJSliderRect = new JSlider( SwingConstants.HORIZONTAL, 0, 100, drawImagePanel.getRectWidth() );
	    widthJSliderRect.setMajorTickSpacing( 10 );
	    widthJSliderRect.setPaintTicks( true );
	    
	    widthJSliderRect.addChangeListener(
	      new ChangeListener()
	      {
	        public void stateChanged( ChangeEvent e )
	        {
	          drawImagePanel.setRectWidth( widthJSliderRect.getValue() );
	          repaint();
	        }
	      }
	    );
	    
	    
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	    setSize( 200, 250 );
	    setVisible( true );
	    validate();
	    
	}
}