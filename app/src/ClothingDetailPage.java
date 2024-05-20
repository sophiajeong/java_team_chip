package app.src;

import javax.swing.*;
import java.awt.*;

// ClothingDetailPage 클래스는 JPanel을 상속받아 옷 상세 정보 페이지를 정의합니다.
public class ClothingDetailPage extends JPanel {
    // mainApp은 MainApp 클래스의 인스턴스를 참조하여 페이지 간 전환을 처리합니다.
    private MainApp mainApp;

    // ClothingDetailPage 생성자
    public ClothingDetailPage(MainApp mainApp) {
        // MainApp 인스턴스를 받아와서 저장합니다.
        this.mainApp = mainApp;
        // UI를 설정하는 메서드 호출
        setupUI();
    }

    // UI를 설정하는 메서드
    private void setupUI() {
        // 레이아웃 매니저를 BorderLayout으로 설정합니다.
        setLayout(new BorderLayout());

        // 옷 상세 정보를 표시할 JTextArea를 생성합니다.
        JTextArea clothingDetail = new JTextArea(10, 40);
        // 초기 텍스트 설정
        clothingDetail.setText("옷 상세 정보\n");

        // 메인 화면으로 돌아가기 위한 버튼을 생성합니다.
        JButton backButton = new JButton("메인 화면으로 돌아가기");
        // 버튼 클릭 시 옷장 페이지로 전환하는 이벤트 리스너 추가
        backButton.addActionListener(e -> mainApp.showClosetPage());

        // BorderLayout의 NORTH 위치에 제목 레이블 추가
        add(new JLabel("옷 상세 정보", JLabel.CENTER), BorderLayout.NORTH);
        // BorderLayout의 CENTER 위치에 JTextArea를 JScrollPane으로 감싸서 추가
        add(new JScrollPane(clothingDetail), BorderLayout.CENTER);
        // BorderLayout의 SOUTH 위치에 돌아가기 버튼 추가
        add(backButton, BorderLayout.SOUTH);
    }
}
