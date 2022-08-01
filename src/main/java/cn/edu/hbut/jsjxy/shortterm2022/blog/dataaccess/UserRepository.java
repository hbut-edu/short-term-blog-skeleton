package cn.edu.hbut.jsjxy.shortterm2022.blog.dataaccess;

import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO 2，请阅读UserRepository数据仓库类和相关注释

/**
 * 该类用于将User实体对象和数据库中间构建映射，并自动生成一些基本的增删改查算法
 * 可以试着阅读org.springframework.data.jpa.repository.support.SimpleJpaRepository中的官方实现
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
