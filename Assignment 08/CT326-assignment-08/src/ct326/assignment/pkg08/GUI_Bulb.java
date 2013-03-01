/*****
 * CT326 - Assignment 08 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg08;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/***** ASSIGNMENT INSTRUCTION
 * Develop a simple GUI-based Java program that may be used to control a light bulb.
 * Use suitable Swing components to allow the light bulb controller to perform the
 * following functions:
 */
public class GUI_Bulb extends JFrame implements ChangeListener
{
    private String timeNames[] = { "morning", "evening", "all day" };
    private String bulbNames[] = { "bulb00.jpg", "bulb01.jpg", "bulb02.jpg", "bulb03.jpg", "bulb04.jpg" };
    private ImageIcon bulbs[] = {   new ImageIcon(getClass().getResource("/resources/"+bulbNames[0])),
                                    new ImageIcon(getClass().getResource("/resources/"+bulbNames[1])),
                                    new ImageIcon(getClass().getResource("/resources/"+bulbNames[2])),
                                    new ImageIcon(getClass().getResource("/resources/"+bulbNames[3])),
                                    new ImageIcon(getClass().getResource("/resources/"+bulbNames[4]))};
    private ImageIcon switch_OFF = new ImageIcon(getClass().getResource("/resources/switch_OFF.jpg"));
    private ImageIcon switch_ON = new ImageIcon(getClass().getResource("/resources/switch_ON.jpg"));
    private JLabel bulbLabel, switchLabel;
    private JSlider slider;
    private JList timeList;
    private JButton watt20Button, watt40Button, watt60Button;
    private int screenHeight = 300;
    private int screenWidth = 280;
    
    
    public GUI_Bulb()
    {
        super("let there be light...");
        
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.setBackground(Color.black);
        
        bulbLabel = new JLabel(bulbs[0]);
        slider = new JSlider(JSlider.VERTICAL, 0, 60, 0);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setBackground(Color.black);
        switchLabel = new JLabel(switch_OFF);
        timeList = new JList(timeNames);
        timeList.setVisibleRowCount(3);
        timeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        timeList.setBackground(Color.black);
        timeList.setForeground(Color.white);
        watt20Button = new JButton("20");
        watt40Button = new JButton("40");
        watt60Button = new JButton("60");
        
        slider.addChangeListener(this);
        switchLabel.addMouseListener(new SwitchMouseAdapter(this));
                
        container.add(bulbLabel);
        container.add(slider);
        container.add(switchLabel);
        container.add(timeList);
        container.add(watt20Button);
        container.add(watt40Button);
        container.add(watt60Button);
        
        /***** ASSIGNMENT INSTRUCTION
         * 2. Choose a scheduled time from a list - either morning, evening, 
         * or all day long. 
         */
        timeList.addListSelectionListener( new ListSelectionListener() {
            
                @Override
                public void valueChanged(ListSelectionEvent lse)
                {
                    JList source = (JList)lse.getSource();
                    String value = (String)source.getSelectedValue();
                    System.out.println("EVENT: JList: "+value);
                }
            }
        );
        
        /***** ASSIGNMENT INSTRUCTION
         * 3. Light intensity buttons - 20W, 40W or 60W.
         */    
        watt20Button.addActionListener(new ActionListener()
        { 
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                System.out.println("EVENT: 20 watt button");
                slider.setValue(20);
            }
        });
        
        watt40Button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                System.out.println("EVENT: 40 watt button");
                slider.setValue(40);
            }
        });
        
        watt60Button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                System.out.println("EVENT: 60 watt button");
                slider.setValue(60);
            }
        });
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        setLocation(((dimension.width-screenWidth)/2), (dimension.height-screenHeight)/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setSize( screenWidth, screenHeight );
        setResizable( false );
        setVisible( true );
    }
    
    /***** ASSIGNMENT INSTRUCTION
     * NB: I'm using the stateChanged property of the slider to handle logical
     * changes for the gfx representation
     * 3. Light intensity buttons - 20W, 40W or 60W. 
     */
    @Override
    public void stateChanged(ChangeEvent ce)
    {
        System.out.println("EVENT: Slider");
        JSlider source = (JSlider)ce.getSource();
        int position = (int)source.getValue();
        if(position == 0) {
            bulbLabel.setIcon(bulbs[0]);
            switchLabel.setIcon(switch_OFF);
        } else if(position >0 && position<20) {
            bulbLabel.setIcon(bulbs[1]);
        } else if(position == 20) {
            bulbLabel.setIcon(bulbs[2]);
        } else if(position == 40) {
            bulbLabel.setIcon(bulbs[3]);
        } else if(position == 60) {
            bulbLabel.setIcon(bulbs[4]);
        }
        if(position>0) 
        {
            switchLabel.setIcon(switch_ON);
        }
    }
/***** ASSIGNMENT INSTRUCTION
 * 1. Switch the lightbulb system on or off. 
 */  
    class SwitchMouseAdapter extends MouseAdapter 
    {         
        private SwitchMouseAdapter(GUI_Bulb aThis) {
            
        }
        @Override
        public void mouseClicked(MouseEvent evt) {
            if(evt.getClickCount() == 1) 
            {
                if(switchLabel.getIcon() == switch_OFF) 
                {
                    slider.setValue(60);
                } 
                else
                {
                    slider.setValue(0);
                }
            System.out.println("EVENT: Mouse click");
            }
        }
    }
}
