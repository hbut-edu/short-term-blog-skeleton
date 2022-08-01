package cn.edu.hbut.jsjxy.shortterm2022.blog.service;

import cn.edu.hbut.jsjxy.shortterm2022.blog.dataaccess.UserRepository;
import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

// TODO 完成其他单元测试项目

@SpringBootTest
class BlogServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void getAllUsers() {
    }

    @Test
    void getArticles() {
    }

    @Test
    @Transactional
    @Rollback // 测试完成后回滚数据
    void createUser() {

        String name = "test_user_" + (int)(Math.random()*100000);
        User newUser = new User();
        newUser.setName(name);
        userRepository.save(newUser);

        User createdUser = new User();
        createdUser.setName(name);

        assert userRepository.exists(Example.of(createdUser));
    }

    @Test
    void createArticle() {
    }
}