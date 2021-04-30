package cn.ablocker.GoatMilkPowder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.ablocker.GoatMilkPowder.entity.CompanySelfInspectionRawGoatMilkSample;

@Component
public interface CompanySelfInspectionRawGoatMilkSampleDAO extends JpaRepository<CompanySelfInspectionRawGoatMilkSample, Long>
{
}
