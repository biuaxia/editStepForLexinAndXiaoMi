package cn.biuaxia.code.sport.engine.exception;

/**
 * 业务异常
 *
 * @author biuaxia
 * @date 2020-09-19 20:00:45
 */
public class BusinessException extends IException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(code, message);
    }

    @Override
    public Integer getCode() {
        Integer code = super.getCode();
        if (code == null) {
            code = 500;
        }
        return code;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "系统错误";
        }
        return message;
    }

}
