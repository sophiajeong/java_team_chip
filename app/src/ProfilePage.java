package app.src;

import javax.swing.*;
import java.awt.*;

// ProfilePage 클래스는 JPanel을 상속받아 사용자 프로필 페이지를 정의합니다.
public class ProfilePage extends JPanel {
    // mainApp은 MainApp 클래스의 인스턴스를 참조하여 페이지 간 전환을 처리합니다.
    private MainApp mainApp;
    // 사용자 이메일을 저장할 변수
    private String userEmail;

    // ProfilePage 생성자
    public ProfilePage(MainApp mainApp, String userEmail) {
        // MainApp 인스턴스를 받아와서 저장합니다.
        this.mainApp = mainApp;
        this.userEmail = userEmail;
        // UI를 설정하는 메서드 호출
        setupUI();
    }

    // 사용자 이메일을 설정하는 메서드
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // UI를 설정하는 메서드
    private void setupUI() {
        // BorderLayout을 사용하여 레이아웃 설정
        setLayout(new BorderLayout(10, 10));

        // 프로필 정보 제목 레이블 설정
        JLabel profileLabel = new JLabel("프로필 정보", JLabel.CENTER);
        profileLabel.setFont(new Font("Serif", Font.BOLD, 20));

        // 프로필 정보를 표시할 JTextArea 생성
        JTextArea profileInfo = new JTextArea();
        profileInfo.setEditable(false);
        profileInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 메인 화면으로 돌아가기 위한 버튼 생성
        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        // 레이아웃에 컴포넌트 추가
        add(profileLabel, BorderLayout.NORTH);
        add(new JScrollPane(profileInfo), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    // 프로필 정보를 업데이트하는 메서드
    public void updateProfileInfo() {
        // DatabaseManager 인스턴스 생성 및 사용자 정보 가져오기
        DatabaseManager dbManager = new DatabaseManager();
        User user = dbManager.getUserByEmail(userEmail);

        // 사용자 정보를 StringBuilder로 구성
        StringBuilder userInfo = new StringBuilder();
        userInfo.append("이름: ").append(user.getName()).append("\n");
        userInfo.append("이메일: ").append(user.getEmail()).append("\n");

        // JTextArea에 사용자 정보 설정
        JTextArea profileInfo = (JTextArea) getComponent(1); // Center component
        profileInfo.setText(userInfo.toString());
    }
}
