package cn.ablocker.GoatMilkPowder.dao;

import cn.ablocker.GoatMilkPowder.entity.GoatMilkTestingSampleInternational;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface GoatMilkTestingSampleInternationalDAO extends JpaRepository<GoatMilkTestingSampleInternational, Long>
{
    @Query(value = "select MAX(id) as max_id from \"羊奶粉产品检测_国产进口_样品\"", nativeQuery = true)
    public long get_max_id();
}
