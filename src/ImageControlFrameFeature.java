// ControlFrame.java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class ImageControlFrameFeature extends JFrame
{
	private JPanel mainPanel;
	private Picture chosenImage;
	
	private final JPanel calcPanel;
	private JSlider widthJSlider;
	private JSlider widthJSliderRect;
	private JLabel image;
	
	private String pictureImage;
	private JSlider widthJSliderPic;
	private int jSlideInt = 200;

	
	public ImageControlFrameFeature(String title)
	{

		super( title );
	    mainPanel = new JPanel( new BorderLayout() );
	    mainPanel.setSize(200, 250);   
	    
	    // investigate
	    calcPanel = new JPanel( new FlowLayout() );    
	    calcPanel.setSize(200, 200);  
	    

	    // drawing test for show Picture to draw a rectangle
	    final ImageControlPanel drawImagePanel = new ImageControlPanel();
	    drawImagePanel.setSize(500, 640);
	    
	    ImageControlPicture imagePicture = new ImageControlPicture();

	    
	    
	    this.setContentPane( mainPanel );
	    
	    JMenu fileMenu = new JMenu( "PFile" );
	    fileMenu.setMnemonic( 'F' );
	    
	    JMenuItem showItem = new JMenuItem( "Show..." );
	    showItem.setMnemonic( 'S' );
	    fileMenu.add( showItem );
	    showItem.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	        	mainPanel.removeAll();
	        	pictureImage = "/Users/Shared/Java-Libraries/CourseCD/mediasources/gokart.png";
                image = new JLabel(new ImageIcon(pictureImage), JLabel.CENTER);	//sname
                mainPanel.add(image, BorderLayout.CENTER);
                mainPanel.revalidate(); //ADD THIS AS WELL
                mainPanel.repaint();  //ADD THIS AS WELL
	        	
	        	
	        }
	     }  // End of anonymous inner class
	     );
	    
	    JMenuItem ShowImage = new JMenuItem( "ShowImage..." );
	    ShowImage.setMnemonic( 'I' );
	    fileMenu.add( ShowImage );
	    ShowImage.addActionListener(
	      new ActionListener()  // Beginning of anonymous inner class
	      {
	        public void actionPerformed( ActionEvent event )
	        {
	        	 mainPanel.removeAll();
	
	        	
	        	pictureImage = "/Users/Shared/Java-Libraries/CourseCD/mediasources/gokart.png";
                

	        	ImageIcon imgIcon = new ImageIcon(pictureImage);
	        	Image imageFile = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));


	        	mainPanel.add(picLabel, BorderLayout.CENTER);
	        	mainPanel.revalidate(); //ADD THIS AS WELL
                mainPanel.repaint();  //ADD THIS AS WELL
	        	
				


	        }
	     }  // End of anonymous inner class
	     );
	    
	    
	    ////////////****************
	    
	 // Filters applied to ShowImage function
	    JMenuItem additionalOne = new JMenuItem( "Sepia" );
	    additionalOne.setMnemonic( 'S' );
	    fileMenu.add(additionalOne);
	    additionalOne.addActionListener(
	  	  new ActionListener()  // Beginning of anonymous inner class
	  	  {
	  	        public void actionPerformed( ActionEvent event )
	  	        {

	  	        	
	  	        	mainPanel.removeAll();
	  	        
	  	        	pictureImage = "/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg";	//gokart.png
	  	        	// arch.jpg height 480 width 360

	  	        	// create picture object
	  	        	ImageControlPicture filteredPic = new ImageControlPicture(pictureImage);
	  	        	System.out.println(filteredPic);
	  	        	filteredPic.sepiaTone();
	  	        	BufferedImage buff = filteredPic.getBufferedImage();	//BufferedImage 
	  	        	
	  	        	ImageIcon imgIcon = new ImageIcon(buff);
	  	        	Image imageFile = imgIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);	// 200, widthJSliderPic.getValue(), jSlideInt
	  	        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));

	  	        	mainPanel.add(picLabel, BorderLayout.CENTER);
	  	        	revalidate(); 
	                repaint();  

	  	        }
	  	     }  // End of anonymous inner class
	  	     );
	    
	    
	    
	    ////////////////*************88
	    
	    
	    
	    
	    // Filters applied to ShowImage function
	    JMenuItem filterItemOne = new JMenuItem( "Additional..." );
	    filterItemOne.setMnemonic( 'O' );
	    fileMenu.add(filterItemOne);
	    filterItemOne.addActionListener(
	  	  new ActionListener()  // Beginning of anonymous inner class
	  	  {
	  	        public void actionPerformed( ActionEvent event )
	  	        {

	  	        	
	  	        	mainPanel.removeAll();
	  	        
	  	        	pictureImage = "/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg";	//gokart.png
	  	        	// arch.jpg height 480 width 360

	  	        	// create picture object
	  	        	ImageControlPicture filteredPic = new ImageControlPicture(pictureImage);
	  	        	System.out.println(filteredPic);
	  	        	
	  	        	BufferedImage buff = filteredPic.getBufferedImage();	//BufferedImage 
	  	        	
	  	        	ImageIcon imgIcon = new ImageIcon(buff);
	  	        	Image imageFile = imgIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);	// 200, widthJSliderPic.getValue(), jSlideInt
	  	        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));

	  	        	mainPanel.add(picLabel, BorderLayout.CENTER);
	  	        	mainPanel.add( widthJSliderPic, BorderLayout.SOUTH ); 
	  	        	revalidate(); 
	                repaint();  

	  	        }
	  	     }  // End of anonymous inner class
	  	     );
	    
	    //widthJSliderPic = new JSlider( SwingConstants.HORIZONTAL, 0, 100, imagePicture.getWidth() ); //drawImagePanel.getOvalWidth()
	    widthJSliderPic = new JSlider( SwingConstants.HORIZONTAL, 200, 360, imagePicture.getWidth() ); // imagePicture.getWidth()
	    widthJSliderPic.setMajorTickSpacing( 10 );
	    widthJSliderPic.setPaintTicks( true );
	    
	    widthJSliderPic.addChangeListener(
	      new ChangeListener()
	      {
	        public void stateChanged( ChangeEvent e )
	        {
	        	imagePicture.setWidth( widthJSliderPic.getValue());
//	        	jSlideInt = widthJSliderPic.getValue();
//	        	System.out.println(jSlideInt);
	        	System.out.println(widthJSliderPic.getValue());
	        	repaint();
	   
	        }
	      }
	    );
	    
	    ///ShowImageWithFilter...
