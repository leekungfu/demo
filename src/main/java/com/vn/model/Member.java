package com.vn.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String description;
    private Boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "contentByMember", cascade = CascadeType.ALL)
    private List<Content> contentList = new ArrayList<>();
}
