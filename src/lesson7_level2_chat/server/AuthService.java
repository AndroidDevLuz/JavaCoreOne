package lesson7_level2_chat.server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
}
