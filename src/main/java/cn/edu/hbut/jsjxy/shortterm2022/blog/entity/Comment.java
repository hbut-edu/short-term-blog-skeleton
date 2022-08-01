package cn.edu.hbut.jsjxy.shortterm2022.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Comment extends BaseEntity {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String Content;

}
