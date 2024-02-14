import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bienvenida extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JButton salirButton;
    private JButton cambiarContraseñaButton;

    public Bienvenida(){
        super("Bienvenida");
        setContentPane(panel1);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Quiere salir de la app?",
                        "Salir", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textField1.getText();
                String contrasenia = new String(passwordField1.getPassword());

                // Conexion a MySQL y validacion de credenciales
                try {
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "123456mm");

                    PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Usuarios WHERE nombre = ? AND contraseña = ?");
                    statement.setString(1, usuario);
                    statement.setString(2, contrasenia);
                    ResultSet resultado = statement.executeQuery();

                    if (resultado.next()) {
                        Menu_Opciones menu = new Menu_Opciones();
                        menu.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en las credenciales");
                        textField1.setText("");
                        passwordField1.setText("");
                    }

                    conexion.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
                }
            }
        });


        cambiarContraseñaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarContrasenia contrasenia = new CambiarContrasenia();
                contrasenia.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bienvenida();
            }
        });
    }
}
