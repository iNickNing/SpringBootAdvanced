package top.imyzt.springboot.advanced.utils;

import top.imyzt.springboot.advanced.pojo.Result;

/**
 * Http请求返回消息
 */
public class ResultUtil {

    /**
     * 成功返回
     * @param obj 返回消息
     * @return
     */
    public static Result ok(Object obj){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    /**
     * 成功返回
     * @param msg 消息值
     * @param obj 返回数据
     * @return
     */
    public static Result ok(String msg, Object obj){
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }

    /**
     * 错误返回
     * @param code 错误码
     * @param msg 消息值
     * @return
     */
    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
