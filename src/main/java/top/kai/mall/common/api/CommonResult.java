package top.kai.mall.common.api;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description 通用返回对象
 * @Author Kai
 * @Date 2020/12/26 21:44
 */
@Getter
@Setter
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {

    }

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果，只传data
     * @param data 获取的数据
     * @param <T> 类型
     * @return success CommonResult
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果，传data和message
     * @param data 获取的数据
     * @param message 提示信息
     * @param <T> 类型
     * @return success CommonResult
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    //-------------------------------------------------------------------------------------------------

    /**
     * 失败返回结果，只传errorCode
     * @param errorCode 错误码
     * @param <T> 类型
     * @return failed CommonResult
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }


    /**
     * 失败返回结果，只传message
     * @param message 提示信息
     * @param <T> 类型
     * @return failed CommonResult
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果，不传参
     * @param <T> 类型
     * @return failed CommonResult
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    //-------------------------------------------------------------------------------------------------

    /**
     * 参数验证失败返回结果，不传参
     * @param <T> 类型
     * @return validateFailed CommonResult
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果，只传message
     * @param message 提示信息
     * @param <T> 类型
     * @return validateFailed CommonResult
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    //-------------------------------------------------------------------------------------------------

    /**
     * 未登录返回结果，只传data
     * @param data 获取的数据
     * @param <T> 类型
     * @return unauthorized CommonResult
     */
    public static <T> CommonResult<T> unauthorized(T data) { // TODO: 401为什么要传data?
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果，只传data
     * @param data 获取的数据
     * @param <T> 类型
     * @return forbidden CommonResult
     */
    public static <T> CommonResult<T> forbidden(T data) { // TODO: 403为什么要传data?
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

}
