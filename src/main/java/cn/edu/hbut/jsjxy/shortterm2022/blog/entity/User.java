package cn.edu.hbut.jsjxy.shortterm2022.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

//TODO 1，请阅读User实体类和相关注释

/**
 * 一位用户可以发表多篇文章，所以Article（文章）和User（用户）的关系为多对一
 */

@Data // 来自lombok，用于自动生成Getter和Setter
@Entity // 实体类标记，纳入JPA管理
@AllArgsConstructor // 生成包含所有成员变量的构造器
@NoArgsConstructor // 生成无参数的构造器
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

    private String name;

    /*
     * 在本系统中，因为文章和用户构成了相互引用
     * 在生成Json字符串的时候，这种相互引用会导致程序无法中止而崩溃
     * 使用@JsonBackReference注解告诉应用程序在哪里中断相互引用
     * */
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Article> articles;

}
