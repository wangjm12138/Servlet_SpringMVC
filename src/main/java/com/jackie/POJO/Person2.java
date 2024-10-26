package com.jackie.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person2 implements Serializable {
    private String pname;
    private String page;
    private String gender;
    private String[] hobby;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private List<Pet> pets;
    private Map<String,Pet> petMap;
}
