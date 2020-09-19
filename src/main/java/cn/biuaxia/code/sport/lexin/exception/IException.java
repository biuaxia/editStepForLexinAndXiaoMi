package cn.biuaxia.code.sport.lexin.exception;

/**
 * 自定义异常基类
 *
 * @author biuaxia
 * @date 2020-09-19 19:42:32
 */
public abstract class IException extends RuntimeException {

    private Integer code;

    public IException() {
    }

    public IException(String message) {
        super(message);
    }

    public IException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
