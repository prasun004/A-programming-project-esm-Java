import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JTextField gradeText;
    private static JTextField sno;
    private static JTextField seat;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;

    Admin() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);


        JLabel label = new JLabel("Symbol No");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        sno = new JTextField(20);
        sno.setBounds(100, 20, 165, 25);
        panel.add(sno);

        userLabel = new JLabel("School");
        userLabel.setBounds(10, 50, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 50, 165, 25);
        panel.add(userText);

        userLabel = new JLabel("Name");
        userLabel.setBounds(10, 80, 165, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 80, 165, 25);
        panel.add(userText);

        userLabel = new JLabel("Seat");
        userLabel.setBounds(10, 110, 165, 25);
        panel.add(userLabel);

        seat = new JTextField(20);
        seat.setBounds(100, 110, 165, 25);
        panel.add(seat);

        userLabel = new JLabel("Grade");
        userLabel.setBounds(10, 140, 165, 25);
        panel.add(userLabel);

        gradeText = new JTextField(20);
        gradeText.setBounds(100, 140, 165, 25);
        panel.add(gradeText);

        button = new JButton("Add student");
        button.setBounds(100, 170, 165, 25);
        button.addActionListener(this::actionPerformed);
        panel.add(button);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = userText.getText();
        int seating =  Integer.parseInt(seat.getText());
        int symbol = Integer.parseInt(sno.getText());
        String cls = gradeText.getText();
        Database db = new Database();
        Database.addToTables(name, cls, seating,symbol);
    }
}

