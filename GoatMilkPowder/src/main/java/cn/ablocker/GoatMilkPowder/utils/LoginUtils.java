package cn.ablocker.GoatMilkPowder.utils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.ablocker.GoatMilkPowder.dao.LoginSessionDAO;
import cn.ablocker.GoatMilkPowder.dao.UserDAO;
import cn.ablocker.GoatMilkPowder.entity.User;

@Component
public class LoginUtils
{
    @Autowired
    private LoginSessionDAO loginSessionDAO;
    @Autowired
    public UserDAO userDAO;

    public User login(String username, String password, String sessionId)
    {
        Optional<User> dbUser = userDAO.findById(username);
        if (dbUser != null && dbUser.isPresent())
        {
            User user = dbUser.get();
            if (user.getPassword().equals(password))
            {
                loginSessionDAO.set(sessionId, username, 24, TimeUnit.HOURS);
                return user;
            }
        }
        return null;
    }

    public boolean isLogin(String sessionId)
    {
        String username = loginSessionDAO.get(sessionId);
        if (StringUtils.hasText(username))
            return true;
        else
            return false;
    }

    public User getUserData(String sessionId)
    {
        String username = loginSessionDAO.get(sessionId);
        if (!StringUtils.hasText(username))
            return null;
        Optional<User> dbUser = userDAO.findById(username);
        if (dbUser != null && dbUser.isPresent())
        {
            User user = dbUser.get();
            return user;
        }
        return null;
    }

    public String getRole(String sessionId)
    {
        String username = loginSessionDAO.get(sessionId);
        if (!StringUtils.hasText(username))
            return null;
        Optional<User> dbUser = userDAO.findById(username);
        if (dbUser != null && dbUser.isPresent())
        {
            User user = dbUser.get();
            return user.getRole();
        }
        return null;
    }

    public User registry(User user)
    {
        Optional<User> old = userDAO.findById(user.getUsername());
        if (old == null || !old.isPresent())
            return userDAO.save(user);
        else
            return null;
    }
}
