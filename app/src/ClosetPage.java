package app.src;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class ClosetPage extends JPanel {
    private final MainApp mainApp;
    private final Map<String, List<Clothing>> clothingCategories = new HashMap<>();
    private final JList<String> clothingJList = new JList<>();
    private final DefaultListModel<String> listModel = new DefaultListModel<>();

    public ClosetPage(MainApp mainApp) {
        this.mainApp = mainApp;
        initializeCategories();
        setupUI();
    }

    private void initializeCategories() {
        clothingCategories.put("상의", new ArrayList<>());
        clothingCategories.put("하의", new ArrayList<>());
        clothingCategories.put("겉옷", new ArrayList<>());
        clothingCategories.put("신발", new ArrayList<>());
        clothingCategories.put("악세서리/모자", new ArrayList<>());
    }

    public void setupUI() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton addButton = new JButton("옷 추가");
        addButton.addActionListener(e -> mainApp.showAddClothingPage());

        JButton detailButton = new JButton("옷 상세 정보");
        detailButton.addActionListener(e -> mainApp.showClothingDetailPage());

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        buttonPanel.add(addButton);
        buttonPanel.add(detailButton);
        buttonPanel.add(backButton);

        clothingJList.setCellRenderer(new ClothingCellRenderer());
        clothingJList.setModel(listModel);
        JScrollPane scrollPane = new JScrollPane(clothingJList);

        add(new JLabel("내 옷장 관리", JLabel.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addClothingToList(Clothing clothing) {
        String category = clothing.getCategory().toLowerCase();
        clothingCategories.get(category).add(clothing);
        updateDisplay();
    }

    private void updateDisplay() {
        listModel.clear();
        clothingCategories.forEach((category, clothings) -> {
            clothings.sort(Comparator.comparing(Clothing::getName));
            for (Clothing clothing : clothings) {
                listModel.addElement(clothing.getName() + " (" + category + ")");
            }
        });
    }
}
