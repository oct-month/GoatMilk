package cn.ablocker.GoatMilkPowder.dao;

import cn.ablocker.GoatMilkPowder.entity.GoatDNAContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GoatDNAContentDAO extends JpaRepository<GoatDNAContent, Long>
{
}
