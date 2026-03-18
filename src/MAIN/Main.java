package MAIN;

import GUI.GUI;
import javax.swing.JFrame;

/**
 *
 * @author alefdelgado
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        GUI window = new GUI();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}
