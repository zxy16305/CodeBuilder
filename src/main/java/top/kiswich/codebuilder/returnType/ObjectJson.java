package top.kiswich.codebuilder.returnType;

/**
 * 后台数据封装
 */
public class ObjectJson {
    private Object data;
    private String mess;
    private Integer code;

    public ObjectJson() {
        code = ResulrCode.SUCC;
    }

    public ObjectJson(Object data) {
        code = ResulrCode.SUCC;
        this.data = data;
    }

    public ObjectJson(String mess) {
        code = ResulrCode.SUCC;
        this.mess = mess;
    }

    public ObjectJson( Integer resultCode,String mess) {
        this.mess = mess;
        this.code = resultCode;
    }

    public ObjectJson( Integer resultCode,Object data, String mess) {
        this.data = data;
        this.mess = mess;
        this.code = resultCode;
    }

    public ObjectJson( Integer resultCode,Object data) {
        this.data = data;
        this.code = resultCode;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
