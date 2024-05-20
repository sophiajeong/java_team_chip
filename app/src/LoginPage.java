package app.src;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {
    private MainApp mainApp;

    public LoginPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        formPanel.add(new JLabel("이메일:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("비밀번호:"));
        formPanel.add(passwordField);

        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            User user = mainApp.getDatabaseManager().getUserByEmail(email);
            if (user != null && user.getPassword().equals(password)) {
                mainApp.setCurrentUser(user);
                mainApp.showMainPage();
            } else {
                JOptionPane.showMessageDialog(this, "로그인 실패", "오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton signupButton = new JButton("회원가입");
        signupButton.addActionListener(e -> mainApp.showSignupPage());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);

        add(new JLabel("로그인", JLabel.CENTER), BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
