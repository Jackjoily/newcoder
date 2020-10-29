package com.jack.newcoder.controller;

import com.jack.newcoder.entity.DiscussPost;
import com.jack.newcoder.entity.Page;
import com.jack.newcoder.entity.User;
import com.jack.newcoder.service.DiscussPostService;
import com.jack.newcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jackjoily
 * @date 2020/10/29 9:58
 */
@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        //方法调用前，SpringMvc会自动实例化Model对象和Page对象，并将Page对象注入Model
        //所有在thymeleaf中可以直接访问Page对象中的数据
        page.setRows(discussPostService.selectDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost discussPost : list) {
                Map<String, Object> map = new HashMap<>();
                User userById = userService.findUserById(discussPost.getUserId());
                map.put("post", discussPost);
                map.put("user", userById);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

}
