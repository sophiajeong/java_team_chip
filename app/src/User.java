package app.src;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String profileImagePath;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImagePath = ""; // 기본값으로 빈 문자열 설정
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }
}
