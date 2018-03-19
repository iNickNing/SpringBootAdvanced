package top.imyzt.springboot.advanced.pojo;

/**
 * 统一的Http返回消息
 */
public class Result<T> {

    /**消息码*/
    private Integer code;

    /**消息*/
    private String msg;

    /**返回数据*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
