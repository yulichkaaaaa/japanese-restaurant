package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Column(name = "user_role_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short userRoleId;

    @Column
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public short getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(short userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }
}
