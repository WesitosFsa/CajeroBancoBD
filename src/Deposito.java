import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposito extends JFrame {

    private JPanel paneldeposito;
    private JTextField textField1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton ENTERButton;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a7Button;
    private JButton a0Button;
    private JButton menuButton;
    private JButton borrarButton;

    private Saldo saldoPanel;

    public Deposito(Saldo saldoPanel, int saldo) {
        super("Deposito");
        this.saldoPanel = saldoPanel;

        setContentPane(paneldeposito);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_Opciones menu = new Menu_Opciones();
                menu.setVisible(true);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(paneldeposito);
                frame.dispose();
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "1";
                textField1.setText(consulta);
            }
        });

        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "2";
                textField1.setText(consulta);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "3";
                textField1.setText(consulta);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "4";
                textField1.setText(consulta);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "5";
                textField1.setText(consulta);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "6";
                textField1.setText(consulta);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "7";
                textField1.setText(consulta);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "8";
                textField1.setText(consulta);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "9";
                textField1.setText(consulta);
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consulta = textField1.getText() + "0";
                textField1.setText(consulta);
            }
        });
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositoStr = textField1.getText();
                int deposito = Integer.parseInt(depositoStr);
                saldoPanel.actualizarSaldo(deposito);
                textField1.setText("");

                // Lógica para imprimir factura
                int respuesta = JOptionPane.showConfirmDialog(null, "Quiere imprimir su factura",
                        "Imprimir", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Lógica para imprimir factura aquí
                }
            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });

    }
}