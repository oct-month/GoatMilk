package cn.ablocker.GoatMilkPowder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.ablocker.GoatMilkPowder.entity.User;

@Component
public interface UserDAO extends JpaRepository<User, String>
{
}
