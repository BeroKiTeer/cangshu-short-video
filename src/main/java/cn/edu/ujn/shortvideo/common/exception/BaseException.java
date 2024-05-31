package cn.edu.ujn.shortvideo.common.exception;

/**
 * 业务异常
 */

public class BaseException extends RuntimeException {
    private int code;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
