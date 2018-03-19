package top.imyzt.springboot.app.enums;

/**
 * 返回结果枚举类
 */
public enum ResultEnum {

    UNKNOWN_ERROR(-1, "未知异常"),
    SUCCESS(200, "成功"),
    PRIMARY_SCHOOL(401, "小学"),
    MIDDLE_SCHOOL(402, "初中"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
