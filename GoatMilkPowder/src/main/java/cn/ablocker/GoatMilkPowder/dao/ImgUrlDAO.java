package cn.ablocker.GoatMilkPowder.dao;

import cn.ablocker.GoatMilkPowder.entity.ImgUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ImgUrlDAO extends JpaRepository<ImgUrl, String>
{
}
