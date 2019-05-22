package com.test.model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicInsert
@Table(name = "user_t")
public class User implements Serializable {
    @Id
//    @GenericGenerator(name = "uuid", strategy = "com.skytech.platform.core.identifier.generator.COMBGenerator")
//    @GeneratedValue(generator = "uuid")
    @Column(name = "ID")
    private String id;

    @Column(name="PASSWORD")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return this.id+"--"+this.password;
    }
}
