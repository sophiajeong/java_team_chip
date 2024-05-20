package app.src;

import javax.swing.*;
import java.awt.*;

// LaundryGuidePage 클래스는 세탁 방법 안내 페이지를 정의합니다.
public class LaundryGuidePage extends JPanel {
    private MainApp mainApp;

    public LaundryGuidePage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        JTextArea laundryGuide = new JTextArea(10, 40);
        laundryGuide.setText("세탁 방법 안내를 제공합니다.\n");

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(new JLabel("세탁 방법 안내", JLabel.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(laundryGuide), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
