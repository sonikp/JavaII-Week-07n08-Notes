import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

// imported from Assignment 04

public class ImageControlPicture extends Picture
{
	// constructors
	public ImageControlPicture() 
	{
		super();
	}
	
	public ImageControlPicture(String fileName)
	{
	    // let the parent class handle this fileName
	    super(fileName);
	}
	
	public ImageControlPicture(int width, int height)
	{
	    // let the parent class handle this width and height
	    super(width,height);
	}
	
	 public ImageControlPicture(Picture copyPicture)
	  {
	    // let the parent class do the copy
	    super(copyPicture);
	  }
	  
	  public ImageControlPicture(BufferedImage image)
	  {
	    super(image);
	  }
	  
	  // methods
	  public void chromakeyAssignment(Picture background, int x, int y, int width, int height)	
	  {
		  
		  // Create Pixel object
		  Pixel currPixel = null;
		  Pixel newPixel = null;
		  
		  // color settings for filtering out image from another picture
	   	  int colorThreshold = 90;
	   	  int colorTotal = 140;
	   	  
	   	  // local x & y positions
		  int posX;
		  int posY;
		  
		  // step through the columns
		  for ( posX = x; posX < width; posX++)
		  {
			  // step through the rows
			  for ( posY = y; posY < height; posY++)
			  {
				  // get color from subject
				  currPixel = this.getPixel(posX, posY);
				  
				  // create the filter for separating the darkest part of the selected image
				  if ( currPixel.getRed() < colorThreshold || currPixel.getGreen() < colorThreshold 
						  || currPixel.getBlue() < colorThreshold && (currPixel.getRed() 
						  + currPixel.getGreen() + currPixel.getBlue() < colorTotal) ) 
				  {
					  newPixel = background.getPixel(posX - 120, posY - 55);
					  newPixel.setColor(currPixel.getColor());
				  }
			  }
		  }
	  }
	  
	  /**
	   * Method to return a string with information about this picture.
	   * @return a string with information about the picture such as fileName,
	   * height and width.
	   */
	  public String toString()
	  {
	    String output = "Picture, filename " + getFileName() + 
	      " height " + getHeight() 
	      + " width " + getWidth();
	    return output;
	    
	  }
	
}