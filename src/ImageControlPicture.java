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
	
	private int picWidth = 1;
	//private int picHeight = 1;
	
	
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
	  
	  public void clearBlue()
	  {
		  Pixel[] pixelArray = this.getPixels();
			  
		  for ( Pixel value : pixelArray)
		  {
			  //System.out.println(value.getRed() + " " + value.getGreen() + " " + value.getBlue());
			  value.setBlue(0);
		  }
	  }
	  
	  public void mirrorVertical()
	  {
		  int width = this.getWidth();
		  int mirrorPoint = width / 2;
		  Pixel leftPixel = null;
		  Pixel rightPixel = null;
		  
		  // loop through all the rows
		  for (int y = 0; y < getHeight(); y++)
		  {
			  // loop through all the columns
			  for (int x = 0; x < mirrorPoint; x++)
			  {
				  leftPixel = getPixel(x,y);
				  rightPixel = getPixel(width - 1 - x, y);
				  rightPixel.setColor(leftPixel.getColor());
			  }
			  
			  
		  }
	  }
	  
	  
	  public void sepiaTone()
	  {
		  Pixel pixel = null;
		  double redValue = 0;
		  double greenValue = 0;
		  double blueValue = 0;
		  // problem 6.3, limit edge detection
		  int yStart = (this.getWidth() / 4);
		  int yEnd = ((this.getWidth() / 4) * 3);
		  int xStart = (this.getHeight() / 4);
		  int xEnd = ((this.getHeight() / 4) * 3);
		  
		  // first change the current picture to grayscale, create grayscale method
		  this.grayscale();
		  
		  // loop through pixels
		  for ( int x = xStart; x < xEnd; x++)
		  {
			  for ( int y = yStart; y < yEnd; y++)
			  {
				  // get the current pixel and color value
				  pixel = this.getPixel(x, y);
				  redValue = pixel.getRed();
				  greenValue = pixel.getGreen();
				  blueValue = pixel.getBlue();
				  
				  // tint the shadows darker
				  if (redValue < 60)
				  {
					  redValue = redValue * 0.9;
					  greenValue = greenValue * 0.9;
					  blueValue = blueValue * 0.9;
				  }
				  
				  // tint mid-tones a light brown by reducing the blue
				  else if (redValue < 190)
				  {
					  blueValue = blueValue * 0.8;
				  }
				  
				  // tint highlights a light yellow by reducing blue
				  else 
				  {
					  blueValue = blueValue * 0.9;
				  }
				  
				  // set the colors
				  pixel.setRed((int)(redValue));
				  pixel.setGreen((int)(greenValue));
				  pixel.setBlue((int)(blueValue));
						  
			  }
		  }
	  }
	  
	  public void grayscale()
	  {
		  Pixel[] pixelArray = this.getPixels();
		  Pixel pixelObj = null;
		  int intensity = 0;
		  
		  // loop through all the pixels
		  for ( int i = 0; i < pixelArray.length; i++)
		  {
			  // get the current pixel
			  pixelObj = pixelArray[i];
			  
			  // compute the average intensity
			  intensity = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
//			  System.out.println(intensity);
			  
			  // set the pixel color
			  pixelObj.setColor(new Color(intensity,intensity,intensity));
		  }
	  }
	  
	  /////////////////////////////////
	  
	  public void setWidth(int width)
	  {
	    picWidth = width;  
	  }  

	  public int getWidth()
	  {
		  
		  picWidth = super.getWidth();
		  //System.out.println("picWidth" + picWidth);
		  
		  return picWidth;  
	  }  
	  
//	  public void setHeight(int height)
//	  {
//	    picHeight = height;  
//	  }  
//
//	  public int getHeight()
//	  {
//		  
//		  picHeight = super.getHeight();
//		  
//		  return picHeight;  
//	  } 
	  
	  

	  
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