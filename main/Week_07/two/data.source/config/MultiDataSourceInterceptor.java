package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author jiangtao@linkedme.cc
 * @since 2019/08/27
 */
@Aspect
@Component
public class MultiDataSourceInterceptor {

    @Pointcut("execution(* mapper.UserMapper.selectById())")
    public void dataSourceFour() {
    }



    @Pointcut("execution(* mapper.UserMapper.addUser())")
    public void dataSourceThree() {
    }



    @Pointcut("execution(* mapper.UserMapper.getUserList())")
    public void dataSourceTwo() {
    }



    @Pointcut("execution(* mapper.UserMapper.delUser())")
    public void dataSourceOne() {
    }



    @Before("dataSourceFour()")
    public void beforeFour(JoinPoint jp) {
        DataSourceTypeConfig.set(MultiDataSourceTypeEnum.Four);
    }

    @After("dataSourceFour()")
    public void afterFour(JoinPoint jp) {
        DataSourceTypeConfig.set(MultiDataSourceTypeEnum.One);
    }

    @Before("dataSourceThree()")
    public void beforeThree(JoinPoint jp) {
        DataSourceTypeConfig.set(MultiDataSourceTypeEnum.Three);
    }

    @After("dataSourceThree()")
    public void afterThree(JoinPoint jp) {
        DataSourceTypeConfig.set(MultiDataSourceTypeEnum.One);
    }

    @Before("dataSourceTwo()")
    public void beforeTwo(JoinPoint jp) {
        DataSourceTypeConfig.set(MultiDataSourceTypeEnum.Two);
    }

    @After("dataSourceTwo()")
    public void afterTwo(JoinPoint jp) {
        DataSourceTypeConfig.set(MultiDataSourceTypeEnum.One);
    }

    @Before("dataSourceOne()")
    public void beforeOne(JoinPoint jp) {
        DataSourceTypeConfig.set(MultiDataSourceTypeEnum.One);
    }

}
