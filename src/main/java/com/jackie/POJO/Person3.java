package com.jackie.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person3 implements Serializable {
    private String pname;
    private String age;
    private String gender;
    private String[] hobby;
    private Date birthdate;


}
