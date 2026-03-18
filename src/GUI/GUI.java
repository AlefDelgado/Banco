package GUI;

import java.awt.Color;

import javax.swing.*;

/**
 *
 * @author alefdelgado
 */
public class GUI extends JFrame
{
    public GUI()
    {
        // titulo del programa
        super("BANCO CUUT");
        
        // Invocacion de la barra de menu
        JMenuBar bar = createMenuBar();
        setJMenuBar(bar);
        
        revalidate();
        repaint();
    }
    
    private JMenuBar createMenuBar()
    {
        // Creacion y estetica de la barra de menu
        JMenuBar bar = new JMenuBar();
        bar.setBackground(Color.GRAY);
        bar.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        
        // Crear el menu 1
        JMenu menu = new JMenu("Menu");
        menu.setForeground(Color.BLACK);
        menu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        // Crear el submenu "Acerca de"
        JMenuItem aboutThis = new JMenuItem("Acerca del Sistema");
        aboutThis.setForeground(Color.BLACK);
        aboutThis.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        aboutThis.addActionListener(e ->
        {
            createPersonalizedDialogue("BANCA CUUT",
                    "Banca Electronica \n" +
                    "Sistema Ficticio \n"+
                    "Autor: Alef Delgado",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        
        // Crear el submenu para salir del sistema
        JMenuItem exit = new JMenuItem("Salir");
        exit.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(e ->
        {
            int answer = JOptionPane.showConfirmDialog(
                    this,
                    "Seguro que desea abandonar el sistema?",
                    "ADVERTENCIA!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
            
        });
        
        menu.add(aboutThis);
        menu.addSeparator();
        menu.add(exit);
        
        bar.add(menu);
        
        return bar;
    }
    
    // Metodo auxiliar para dialgo personalizado
  
    private void createPersonalizedDialogue(String title, String message, int type)
    {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
    
}
