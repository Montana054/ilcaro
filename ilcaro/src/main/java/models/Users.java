package models;

public class Users {
    String email;
    String password;
String name;
String lasteName;


    public Users withName(String name) {
        this.name = name;
        return this;
    }

    public Users withLasteName(String lasteName) {
        this.lasteName = lasteName;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLasteName() {
        return lasteName;
    }

    public Users withEmail(String email) {// флюинстайл - set поменяли на with
        this.email = email;
        return this;
    }

    public Users withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
