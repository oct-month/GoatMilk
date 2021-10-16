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

@Table(name = "羊奶粉产品检测_国产进口_样品")
@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY,getterVisibility= JsonAutoDetect.Visibility.NONE)
public class GoatMilkTestingSampleInternational
{
    @Id
    private long id;

    private String info;
    private String 品种;
    private String 组织状态;
    private String 色泽;
    private String 水分;
    private String 蛋白质;
    private String 脂肪;
    private String 乳糖;
    private String 蔗糖;
    private String 维生素A;
    private String 维生素D;
    private String 维生素E;

    @JsonProperty("维生素K₁")
    private String 维生素K1;
    @JsonProperty("维生素B₁")
    private String 维生素B1;
    @JsonProperty("维生素B₂")
    private String 维生素B2;
    @JsonProperty("维生素B₆")
    private String 维生素B6;
    @JsonProperty("维生素B₁₂")
    private String 维生素B12;
    
    private String 烟酸;
    private String 叶酸;
    private String 泛酸;
    private String 维生素C;
    private String 生物素;
    private String 胆碱;
    private String 铁;
    private String 钙;
    private String 锌;
    private String 磷;
    private String 钠;
    private String 钾;
    private String 镁;
    private String 铜;
    private String 锰;
    private String 硒;
    private String 碘;
    private String 铅;
    private String 铬;
    private String 镉;
    private String 总砷;
    private String 亚油酸;
    
    @JsonProperty("α-亚麻酸")
    private String α_亚麻酸;

    @JsonProperty("亚油酸:α-亚麻酸")
    private String 亚油酸_α_亚麻酸;

    private String DHA;
    private String ARA;
    private String 月桂酸和肉豆蔻酸占总脂肪酸的比例;
    private String 反式脂肪酸与总脂肪酸的比值;
    private String OPO;
    private String 氯;
    private String 酸度;
    private String 碳水化合物;
    private String 灰分;
    private String Asp;
    private String Thr;
    private String Ser;
    private String Glu;
    private String Gly;
    private String Ala;
    private String Val;
    private String Met;
    private String Ile;
    private String Leu;
    private String Tyr;
    private String Phe;
    private String Lys;
    private String His;
    private String Arg;
    private String Pro;
    private String 氨基酸总量;
}
