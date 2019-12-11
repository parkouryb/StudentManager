package com.jcg.hibernate.maven;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "admin_id")
    private int admin_id;

    @Column(name = "admin_name")
    private String admin_name;

    @Column(name = "created_date")
    private Date created_date;

    public Admin(int admin_id, String admin_name, Date created_date) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.created_date = created_date;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
