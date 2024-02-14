import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Saldo extends JFrame {

    private JPanel panelsaldo;
    private JButton menuButton;
    private JLabel lblsaldo;
    private int idUsuario = 1;
    private int saldobanco;

    public Saldo(int saldobanco) {
        super("Saldo");
        this.saldobanco = saldobanco;
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mostrarSaldo();

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_Opciones menu = new Menu_Opciones();
                menu.setVisible(true);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelsaldo);
                frame.dispose();
            }
        });

    }

    private void mostrarSaldo() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "123456mm");
            String query = "SELECT saldo FROM Saldos WHERE idUsuario = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int saldo = resultSet.getInt("saldo");
                lblsaldo.setText(String.valueOf(saldo));
            } else {
                lblsaldo.setText("Saldo no encontrado");
            }

            resultSet.close();
            preparedStatement.close();
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
        }
    }

    public void actualizarSaldo(int deposito) {
        // Aquí actualizas el saldo según el depósito realizado
        saldobanco += deposito;
        // Actualizas el texto del JLabel con el nuevo saldo
        lblsaldo.setText(String.valueOf(saldobanco));
    }
}
