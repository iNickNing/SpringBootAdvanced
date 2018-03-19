package top.imyzt.springboot.app.exception;

import top.imyzt.springboot.app.enums.ResultEnum;

/**
 * 系统自定义异常,用于弥补new Exception("msg");无法传入状态码缺陷
 * AppException.class继承自RuntimeException.class(Spring只会接收RuntimeException.class的异常,不会处理Exception.class的异常)
 */
public class AppException extends RuntimeException{

    /**错误码*/
    private Integer code;

    /**
     * 构造方法
     * @param resultEnum 返回消息
     */
    public AppException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
