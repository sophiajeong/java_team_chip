package app.src;

import javax.swing.*;
import java.awt.*;

public class SignupPage extends JPanel {
    private MainApp mainApp;

    public SignupPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        formPanel.add(new JLabel("이름:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("이메일:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("비밀번호:"));
        formPanel.add(passwordField);

        JButton signupButton = new JButton("회원가입");
        signupButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // 데이터베이스에 사용자 추가
            mainApp.getDatabaseManager().addUser(name, email, password);
            JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
            mainApp.showLoginPage();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(signupButton);

        add(new JLabel("회원가입", JLabel.CENTER), BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
