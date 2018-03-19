package top.imyzt.springboot.advanced.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.imyzt.springboot.advanced.pojo.Result;
import top.imyzt.springboot.advanced.utils.ResultUtil;

/**
 * 统一异常处理
 * @ControllerAdvice增强异常处理控制器
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 统一异常处理方法,执行顺序
     * 抛出异常的方法 -> ExceptionHandle.handle()捕获异常,通过ResultUtil.error()将消息以@ResponseBody注解的JSON数据返回
     * @param e 异常对象
     * @return 返回错误对象
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        return ResultUtil.error(500, e.getMessage());
    }
}
