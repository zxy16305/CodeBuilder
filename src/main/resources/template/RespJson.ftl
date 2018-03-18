package ${base.thisPackage}.entity.common;



public class RespJson{
    private Integer code;
    private Object data;
    private String mess;

    public RespJson() {
        this.code = ResultCode.SUCC;
    }

    public RespJson(Object data) {
        this.code = ResultCode.SUCC;
        this.data = data;
    }

    public RespJson(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public RespJson(Integer code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public RespJson(Integer code, Object data, String mess) {
        this.code = code;
        this.data = data;
        this.mess = mess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}