//	    JMenuItem showFilteredImage = new JMenuItem( "ShowImageWithFilter..." );
//	    showFilteredImage.setMnemonic( 'F' );
//	    fileMenu.add( showFilteredImage );
//	    showFilteredImage.addActionListener(
//	      new ActionListener()  // Beginning of anonymous inner class
//	      {
//	        public void actionPerformed( ActionEvent event )
//	        {
//
//	        	mainPanel.removeAll();
//	        	String sname = "/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg";
//
//
//	        	ImageControlPicture filteredPic = new ImageControlPicture(sname);
//	        	//filteredPic.clearBlue();
//	        	filteredPic.mirrorVertical();
//	        	BufferedImage buff = filteredPic.getBufferedImage();
//	        	
//	        	ImageIcon imgIcon = new ImageIcon(buff);
//	        	Image imageFile = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//	        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));
//
//	        	mainPanel.add(picLabel, BorderLayout.CENTER);
//	        	mainPanel.revalidate(); //ADD THIS AS WELL
//                mainPanel.repaint();  //ADD THIS AS WELL
//
//
//	        }
//	     }  // End of anonymous inner class
//	     );
	    ///ShowImageWithFilter...
	    
	    ///Sound....
//	    JMenuItem soundItem = new JMenuItem( "Sound..." );
//	    soundItem.setMnemonic( 'S' );
//	    fileMenu.add( soundItem );
//	    soundItem.addActionListener(
//	      new ActionListener()  // Beginning of anonymous inner class
//	      {
//	        public void actionPerformed( ActionEvent event )
//	        {
//	        	mainPanel.removeAll();
//	        	// http://www.developer.com/java/other/article.php/2173111/Java-Sound-Playing-Back-Audio-Files-using-Java.htm
//	        	
//	        	String soundFile = "/Users/Shared/Java-Libraries/CourseCD/mediasources/thisisatest.wav";
//	        	ImageControlSound newSound = new ImageControlSound(soundFile);
//	        	//newSound.explore();
//	        	//newSound.doubleFreq();
//	        	//newSound.mirror();
//	        	//newSound.echo(10);
//	        	newSound.reverse();
//	        	newSound.play();
//	        	
//	        	// open the sound file as a Java input stream
//	            /*
//	            InputStream in = null;
//				try {
//					in = new FileInputStream(soundFile);
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//	            // create an audiostream from the inputstream
//	            AudioStream audioStream = null;
//				try {
//					audioStream = new AudioStream(in);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//	            // play the audio clip with the audioplayer class
//	            AudioPlayer.player.start(audioStream);
//				*/
//	        	
//	        	
//	        	
//	        	/*
//	        	ImageControlPicture filteredPic = new ImageControlPicture(sname);
//	        	filteredPic.clearBlue();
//	        	BufferedImage buff = filteredPic.getBufferedImage();
//	        	
//	        	ImageIcon imgIcon = new ImageIcon(buff);
//	        	Image imageFile = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//	        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));
//
//	        	mainPanel.add(picLabel, BorderLayout.CENTER);
//	        	mainPanel.revalidate(); //ADD THIS AS WELL
//                mainPanel.repaint();  //ADD THIS AS WELL
//				*/
//	        	
//	        }
//	     }  // End of anonymous inner class
//	     );
	    ///Sound....
	    
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