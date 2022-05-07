package com.xxxx.flyserver.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

/**
 * @program: fly
 * @description:实现分页插件
 * @author: cxf
 * @create: 2022-04-14 14:13
 **/
@Slf4j
@Component
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class, Integer.class})})
public class PageHelper implements Interceptor {

    private static final ThreadLocal<Page> localThread = new ThreadLocal<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler stm = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = stm.getBoundSql();

        Page page = getPage();
        if(page != null){
            Field sqlField = BoundSql.class.getDeclaredField("sql");
            sqlField.setAccessible(true);
            sqlField.set(boundSql,page.getPageSQL(boundSql.getSql()));
            clearPage();
        }
        log.info("待执行sql"+ boundSql.getSql().replaceAll("\\n","").replaceAll("\\t",""));

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return target instanceof StatementHandler ? Plugin.wrap(target,this) : target;
    }

    @Override
    public void setProperties(Properties properties) {

    }

    public static void startPage(Long pageNum,Long pageSize){
        localThread.set(new Page(pageNum,pageSize));
    }

    private Page getPage(){
        return localThread.get();
    }

    private void clearPage(){
        localThread.remove();
    }

    private static class Page{
        private Long pageNum;
        private Long pageSize;

        public Page(Long pageNum, Long pageSize) {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
        }

        private String getPageSQL(String sql){
            if(pageNum!=null&&pageSize!=null){
                return sql + " limit " + (pageNum-1)*pageSize +","+ pageNum*pageSize;
            }
            return sql;
        }
    }
}
