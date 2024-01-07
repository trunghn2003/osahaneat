package com.cybersoft.osahaneat.payload;
/*

{
status : 200
desc: ""
data: {}


}


 */
public class ResponseData {

    private int status = 200;
    private String desc;
    private  Object data;
    private boolean isSucess = true;

    public boolean isSucess() {
        return isSucess;
    }

    public void setSucess(boolean sucess) {
        isSucess = sucess;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
