package cn.ablocker.GoatMilkPowder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;

@Table(name = "用户")
@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY,getterVisibility= JsonAutoDetect.Visibility.NONE)
public class User {
    @Id
    String username;    // 用户名
    String password;    // 密码
    String role;        // 身份
}
