package alex.stud.service.interfaces;

public interface SecurityService {
    String findLoggedInUserName();
    void autoLogin(String username, String password);
}
