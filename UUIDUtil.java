package com.ziytek.taozhu.base.util;

import java.io.Serializable;
import java.util.UUID;

/**
 * 类描述：
 *
 * @author by zhanggl on 2016/10/13.
 */
public class UUIDUtil implements Serializable {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
