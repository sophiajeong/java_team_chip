package app.src;

public class Clothing {
    private final String name;
    private final String color;
    private final String season;
    private final String style;
    private final String laundry;
    private final String imageUrl; // 이미지 URL을 저장하는 필드 추가
    private final String category;  // category 필드 추가

    // 생성자에서 모든 필드를 초기화
    public Clothing(String name, String color, String season, String style, String laundry, String imageUrl, String category) {
        this.name = name;
        this.color = color;
        this.season = season;
        this.style = style;
        this.laundry = laundry;
        this.imageUrl = imageUrl; // 생성자에 imageUrl 매개변수 추가
        this.category = category;  // 생성자에서 category 초기화
    }

    // Getter 메소드 추가
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSeason() {
        return season;
    }

    public String getStyle() {
        return style;
    }

    public String getImageUrl() {
        return imageUrl; // 이미지 URL 반환 메소드 추가
    }

    public String getCategory() {
        return category;
    }
}
