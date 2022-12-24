package anna.luzina.coderun.service.interfaces;

import anna.luzina.coderun.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<Object> isUserPresent(User user);
}