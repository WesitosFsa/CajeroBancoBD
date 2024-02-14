import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CambiarContrasenia extends JFrame {
    private JPanel panel1;
    private JButton cambiarContraseniaButton;
    private JPasswordField newPasswordField;
    private JTextField idUsuarioTextField;

    public CambiarContrasenia() {
        super("Cambiar Contraseña");
        setContentPane(panel1);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        cambiarContraseniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsuario = idUsuarioTextField.getText();
                String newPassword = String.valueOf(newPasswordField.getPassword());

                try {
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "123456mm");

                    String query = "UPDATE Usuarios SET contraseña = ? WHERE idUsuario = ?";
                    PreparedStatement preparedStatement = conexion.prepareStatement(query);
                    preparedStatement.setString(1, newPassword);
                    preparedStatement.setString(2, idUsuario);

                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar la contraseña. Verifique el ID de usuario.");
                    }

                    preparedStatement.close();
                    conexion.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
                }
            }
        });
    }

    public static void main(String[] args) {
        new CambiarContrasenia();
    }
}