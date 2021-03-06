import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawImageControlPanel extends JPanel
{
	private Color fillColor = Color.RED;
	private int rectWidth = 90;
	  
	  public DrawImageControlPanel()
	  {
	    setSize( 200, 200 ); 
	  }
	  
	  public void paintComponent( Graphics g )
	  {
	    super.paintComponent( g );  // invoke the superclass paintComponent
	    this.setBackground( Color.BLACK );
	    g.setColor( fillColor );
	    g.fillRect( 50, 50, rectWidth, 60 );
	    
	  }
	  
	  void setFillColor(Color fillColor)
	  {
	    this.fillColor = fillColor;  
	  }    
	  
	  void setRectWidth(int rectWidth)
	  {
	    this.rectWidth = rectWidth;  
	  }  

	  int getRectWidth()
	  {
	    return rectWidth;  
	  }  
}