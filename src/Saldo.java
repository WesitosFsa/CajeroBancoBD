import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Saldo extends JFrame {
    private JPanel panel1;
    private JPanel panelsaldo;
    private JTextField saldotexto;
    private JButton menuButton;
    private JLabel Saldo;
    private JLabel lblsaldo;
    public static int saldobanco = 200;




    public Saldo() {
        super("Saldo");
        setContentPane(panelsaldo);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lbltext();

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
    private void lbltext(){
        String saldo = String.valueOf(saldobanco);
        lblsaldo.setText(saldo);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Saldo();
            }
        });
    }
}

