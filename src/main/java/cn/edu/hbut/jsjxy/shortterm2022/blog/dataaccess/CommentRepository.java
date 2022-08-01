package cn.edu.hbut.jsjxy.shortterm2022.blog.dataaccess;

import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
