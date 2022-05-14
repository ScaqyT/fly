package com.xxxx.flyserver.util;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @program: fly
 * @description: UUID订单号生成器
 * @author: cxf
 * @create: 2022-05-10 20:31
 **/
public class UUIDUtils {
    public static String getUUID16(){
//        Integer uuid=UUID.randomUUID().toString().replaceAll("-","").hashCode();

        return LocalDateTime.now().toString().replaceAll("-|T|:|\\.","");

//        uuid = uuid < 0 ? -uuid : uuid;
//        String uuid16 = uuid.toString();
//        return uuid16;
    }

}
