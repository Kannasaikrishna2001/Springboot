package com.isteer.dcm.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dcm_user")
public class DcmUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_role")
    private Integer user_role;


    @Column(name = "user_email")
    private String user_email;

    @Column(name = "user_status")
    private String user_status;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUser_role() {
        return user_role;
    }

    public void setUser_role(Integer user_role) {
        this.user_role = user_role;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    @Override
    public String toString() {
        return "DcmUsers{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", user_role=" + user_role +
                ", user_email='" + user_email + '\'' +
                ", user_status='" + user_status + '\'' +
                '}';
    }
}




