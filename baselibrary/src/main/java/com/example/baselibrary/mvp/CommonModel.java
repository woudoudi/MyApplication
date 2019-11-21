package com.example.baselibrary.mvp;

import com.example.baselibrary.entity.RequestEnum;
import com.example.baselibrary.entity.Result;

public class CommonModel extends BaseModel{

    public CommonModel(RequestEnum requestEnum, Object... object) {
        super(requestEnum, object);
    }

    @Override
    public Result request() {
        // TODO: 2019/6/10 进行网络请求和耗时操作
        return new Result();
    }
}
