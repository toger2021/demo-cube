package demo.cube.controller;

import lombok.Data;

@Data
public class JsonResult<T> {
    public static Integer ERROR_CODE = 1;
    public static Integer SUCCESS_CODE = 20000;

    public static String ERROR_MSG = "请求失败!";
    public static String SUCCESS_MSG = "请求成功!";

    private T data;
    private Integer code;
    private String msg;
    /**
     * 默认正确
     */
    public JsonResult() {
        this.code = JsonResult.SUCCESS_CODE;
        this.msg = JsonResult.SUCCESS_MSG;
    }
    /**
     *  不带data
     */
    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /**
     *  data 不带 msg
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = JsonResult.SUCCESS_CODE;
        this.msg = JsonResult.SUCCESS_MSG;
    }
    /**
     *  data 带 msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = JsonResult.SUCCESS_CODE;
        this.msg = msg;
    }
}
