package cn.edu.hbut.jsjxy.shortterm2022.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Article extends BaseEntity {


    @ManyToOne
    @JsonBackReference
    private User user;

    private String title;

    @Column(columnDefinition = "MEDIUMTEXT") // 对于文章需要用较大的数据类型MEDIUMTEXT来储存
    private String content;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

}
