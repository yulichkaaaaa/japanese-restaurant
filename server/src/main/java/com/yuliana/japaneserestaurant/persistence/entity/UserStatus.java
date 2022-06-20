package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_statuses")
public class UserStatus {

    @Column(name = "user_status_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short userStatusId;

    @Column
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<User> users;

    public short getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(short userStatusId) {
        this.userStatusId = userStatusId;
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

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
