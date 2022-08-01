package cn.edu.hbut.jsjxy.shortterm2022.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass // 告诉JPA框架该类为超类，无需在数据库中建立表格
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP) // 告诉JPA框架该成员变量是一个时间类型，精确到年月日时分秒
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
