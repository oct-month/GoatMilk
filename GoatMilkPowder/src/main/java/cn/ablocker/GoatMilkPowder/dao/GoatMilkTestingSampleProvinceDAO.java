package cn.ablocker.GoatMilkPowder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.ablocker.GoatMilkPowder.entity.GoatMilkTestingSampleProvince;

@Component
public interface GoatMilkTestingSampleProvinceDAO extends JpaRepository<GoatMilkTestingSampleProvince, String>
{   
}
