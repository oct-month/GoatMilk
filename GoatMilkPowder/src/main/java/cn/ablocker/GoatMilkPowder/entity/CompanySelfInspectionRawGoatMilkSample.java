package cn.ablocker.GoatMilkPowder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Table(name = "公司自检_生羊乳_样品")
@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY,getterVisibility= JsonAutoDetect.Visibility.NONE)
public class CompanySelfInspectionRawGoatMilkSample
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String 日期;
    private String 奶站;
    private String 感官;
    private String 脂肪;
    private String 蛋白质;
    private String 非脂乳固体;
    private String 冰点;
    private String 酸度;
    private String 抗生素;

    @JsonProperty("β-内酰胺酶")
    private String β_内酰胺酶;

    private String 酒精试验;
    private String 煮沸试验;
    private String DBP;
}
