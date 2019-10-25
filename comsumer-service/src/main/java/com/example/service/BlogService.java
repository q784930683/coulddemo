package com.example.service;

import com.example.bean.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 访问Blog的feign客户端服务
 */
@FeignClient(name = "producer-service",fallback = BlogServiceFallBack.class)
public interface BlogService {

    @RequestMapping("/blog/{title}")
    Blog findByTitle( @PathVariable String title);

    @RequestMapping("/blog/findList")
    List<Blog> findList();


}
