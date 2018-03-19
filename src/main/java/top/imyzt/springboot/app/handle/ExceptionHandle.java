package top.imyzt.springboot.app.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.imyzt.springboot.app.exception.AppException;
import top.imyzt.springboot.app.pojo.Result;
import top.imyzt.springboot.app.utils.ResultUtil;

/**
 * 统一异常处理
 * @ControllerAdvice增强异常处理控制器
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 统一异常处理方法,执行顺序
     * 抛出异常的方法 -> ExceptionHandle.handle()捕获{Exception.class, AppException.class}抛出的异常,通过ResultUtil.error()将消息以@ResponseBody注解的JSON数据返回
     * @param e 异常对象
     * @return 返回错误对象
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        //判断是否是继承自Exception.class的AppException.class,如果是,则将异常消息码返回给前台
        if (e instanceof AppException){
            AppException appException = (AppException) e;
            return ResultUtil.error(appException.getCode(), appException.getMessage());
        }else {
            logger.debug(e.getMessage());
            return ResultUtil.error(500, e.getMessage());
        }
    }
}
