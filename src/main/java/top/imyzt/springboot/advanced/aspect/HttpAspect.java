package top.imyzt.springboot.advanced.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * AOP处理网络请求
 * @Component注解:让Spring识别此类为一个公共组件
 */
@Aspect
@Component
public class HttpAspect {

    //log4j
    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * ..表示@top.imyzt.springboot.advanced.controller.UserController.list()方法的任何参数都会处理
     * @Pointcut表示定义一个规则
     */
    @Pointcut("execution(public * top.imyzt.springboot.advanced.controller.UserController.*(..))")
    public void log(){}

    /**
     * 方法执行之前执行
     */
    @Before("log()")
    public void before(JoinPoint joinpoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取到request
        HttpServletRequest req = attributes.getRequest();

        //url
        log.info("url={}",req.getRequestURI());

        //method
        log.info("method={}",req.getMethod());

        //ip
        log.info("ip={}",req.getRemoteAddr());

        /**
         * 类方法
         * getDeclaringType()获取类名
         * getName()获取类方法
         */
        log.info("class_method={}",joinpoint.getSignature().getDeclaringType() + "."
                + joinpoint.getSignature().getName());

        //参数
        log.info("args={}",joinpoint.getArgs());
    }

    /**
     * 方法执行之后打印
     */
    @After("log()")
    public void doAfter(){
        log.info("after");
    }

    /**
     * 打印出方法的返回值对象
     * @param obj 返回值对象
     */
    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj){
        log.info("response={}", obj);
    }
}
