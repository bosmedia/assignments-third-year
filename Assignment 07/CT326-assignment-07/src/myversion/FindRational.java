/*****
 * CT326 - Assignment 07 - c.loughnane1@nuigalway.ie - 09101916
 */
package myversion;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

/***** ASSIGNMENT INSTRUCTION
 * 5. Modify the program to use the built-in Collections.binarySearch() method 
 * to check if a particular fraction is contained within the list. Print out your
 * results. Use a JOptionPane input for this part.
 */
public class FindRational extends JFrame
{
    private JTextField textNumerator, textDenominator;
    private JTextArea messageDisplay;
    private JLabel label1, label2;
    private JScrollPane scrollPane;
    private int screenWidth = 420;
    private int screenHeight = 200;
    private TextFieldHandler textHandler;
    private JButton fractionButton;
    
    public FindRational()
    {
        super("Assignment 07 - 0910196 - Rational Play");
        
        Container container = getContentPane();
        container.setLayout( new FlowLayout() );
        
        messageDisplay = new JTextArea();
        messageDisplay.setColumns(35);
        messageDisplay.setRows(8);
        messageDisplay.setEditable(false);
        
        DefaultCaret caret = (DefaultCaret)messageDisplay.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        scrollPane = new JScrollPane(messageDisplay);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        textNumerator = new JTextField( 3 );
        textDenominator = new JTextField( 3 );
        
        label1 = new JLabel("Enter a fraction:");
        label2 = new JLabel("/");

        fractionButton = new JButton("New Fraction");
        
        container.add(label1);
        container.add(textNumerator);
        container.add(label2);
        container.add(textDenominator);
        container.add(fractionButton);
        container.add(scrollPane);
        
        textHandler = new TextFieldHandler();
        
        textNumerator.addActionListener(textHandler);
        textDenominator.addActionListener(textHandler);
        
        fractionButton.addActionListener
                ( new ActionListener() 
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        TestProgram.getFractionInput();
                    }
                }
        );
                
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        setLocation(((dimension.width-screenWidth)/2), (dimension.height-screenHeight)/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setSize( 420, 200 );
        setResizable( false );
        setVisible( true );
    }

    private class TextFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            int numerator;
            int denominator;
           
            if (event.getSource() == textNumerator || event.getSource() == textDenominator)
            {
                try
                {
                    numerator = Integer.parseInt(textNumerator.getText());
                    if((denominator = Integer.parseInt(textDenominator.getText()))==0)
                    {
                        display("ERROR: denominator cannot be zero. Adjusted to one.\n");
                        denominator = 1;
                    }
                    Rational seekRational = new Rational(numerator,denominator);
                    display("searching for "+seekRational.toString()+"...\n");
                }
                catch(Exception e)
                {
                    display("ERROR: Invalid values entered\n");
                }
            }
        }
    }
    
    public void display(String someText)
    {
        messageDisplay.append(someText);
    }
}
