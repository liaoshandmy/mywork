package yjmyzz.dubbo.demo.provider;
 
import yjmyzz.dubbo.demo.api.User;
import yjmyzz.dubbo.demo.api.UserService;
 
public class UserServiceImpl implements UserService {
 
    public User getUser(Long id) {
        return new User(id, "username" + id);
    }
}