package automation;

public class RegistrationInformation {
    public final String username;
    public final String email;
    public final String password;
    public final String passwordConfirm;

    public RegistrationInformation(String username,
                                  String email,
                                  String password,
                                  String passwordConfirm){
        this.username = username;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }
}
