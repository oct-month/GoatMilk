package cn.ablocker.GoatMilkPowder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import cn.ablocker.GoatMilkPowder.entity.CompanySelfInspectionRawGoatMilkSample;

@Component
public interface CompanySelfInspectionRawGoatMilkSampleDAO extends JpaRepository<CompanySelfInspectionRawGoatMilkSample, Long>
{
    @Query(value = "select MAX(id) as max_id from \"公司自检_生羊乳_样品\"", nativeQuery = true)
    public long get_max_id();
}
