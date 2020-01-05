package ro.ase.translatorApp.userManagement;

public class User {
    private String username;
    private String password;
    private TipUser rol;

    public User(){}

    public User(String username, String password, TipUser rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipUser getRol() {
        return rol;
    }

    public void setRol(TipUser rol) {
        this.rol = rol;
    }
}
