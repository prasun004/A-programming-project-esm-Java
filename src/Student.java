import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class Student extends JFrame {
    private static JLabel userLabel;
    private static JTextField userText;
    private static JTextField snoText;
    private static JLabel passwordLabel;
    private static JButton button;
    private static JLabel success;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    Student(){

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Name");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        userLabel = new JLabel("Symbol No");
        userLabel.setBounds(10, 50, 80, 25);
        panel.add(userLabel);

        snoText = new JTextField(20);
        snoText.setBounds(100, 50, 165, 25);
        panel.add(snoText);


        userLabel = new JLabel("Faculty");
        userLabel.setBounds(10, 80, 100, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 80, 165, 25);
        panel.add(userText);

        userLabel = new JLabel("Grade");
        userLabel.setBounds(10, 110, 165, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 110, 165, 25);
        panel.add(userText);

        button = new JButton("Submit");
        button.setBounds(100, 170, 165, 25);
        button.addActionListener(this::actionPerformed);
        panel.add(button);

        frame.setVisible(true);
    }

    private void actionPerformed(ActionEvent actionEvent) {
         Database db = new Database();
        List<String> list = null;
        int sno = Integer.parseInt(snoText.getText());
        try {
             list = db.getFromDatabase(sno);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int[] num ={10, 100, 190, 280};
        int counter = 0;

        for (String i: list) {
            userLabel = new JLabel(i);
            userLabel.setBounds( num[counter], 200, 165, 25);
            panel.add(userLabel);
            counter++;
        }
    }
}
