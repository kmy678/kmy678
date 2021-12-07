package edu.soft2.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component //装配bean到IOC
public class User {
    private String id;
    private String name;
    private String pwd;
    private String email;
}
