package com.vn.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String description;
}
