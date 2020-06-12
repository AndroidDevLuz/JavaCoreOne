package lesson8_level2_chat_timeout.server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
    boolean registration(String login, String password, String nickname);
}
