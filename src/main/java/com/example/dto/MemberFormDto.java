package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
public class MemberFormDto {

    private String name;

    private String email;

    private String password;

    private String address;
}
