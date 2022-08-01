package cn.edu.hbut.jsjxy.shortterm2022.blog.service;

import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.Article;
import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.User;
import cn.edu.hbut.jsjxy.shortterm2022.blog.exception.ResourceNotFoundException;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService {

    List<User> getAllUsers(String orderBy, Sort.Direction direction) throws ResourceNotFoundException;

    List<Article> getArticles(Long userId, String orderBy, Sort.Direction direction) throws ResourceNotFoundException;

    User createUser(User user);

    Article createArticle(Article article) throws ResourceNotFoundException;
}
