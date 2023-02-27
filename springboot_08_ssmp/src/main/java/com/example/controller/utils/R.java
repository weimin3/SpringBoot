package com.example.controller.utils;

import lombok.Data;

//前后端协议，保证传入前端的数据格式一致
@Data
public class R {
    private boolean flag;
    private Object data;

    public R() {
    }

    public R(Boolean flag){
        this.flag = flag;
    }
    public R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
}
