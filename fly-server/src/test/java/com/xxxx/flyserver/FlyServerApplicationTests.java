package com.xxxx.flyserver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.config.ThreadPoolConfig;
import com.xxxx.flyserver.mapper.AdminMapper;
import com.xxxx.flyserver.pojo.Admin;
import com.xxxx.flyserver.pojo.Operation;
import com.xxxx.flyserver.pojo.Po;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IOperationService;
import com.xxxx.flyserver.util.JwtTokenUtil;
import com.xxxx.flyserver.util.PageHelper;
import com.xxxx.flyserver.util.RedisUtil;
import com.xxxx.flyserver.util.UUIDUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.AntPathMatcher;

import java.util.List;
import java.util.concurrent.ExecutorService;

@SpringBootTest
class FlyServerApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IOperationService operationService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private ThreadPoolConfig threadPoolConfig;

    @Test
    void testPool(){
        ExecutorService executorService = threadPoolConfig.buildThreadPool();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()+"你好");
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()+"你好");
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()+"你好");
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()+"你好");
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()+"你好");
        });
    }

    @Test
    void testPageHelper(){
        PageHelper.startPage(1L,10L);


    }


    @Test
    void TestZuoYongYu(){
        Po po = new Po();
        po.setState(0);
        Integer state = po.getState();
        System.out.println("第一次："+state);
        po.setState(state+1);
        System.out.println("第二次"+state);
    }

    @Test
    void TestBC(){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encode = passwordEncoder.encode("123");
//        System.out.println(encode);
        String uuid16 = UUIDUtils.getUUID16();
        System.out.println(uuid16);
    }

    @Test
    public void antpatch(){
//        antPathMatcher.match()方法不能传空参，会报NullPointerException
        boolean aa = antPathMatcher.match(null, "aa");
        System.out.println(aa);
    }

    @Test
    public void redisUtilstest(){
//        Admin admin = adminMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, "admin"));
//        redisUtil.set("1", JSON.toJSONString(admin));
        JSONObject jsonObject = JSON.parseObject((String) redisUtil.get("1"));
        Admin admin = JSONObject.toJavaObject(jsonObject, Admin.class);
        System.out.println(admin.getUsername());
    }

    @Test
    public void trueandfalse(){

    }

    @Test
    public void JwtUtilsTest(){
//        String token = jwtTokenUtil.generateToken("1");
//        System.out.println("生成token"+token);
        String userid = jwtTokenUtil.getUserIdFormToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiY3JlYXRlZCI6MTY0NTc4NDA4MTcyOSwiZXhwIjoxNjQ2Mzg4ODgxfQ.s_Z9bdQNWfiTCEunsR4dM4C2oOXs4n6wr2tfZpehFaDDcH3y6nr-vVIiQ_MvZK8HcF-dtU91waUz_Q3Te7BcQg");
        System.out.println("获取userid"+userid);

    }

    @Test
    void contextLoads() {
        Admin admin = adminMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername,"admin"));
        System.out.println(admin);

    }

}
