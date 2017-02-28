package generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class Utility {
	
	public static String getFormatedDateTime()
	{
		SimpleDateFormat dt = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		return dt.format(new Date());
	}
	
	public static String getDeskTopScreenshot(String folder)
	{
		String timeStamp = Utility.getFormatedDateTime();
		
		try
		{
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect = new Rectangle(d);
			
			Robot r = new Robot();
			BufferedImage img = r.createScreenCapture(screenRect);
			
			File output = new File(folder +timeStamp+ ".png");
			ImageIO.write(img, "png", output);			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return timeStamp+".png";
	}	
}
