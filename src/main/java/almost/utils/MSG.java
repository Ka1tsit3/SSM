package almost.utils;

import java.util.HashMap;
import java.util.Map;

public class MSG {
    private String msg;
    private int code;
    private Map<String, Object> extend=new HashMap<String,Object>();

    public static MSG success(){
        MSG result = new MSG();
        result.setCode(100);
        result.setMsg("链接成功");
        return result;
    }

    public static MSG fail(){
        MSG result = new MSG();
        result.setCode(200);
        result.setMsg("链接失败");
        return result;
    }

    public MSG add(String s,Object v){
        this.getExtend().put(s,v);
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
