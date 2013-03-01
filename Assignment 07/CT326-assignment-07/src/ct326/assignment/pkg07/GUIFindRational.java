/*****
 * CT326 - Assignment 07 - c.loughnane1@nuigalway.ie - 09101916
 */
package ct326.assignment.pkg07;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/***** ASSIGNMENT INSTRUCTION
 * 5. Modify the program to use the built-in Collections.binarySearch() method 
 * to check if a particular fraction is contained within the list. Print out your
 * results. Use a JOptionPane input for this part.
 */
public class GUIFindRational extends JFrame
{
    private int screenWidth = 350;
    private int screenHeight = 65;
    private JButton fractionButton, newListButton, QUITButton;
    
    public GUIFindRational()
    {
        super("Assignment 07 - 0910196 - Rational Play");
        
        Container container = getContentPane();
        container.setLayout( new FlowLayout() );
                
        fractionButton = new JButton("New Fraction");
        newListButton = new JButton("New List");
        QUITButton = new JButton("QUIT");
        container.add(fractionButton);
        container.add(newListButton);
        container.add(QUITButton);
        
        fractionButton.addActionListener( new ActionListener() 
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        TestProgram.getFractionInput();
                    }
                }
        );
        
        newListButton.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent event )
                {
                    TestProgram.newArrayValues();
                }
            }
        );
        
        QUITButton.addActionListener( new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        System.exit(0);
                    }
                }
        );
                
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        setLocation(((dimension.width-screenWidth)/2), (dimension.height-screenHeight)/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setSize( screenWidth, screenHeight );
        setResizable( false );
        setVisible( true );
    }
}
