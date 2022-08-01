package cn.edu.hbut.jsjxy.shortterm2022.blog.service;

import cn.edu.hbut.jsjxy.shortterm2022.blog.dataaccess.ArticleRepository;
import cn.edu.hbut.jsjxy.shortterm2022.blog.dataaccess.UserRepository;
import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.Article;
import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.User;
import cn.edu.hbut.jsjxy.shortterm2022.blog.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

//TODO 3，请阅读BlogService（接口）与BlogServiceImpl（实现）业务逻辑类和相关注释
/**
 * 业务逻辑类
* 在业务逻辑层采用了面向接口的设计方式，调用链如下：
* BlogController => BlogService（接口类） => BlogServiceImpl（实现类，由SpringBoot的IoC容器自动查找并注入）
* */

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取所有用户信息
     * @param orderBy 排序列
     * @param direction 排序的方向
     * @return 包含所有用户对象的列表
     * @throws ResourceNotFoundException 自定义异常，在没有任何资源被找到的时候丢出
     */
    @Override
    public List<User> getAllUsers(String orderBy, Sort.Direction direction) throws ResourceNotFoundException {

        List<User> users = userRepository.findAll(Sort.by(direction, orderBy));

        if(users.size() == 0){
            throw new ResourceNotFoundException(User.class);
        }

        return users;
    }

    /**
     * 获取特定用户所发表的所有文章信息
     * @param userId 用户ID
     * @param orderBy 排序列
     * @param direction 排序的方向
     * @return 该用户发表的所有文章列表
     * @throws ResourceNotFoundException 自定义异常，在没有任何资源被找到的时候丢出
     */
    @Override
    public List<Article> getArticles(Long userId, String orderBy, Sort.Direction direction)
            throws ResourceNotFoundException {

        // TODO 请完成 [从数据库中获取特定用户发表的文章实体对象列表] 的代码
        /*
        * 首先使用userRepository.existedById检测用户的存在性
        * 然后设定一个检索用的Example，在里面放入User对象，作为检索条件
        * 可以参考：https://www.baeldung.com/spring-data-query-by-example
        * 检索的返回值还需对其进行检测，如果列表为空代表没有任何数据，需要作为异常进行处理
        * 请参考getAllUsers函数
        * */

        return null;

    }

    @Override
    @Transactional // 该注解表示在这个函数的处理范围内应用事务管理
    public User createUser(User user){

        user.setCreatedDate(new Date());

        return userRepository.save(user);

    }

    @Override
    @Transactional
    public Article createArticle(Article article) throws ResourceNotFoundException {

        // TODO 请完成 [储存文章实体对象到数据库] 的代码
        /*
         * service层中，可以采取一些与数据库（JPA）沟通的方法对数据进行进一步的检测
         * 例如，在controller层中我们仅检测了用户ID的合法性，却没有检测这个用户否则真实存在
         * 首先使用userRepository.existedById检测用户的存在性
         * 在文章实体对象中还有一个createdDate成员变量用于纪录对象创建的时间点，需要对其赋值
         * 最后需要考虑到各种异常处理的情况
         * 可以参考createUser函数
         */
        return null;

    }
}
