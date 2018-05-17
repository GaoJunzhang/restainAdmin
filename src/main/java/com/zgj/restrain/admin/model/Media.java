package com.zgj.restrain.admin.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by user on 2018/5/17.
 */
@Entity
@Getter@Setter
public class Media implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer playCount;//播放次数
    private Integer uid;//播放者
    private Timestamp PlayTime;//播放时间
}
