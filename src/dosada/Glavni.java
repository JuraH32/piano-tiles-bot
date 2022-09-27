package dosada;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Glavni {
	
	public static Robot robot;
	public static int x1, y, x2;
	public static int buffer = 50;
	
	public static void main (String[] args) {
		System.out.println("IDK");
		Rectangle rec = new Rectangle (1, 460, 550, 600);
		x1 = 575;
		y = 600;
		try {
			robot = new Robot ();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < 10000; i++) {
			//BufferedImage image = robot.createScreenCapture(rec);
			for (int x = 0; x <= 460; x += 120) {
				Color color = robot.getPixelColor(x1 + x,y);
				//robot.mouseMove(x1 + x,y);
				if (isClose (color)) {
					click (x1 + x);
				}
				//System.out.println (robot.getPixelColor(x,y));
				//System.out.printf ("%d %d\n", x, y);
			}
				

		}
		
	}
	
	public static boolean isClose (Color c) {
		//System.out.println(c);
		if (c.getGreen() <= buffer && c.getRed() <= buffer && c.getBlue() <= buffer) {
			return true;
		}
		return false;
	}
	
	public static void click (int x2) {
			robot.mouseMove(x2,y);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	}
}
