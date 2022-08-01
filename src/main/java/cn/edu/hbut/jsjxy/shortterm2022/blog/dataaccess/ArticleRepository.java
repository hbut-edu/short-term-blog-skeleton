package cn.edu.hbut.jsjxy.shortterm2022.blog.dataaccess;

import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
