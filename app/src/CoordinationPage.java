package app.src;

import javax.swing.*;
import java.awt.*;

// CoordinationPage 클래스는 코디 컨설팅 페이지를 정의합니다.
public class CoordinationPage extends JPanel {
    private MainApp mainApp;

    public CoordinationPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        JTextArea coordinationAdvice = new JTextArea(10, 40);
        coordinationAdvice.setText("코디 컨설팅을 제공합니다.\n");

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(new JLabel("코디 컨설팅", JLabel.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(coordinationAdvice), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
