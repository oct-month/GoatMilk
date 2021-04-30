package cn.ablocker.GoatMilkPowder.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "羊奶粉dna含量")
@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY,getterVisibility= JsonAutoDetect.Visibility.NONE)
public class GoatDNAContent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double Abs260;
    private double Abs280;
    private double Abs260_280;
    private double DNA_content;
}
