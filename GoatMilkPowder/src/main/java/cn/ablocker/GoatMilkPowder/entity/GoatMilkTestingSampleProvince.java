package cn.ablocker.GoatMilkPowder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Table(name = "羊奶粉产品检测_省内外_样品")
@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY,getterVisibility= JsonAutoDetect.Visibility.NONE)
public class GoatMilkTestingSampleProvince
{
    @Id
    private String id;
    
    private String info;
    private String 区域;
    private String 感官;
    private String 脂肪;
    private String 蛋白质;
    private String 水分;
    private String 抗生素;

    @JsonProperty("β-内酰胺酶")
    private String β_内酰胺酶;

    private String 酸度;
    private String DBP;
}
