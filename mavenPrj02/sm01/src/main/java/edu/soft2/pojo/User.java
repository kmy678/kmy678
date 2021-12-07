package edu.soft2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data//getter and setter
@NoArgsConstructor//无参构造器
@AllArgsConstructor//有参构造器
public class User {
    String username;
    String pwd;
    int age;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    Date birthday;//springmvc进行转换
//    Address address;//自定义对象类型
}
