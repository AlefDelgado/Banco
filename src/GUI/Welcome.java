package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author alefdelgado
 */
public class Welcome extends JPanel
{

    private final GUI window;

    public Welcome(GUI window)
    {
        this.window = window;
        setLayout(new GridBagLayout());
        setBackground(Color.lightGray);
        
        // Panel central
        JPanel panelWelcome = createWelcome();
        add(panelWelcome);
        
    }
    
    private JPanel createWelcome()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(40, 50, 40, 50)));
        panel.setPreferredSize(new Dimension(450, 600));
        
        
        
        JButton loginBtn = GUI.createPrimaryButton("Iniciar Sesion");
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.setMaximumSize(new Dimension(350, 45));
        panel.add(loginBtn);
        
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JButton registerBtn = GUI.createPrimaryButton("Conviertete en cliente");
        registerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerBtn.setMaximumSize(new Dimension(350, 45));
        panel.add(registerBtn);
        
        return panel;
    }
    
}
