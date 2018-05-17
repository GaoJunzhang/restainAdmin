package com.zgj.restrain.admin.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 2018/5/17.
 */
@Entity
@Getter@Setter
public class SysOrg {
    @Id@GeneratedValue
    private Integer id;
    @Column(name="name", nullable=false, length=100)
    private String name;
    private Timestamp createTime;
    private Boolean available = Boolean.FALSE;
    private String remark;
    private String code;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pid")
    private SysOrg parent;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="parent")
    private Set<SysOrg> children = new HashSet<SysOrg>(0);
}
