import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField email_input;

    private  JPasswordField password_input;

    User user ;
    private LoginDAO loginDo;
    Login(){
        setTitle("Login - Survey");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel useremail = new JLabel("Enter the email :");
        email_input = new JTextField();
        JLabel userpassword = new JLabel("Enter the password : ");
        password_input = new JPasswordField();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        loginDo = new LoginDAO();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        JButton SignInButton = new JButton("SignI N");
        SignInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                authenticateUser();
            }
        });

        panel.add(useremail);
        panel.add(email_input);
        panel.add(userpassword);
        panel.add(password_input);
        panel.add(loginButton);
        panel.add(SignInButton);


        add(panel, BorderLayout.NORTH);
       setVisible(true);
    }

    private void authenticateUser() {
        String email = email_input.getText();
        String password = new String(password_input.getPassword());

        if(loginDo.verfiyUser(new User(email,password))){
            JOptionPane.showMessageDialog(Login.this, "Authentication successful!");
            this.dispose();
            new Four();
        }
        else{
            JOptionPane.showMessageDialog(Login.this, "Authentication failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
