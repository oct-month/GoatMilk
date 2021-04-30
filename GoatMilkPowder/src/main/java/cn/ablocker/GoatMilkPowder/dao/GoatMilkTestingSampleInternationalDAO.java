package cn.ablocker.GoatMilkPowder.dao;

import cn.ablocker.GoatMilkPowder.entity.GoatMilkTestingSampleInternational;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GoatMilkTestingSampleInternationalDAO extends JpaRepository<GoatMilkTestingSampleInternational, Long>
{
}
