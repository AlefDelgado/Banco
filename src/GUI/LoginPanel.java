package GUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author alefdelgado
 */
public class LoginPanel extends JPanel
{
    private final GUI window;

    public LoginPanel(GUI window)
    {
        this.window = window;
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);
        
        JPanel login = createLogin();
        add(login);
    }
    
    private JPanel createLogin()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(
                new Color(200, 200, 200), 1),
                new EmptyBorder(40, 50, 40, 50)));
        panel.setPreferredSize(new Dimension(450, 600));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/ASSETS/Logo.png"));
        Image img = icon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        ImageIcon iconResized = new ImageIcon(img);
        JLabel logo = new JLabel(iconResized);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logo);
        
        panel.add(Box.createRigidArea(new Dimension(0, 60)));
        
        JLabel lblUsr = new JLabel("Usuario");
        lblUsr.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblUsr.setForeground(GUI.GRIS_TEXTO);
        lblUsr.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField txtUsr = createTextField();
        txtUsr.setMaximumSize(new Dimension(350, 40));
        
        panel.add(lblUsr);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(txtUsr);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPassword.setForeground(GUI.GRIS_TEXTO);
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPasswordField txtPassword = createPAsswordField();
        txtPassword.setMaximumSize(new Dimension(350, 40));
        
        panel.add(lblPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(txtPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        
        // Hint de credenciales
        JLabel lblHint = new JLabel("admin/admin o fan/fan", SwingConstants.CENTER);
        lblHint.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblHint.setForeground(new Color(120, 120, 120));
        lblHint.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(lblHint);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Boton ingresar
        
        JButton login = GUI.createPrimaryButton("Ingresar");
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.setMaximumSize(new Dimension(350, 45));
        panel.add(login);
        
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JButton back = GUI.createPrimaryButton("Regresar al inicio");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setMaximumSize(new Dimension(350, 45));
        back.addActionListener(e->
        {
            try
            {
               File archivo = new File("/FILES/cuentas.txt");
                if (!archivo.exists())
                {
                    createPersonalizedDialogue("ERROR",
                            "No existe la base de datos de usuarios",
                            JOptionPane.ERROR_MESSAGE);
                } else
                {
                    if (archivo.length() == 0)
                    {
                        createPersonalizedDialogue("ERROR",
                            "No existen cuentas en la base de datos",
                            JOptionPane.ERROR_MESSAGE);
                    } else
                    {
                        window.showCards("Login");
                    }
                }
            } catch (Exception x)
            {
                x.printStackTrace();
            }
        });
        panel.add(back);
        
        return panel;
    }
    
    private JPasswordField createPAsswordField() {
        JPasswordField field = new JPasswordField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        // Efecto focus
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(GUI.AZUL_SECUNDARIO, 2),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
        
        return field;
    }
    
    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        // Efecto focus
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(GUI.AZUL_SECUNDARIO, 2),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
        
        return field;
    }
    
    public void createPersonalizedDialogue(String title, String message, int type)
    {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
}
