// ControlFrame.java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
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
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class ControlFrame extends JFrame
{ 
  private JPanel mainPanel;
  private final JPanel calcPanel;
  private JSlider widthJSlider;
  private JSlider widthJSliderRect;
  
  private JTextField xValTextField;
  private JTextField yValTextField;
  private JLabel calcJLabel;
  private JButton calcJButton;
  
  private String xStr;
  private String yStr;
  
  public ControlFrame(String title)
  {
    super( title );
    mainPanel = new JPanel( new BorderLayout() );
    mainPanel.setSize(200, 250);    
    
    calcPanel = new JPanel( new FlowLayout() );    
    calcPanel.setSize(200, 200);    

    final DrawControlPanel drawPanel = new DrawControlPanel();
    drawPanel.setSize(200, 200);    
    
    
    // drawing test for show Picture to draw a rectangle
    final DrawImageControlPanel drawImagePanel = new DrawImageControlPanel();
    drawImagePanel.setSize(200, 200);
    
    
    // displaying an image file
    //final DrawPictureControlPanel getPiccy = new DrawPictureControlPanel(FileChooser.pickAFile());
    final DrawPictureControlPanel getPiccy = null;
    //getPiccy = new DrawPictureControlPanel(FileChooser.pickAFile());
    
    // try load image
    //Picture p = new Picture(FileChooser.getMediaPath("gokart.png"));
    //Picture p = new Picture(FileChooser.pickAFile());
    
    
    this.setContentPane( mainPanel );
    
    JMenu fileMenu = new JMenu( "File" );
    fileMenu.setMnemonic( 'F' );
    
    // ------- ex - adding edit menu - this is not working
    /*
     * edit menu works, controlled by JMenuBar
     * 
     * ActionListener not working, and 
     */
    JMenu editMenu = new JMenu( "Edit" );
    editMenu.setMnemonic( 'E' );
    fileMenu.add( editMenu );
    
    JMenuItem cutFunction = new JMenuItem( "Cut" );
    cutFunction.setMnemonic( 't' );
    editMenu.add( cutFunction );
    
    /*
    editMenu.addActionListener(
      new ActionListener()
      {
    	  public void actionPerformed( ActionEvent event )
    	  {
    		  JOptionPane.showMessageDialog( ControlFrame.this, 
    				  "Project 5 Week 7", "Project", JOptionPane.PLAIN_MESSAGE );
    	  }
      }

    );
    // ------- END - ex - adding edit menu 
     */
    
    JMenuItem aboutItem = new JMenuItem( "FAbout..." );
    aboutItem.setMnemonic( 'A' );
    fileMenu.add( aboutItem );
    aboutItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          JOptionPane.showMessageDialog( ControlFrame.this,
                                      "This application provides enhanced\n control over multimedia projects.",
                                      "About", JOptionPane.PLAIN_MESSAGE );
        }
     }  // End of anonymous inner class
    );
    
    //  -------  ex - project title: this worked
    JMenuItem projectItem = new JMenuItem( "Project..." );
    projectItem.setMnemonic( 'P' );
    fileMenu.add( projectItem );
    projectItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          JOptionPane.showMessageDialog( ControlFrame.this,
                                      "Project 5 Week 7", "Project", JOptionPane.PLAIN_MESSAGE );
        }
     }  // End of anonymous inner class
    );	//  -------  END - ex - project title
      
    final JMenuBar bar = new JMenuBar();  // Create a JMenuBar so we can attach menus to it.
    setJMenuBar( bar );  // Attach the JMenuBar to the ControlFrame.
    bar.add( fileMenu );  // Add the file menu to the JMenuBar.
    bar.add( editMenu );  // -----ex added edit menu to main bar
  
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
          repaint();
        }
     }  // End of anonymous inner class
    );
     
    JMenuItem calcPanelItem = new JMenuItem( "Calculate" );
    calcPanelItem.setMnemonic( 'C' );
    fileMenu.add( calcPanelItem );
    calcPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          // remove items	
          bar.remove( colorMenu );
          mainPanel.remove( drawPanel );
          mainPanel.remove( drawImagePanel );
          mainPanel.remove( widthJSlider );
          mainPanel.remove( widthJSliderRect );
          
          // create new surface
          xValTextField.setText("");
          yValTextField.setText("");
          calcJLabel.setText( "" );
          mainPanel.add( calcPanel, BorderLayout.CENTER );
          validate();
          repaint();
        }
      }
    );
    
    JMenuItem drawPanelItem = new JMenuItem( "DrawPanel" );
    drawPanelItem.setMnemonic( 'D' );
    fileMenu.add( drawPanelItem );
    drawPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          bar.add( colorMenu );         
          // remove items
          mainPanel.remove( calcPanel );
          mainPanel.remove( drawImagePanel );
          mainPanel.remove( widthJSliderRect );
          
          // create new surface
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
         
          // remove drawPanel
          bar.remove( colorMenu );  
          mainPanel.remove( drawPanel );
          mainPanel.remove( widthJSlider );
          // remove calcPanel
          mainPanel.remove( calcPanel );
          
         
          
          // create new panel
          drawImagePanel.setBackground( Color.WHITE );
          mainPanel.add( drawImagePanel, BorderLayout.CENTER );
          mainPanel.add( widthJSliderRect, BorderLayout.SOUTH );
          
          /*
          // junk
          mainPanel.remove( calcPanel );
          mainPanel.remove( drawPanel );
          drawPanel.setBackground( Color.WHITE );
          mainPanel.add( drawPanel, BorderLayout.CENTER );
          mainPanel.add( widthJSlider, BorderLayout.SOUTH );  
          */
          validate();
          repaint();
          
        }
      }
    );
    
    JMenuItem soundPanelItem = new JMenuItem( "SoundPanel" );
    soundPanelItem.setMnemonic( 'P' );
    fileMenu.add( soundPanelItem );
    soundPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          mainPanel.removeAll();
         // getPiccy = new DrawPictureControlPanel(FileChooser.pickAFile());
        	/*
          bar.add( colorMenu );         
          mainPanel.remove( calcPanel );
          drawPanel.setBackground( Color.WHITE );
          mainPanel.add( drawPanel, BorderLayout.CENTER );
          mainPanel.add( widthJSlider, BorderLayout.SOUTH );          
          */
          
          validate();
          repaint();
        }
      }
    );
    
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
    widthJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 100, drawPanel.getOvalWidth()  );	//drawPanel.getOvalWidth()
    widthJSlider.setMajorTickSpacing( 10 );
    widthJSlider.setPaintTicks( true );
    
    widthJSlider.addChangeListener(
      new ChangeListener()
      {
        public void stateChanged( ChangeEvent e )
        {
        	System.out.println(( widthJSlider.getValue() ));
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
    
    
    
    
    xValTextField = new JTextField( 3 );
    xValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          xStr = event.getActionCommand();
        }
      }
    );                                                                       

    calcPanel.add( xValTextField );

    yValTextField = new JTextField( 3 );
    yValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          yStr = event.getActionCommand();
        }
      }
    );     

    calcPanel.add( yValTextField );
    
    calcJButton = new JButton( "Calculate" );   
    calcJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            calcJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( ControlFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
          }
        }
      }
    );
    calcPanel.add( calcJButton );
    
    calcJLabel = new JLabel();
    calcPanel.add( calcJLabel, BorderLayout.CENTER );
    
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    setSize( 200, 250 );
    setVisible( true );
    validate();
  }
}  