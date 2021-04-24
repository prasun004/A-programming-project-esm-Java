import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login implements ActionListener{

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static JFrame frame = new JFrame();


    public static void main(String[] args) {

        JPanel panel = new JPanel();


        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);


        JLabel label = new JLabel("User");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("login");
        button.setBounds(100, 80, 165, 25);
        button.addActionListener(new Login());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 250);
        panel.add(success);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /* ACTION WHEN BUTTON IS CLICKED */
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + ", " + password);

        if(user.equals("Admin") && password.equals("Admin")) {
            Admin admin = new Admin();
            frame.dispose();
        }else if(user.equals("Student") && password.equals("Student")){
            Student student = new Student();
            frame.dispose();
        }
    }

}


