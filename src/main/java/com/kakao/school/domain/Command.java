package com.kakao.school.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Command {
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dueDate;
    private String name;
    private String password;
}
