package cn.ablocker.GoatMilkPowder.dao;

import cn.ablocker.GoatMilkPowder.entity.GoatDNAContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface GoatDNAContentDAO extends JpaRepository<GoatDNAContent, Long>
{
    @Query(value = "select MAX(id) as max_id from \"羊奶粉dna含量\"", nativeQuery = true)
    public long get_max_id();
}
