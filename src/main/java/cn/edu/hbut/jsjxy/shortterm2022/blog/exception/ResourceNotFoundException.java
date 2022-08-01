package cn.edu.hbut.jsjxy.shortterm2022.blog.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(Class clazz){

        super(clazz.getSimpleName() + " resource is not existed.");
    }

}
