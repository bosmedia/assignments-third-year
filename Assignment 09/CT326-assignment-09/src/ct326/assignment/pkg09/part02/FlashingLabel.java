/*****
 * CT326 - Assignment 09 - c.loughnane1@nuigalway.ie - 09101916
 */
package ct326.assignment.pkg09.part02;

import java.applet.Applet; 
import java.awt.*;

/***** ASSIGNMENT INSTRUCTION
 * Create a Java class called FlashingLabel that takes a text string and displays
 * it centered in an Applet.
 */
public class FlashingLabel extends Applet implements Runnable 
{ 
    private Thread animator; 
    private boolean frozen = false, display = true;
    private String myFont;
    private String myString;
    private Font font;
    private int fontSize;
    private int sleepTime;
    private int x,y;
    
    /***** ASSIGNMENT INSTRUCTION
    * The font, the text string to be displayed, and the sleepTime (in milliseconds)
    * should be passed as parameters from html. 
    */   
    @Override
    public void init() 
    {
	String str = getParameter("sleepTime");
	sleepTime = (str != null) ? Integer.parseInt(str) : 10;
        fontSize  = Integer.parseInt(getParameter("fontSize"));
        myFont = getParameter("font");
        myString = getParameter("string");
        
        font = new Font(myFont, Font.BOLD, fontSize);  
  
        //String      message = new String("Hello, StackOverflow!");
        //Font        defaultFont = new Font("Helvetica", Font.PLAIN, 12);
//        FontMetrics fontMetrics = new FontMetrics(font) {};
//        int stringWidth = fontMetrics.stringWidth(myString);
//        x = (width - stringWidth) / 2;
    }
    
    @Override
    public void start() 
    { 
	if (frozen) { 
	/* Do nothing. The user has requested that we stop the flashing string */

        } else { 
	    // Start animating! 
	    if (animator == null) { 
		animator = new Thread(this); 
	    } 
	    animator.start();
	}
    }
    
    @Override
    public void stop() { 
	// Stop the animation thread.
	animator = null;
    }
    
    @Override
    public boolean mouseDown(Event e, int x, int y) { 
	if (frozen) { 
	    frozen = false; 
            start(); 
	} else { 
	    frozen = true; 
            stop(); 
	} 
	return true;
    }
      
    @Override
    public void run() {
	//lower this thread's priority
	Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	
	// Remember the starting time.	
	long startTime = System.currentTimeMillis();
	
	// This is the animation loop.	
	while (Thread.currentThread() == animator) 
        { 	    
	    repaint();
	    
	    //Delay depending on how far we are behind.	    
	    try { 
		startTime +=sleepTime;
		Thread.sleep(Math.max(0, startTime-System.currentTimeMillis())); 
	    } catch (InterruptedException e) { 
		break; 
	    }
	}
    }
    
    /***** ASSIGNMENT INSTRUCTION
    * The text should blink on and off at a rate determined by the sleepTime 
    * parameter switching between 2 strings each time. 
    */    
    @Override
    public void paint(Graphics g) { 
        
        g.setFont(font);
        
        /* centers text dynamically */
        Dimension d = getSize();
        FontMetrics fm = g.getFontMetrics();
        x = (d.width - fm.stringWidth(myString)) / 2;

        /* controls display of string */
        if(display)
        {
            g.drawString(myString, x, 100);
            display = false;
        }
        else
        {
            g.drawString("", x, y/2);
            display = true;
        }
    } 
}