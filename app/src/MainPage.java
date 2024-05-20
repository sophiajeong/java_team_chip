package app.src;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {
    private MainApp mainApp;

    public MainPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton closetButton = new JButton("내 옷장 관리");
        JButton coordinationButton = new JButton("코디 컨설팅");
        JButton laundryGuideButton = new JButton("세탁 방법 안내");
        JButton addClothingButton = new JButton("옷 추가");
        JButton mypageButton = new JButton("마이페이지");

        closetButton.addActionListener(e -> mainApp.showClosetPage());
        coordinationButton.addActionListener(e -> mainApp.showCoordinationPage());
        laundryGuideButton.addActionListener(e -> mainApp.showLaundryGuidePage());
        addClothingButton.addActionListener(e -> mainApp.showAddClothingPage());
        mypageButton.addActionListener(e -> mainApp.showMyPage());

        add(closetButton);
        add(coordinationButton);
        add(laundryGuideButton);
        add(addClothingButton);
        add(mypageButton);
    }
}
