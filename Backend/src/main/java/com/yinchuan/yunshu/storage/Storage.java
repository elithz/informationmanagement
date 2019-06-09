package com.yinchuan.yunshu.storage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="storages")
public class Storage {
    /**
     * The id of the storage. Automatically created when the good is created
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The name of a good in the storage.
     */
    @Column(name = "type")
    private String type;

    /**
     * The id of which user that good in storage belongs to.
     */
    @Column(name = "user_id")
    private int userId;

    /**
     * The weight of the good in the storage
     */
    @Column(name = "weight")
    private double weight;

    /**
     * The description of the good in the storage
     */
    private String description;

    /**
     * The origin place where the good is from
     */
    private String origin;

    public Storage() {
    }

    public Storage(String type, int userId, double weight, String origin) {
        this.type = type;
        this.userId = userId;
        this.weight = weight;
        this.origin = origin;
    }

    /**
     * Default setter and getter.
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Edit description of the good.
     * @param description
     */
    public void editDescription(String description){
        this.description=description;
    }
}
