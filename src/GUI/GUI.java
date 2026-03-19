package GUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author alefdelgado
 */
public class GUI extends JFrame
{
    
    private JLabel titulo;
    
    public Color verdeUAEM = new Color(60, 75, 36);
    
    public GUI()
    {
        // titulo del programa
        super("BANCO CUUT");
        setLayout(new BorderLayout());
        
        // Invocacion de la barra de menu
        JMenuBar bar = createMenuBar();
        setJMenuBar(bar);
        
        // Invocar encabezado
        JPanel header = createHeader();
        add(header, BorderLayout.NORTH);
        
        // Invocar pie de pagina
        JPanel footer = createFooter();
        add(footer, BorderLayout.SOUTH);
        
        revalidate();
        repaint();
    }
    
    private JMenuBar createMenuBar()
    {
        // Creacion y estetica de la barra de menu
        JMenuBar bar = new JMenuBar();
        bar.setBackground(Color.GRAY);
        bar.setOpaque(true);
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
            createPersonalizedDialogue("BANPOTRO",
                    "Banca Electronica \n" +
                    "¡SISTEMA NO OFICIAL! \n"+
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
    
    // Creacion y configuracion del encabezado
    private JPanel createHeader()
    {
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(verdeUAEM);
        header.setPreferredSize(new Dimension(0, 80));
        
        titulo = new JLabel("BANPOTRO", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        
        header.add(titulo, BorderLayout.CENTER);
        
        return header;
    }
    
    private JPanel createFooter()
    {
        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());
        footer.setBackground(verdeUAEM);
        footer.setPreferredSize(new Dimension(0,80));
        
        JLabel lblfoot = new JLabel("2026 UAEMex - BANCA ELECTRONICA", SwingConstants.CENTER);
        lblfoot.setForeground(Color.WHITE);
        lblfoot.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        
        footer.add(lblfoot, BorderLayout.CENTER);
        
        return footer;
    }
    
    // Metodo auxiliar para dialgo personalizado
  
    private void createPersonalizedDialogue(String title, String message, int type)
    {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
    
}
