package wjl.test.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wjl.test.mybatis.model.User;
import wjl.test.mybatis.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user) {
        return userService.addUser(user);
    }


    @ResponseBody
    @RequestMapping(value = "/addnew", produces = {"application/json;charset=UTF-8"})
    public int addUserNew(User user) {
        return userService.addUserNew(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        return userService.findAllUser(pageNum, pageSize);
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public int deleteById(Integer id) {
        return userService.deleteById(id);
    }

    @RequestMapping("findByUser")
    @ResponseBody
    public Object findByUser(User user) {
        return userService.findByUser(user);
    }

    @RequestMapping("selectByTrim")
    @ResponseBody
    public Object selectByTrim(User user){
        return userService.selectByTrim(user);
    }

    @RequestMapping("findUserByPhone")
    @ResponseBody
    public Object findUserByPhone(String phone){
        return userService.findUserByPhone(phone);
    }

    @RequestMapping("test")
    @ResponseBody
    public void test(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();
        userService.test();
    }

}
