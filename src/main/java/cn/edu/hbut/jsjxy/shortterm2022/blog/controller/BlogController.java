package cn.edu.hbut.jsjxy.shortterm2022.blog.controller;

import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.Article;
import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.Message;
import cn.edu.hbut.jsjxy.shortterm2022.blog.entity.User;
import cn.edu.hbut.jsjxy.shortterm2022.blog.exception.ResourceNotFoundException;
import cn.edu.hbut.jsjxy.shortterm2022.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO 4，请阅读BlogController控制器类和相关注解
/**
 * 控制器类，负责与前端通过自定义的Restful风格接口进行沟通，调用链如下：
 * from 前端（HTTP请求）=> BlogController => BlogService（接口类）等... => to 前端（HTTP响应）
 */
@RestController // 将该类转换为一个Restful风格的控制器
public class BlogController {

    @Autowired
    private BlogService service;

    /**
     * 获取所有的用户信息
     * @return 如果正常，返回包含所有用户信息的实体对象列表，否则返回错误信息
     */
    @CrossOrigin // 跨域访问
    @GetMapping("/user") // 接受前端的Get请求
    private ResponseEntity<Object> getAllUsers(){
        try {
            var users = service.getAllUsers("id", Sort.Direction.ASC);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 储存新用户信息
     * @param user 前端提交的Json数据封装而成的用户实体对象
     * @return 如果正常，返回用户实体对象，否则返回错误信息
     */
    @CrossOrigin
    @PostMapping("/user") // 接受前端的Post请求
    private ResponseEntity createUser(@RequestBody User user){

        try {
            var createdUser = service.createUser(user);

            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * 获取特定用户发表的文章信息
     * @param userId 用户ID
     * @return 如果正常，返回该用户所发表的文章列表，否则返回错误信息
     */
    @CrossOrigin
    @GetMapping("/user/{userId}/article")
    private ResponseEntity<Object> getArticles(@PathVariable String userId){

        // TODO 请完成 [查询该用户发表的所有文章] 的代码
        /*
         * 在该函数中，首先需要检查参数userId的合法性，并转换到Long类型
         * 接下来调用service中的相关函数查询和这个用户有关的文章
         * 请参考getAllUsers函数
         */

        return null;
    }

    /**
     *
     * @param userId 用户ID
     * @param article 前端提交的Json数据封装而成的文章实体对象
     * @return 如果正常，返回新文章的实体对象，否则返回错误信息
     */
    @CrossOrigin
    @PostMapping("/user/{userId}/article")
    private ResponseEntity createArticle(@PathVariable String userId, @RequestBody Article article){

        // TODO 请完成 [发表一个新文章] 的代码
        /*
         * 在该函数中，首先需要检查参数userId的合法性，并转换到Long类型
         * 检查参数article的合法性，例如是否为空等
         * 创建文章（Article）对象时必须满足创建一个文章对象所需要的赋值
         * 主要包含三个：1，这个文章是属于哪个用户创建的；2，文章的标题（title）是什么；3，文章的内容（content）是什么
         * 这些属性的合法性也需要检查，比如标题和内容是否为空
         * 最后调用service中的相关函数将这个文章实体对象保存到数据库
         * 还需考虑出现异常的情况
         * 请参考createUser函数
         */

        return null;
    }

}
