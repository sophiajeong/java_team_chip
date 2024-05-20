package app.src;

import javax.swing.*;
import java.awt.*;

public class AddClothingPage extends JPanel {
    private MainApp mainApp;

    public AddClothingPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 옷 이름
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("옷 이름:"), gbc);
        gbc.gridx = 1;
        JTextField nameField = new JTextField(15);
        inputPanel.add(nameField, gbc);

        // 색상
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("색상:"), gbc);
        gbc.gridx = 1;
        JTextField colorField = new JTextField(15);
        inputPanel.add(colorField, gbc);

        // 계절
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("계절:"), gbc);
        gbc.gridx = 1;
        JTextField seasonField = new JTextField(15);
        inputPanel.add(seasonField, gbc);

        // 스타일
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("스타일:"), gbc);
        gbc.gridx = 1;
        JTextField styleField = new JTextField(15);
        inputPanel.add(styleField, gbc);

        // 세탁 방법
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(new JLabel("세탁 방법:"), gbc);
        gbc.gridx = 1;
        JTextField laundryField = new JTextField(15);
        inputPanel.add(laundryField, gbc);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton addButton = new JButton("추가");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String color = colorField.getText();
            String season = seasonField.getText();
            String style = styleField.getText();
            String laundry = laundryField.getText();

            if (!name.isEmpty() && !color.isEmpty() && !season.isEmpty() && !style.isEmpty() && !laundry.isEmpty()) {
                Clothing clothing = new Clothing(name, color, season, style, laundry, "", "");
                ClosetPage closetPage = (ClosetPage) mainApp.getComponentByName("ClosetPage");
                closetPage.addClothingToList(clothing);
                JOptionPane.showMessageDialog(this, "옷이 추가되었습니다!", "추가 완료", JOptionPane.INFORMATION_MESSAGE);
                mainApp.showClosetPage();
            } else {
                JOptionPane.showMessageDialog(this, "모든 필드를 채워주세요.", "추가 오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showClosetPage());

        buttonPanel.add(addButton);
        buttonPanel.add(backButton);

        // 전체 레이아웃에 패널 추가
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
