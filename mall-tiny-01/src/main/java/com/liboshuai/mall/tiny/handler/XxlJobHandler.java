package com.liboshuai.mall.tiny.handler;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: liboshuai
 * @Date: 2022-07-12 23:41
 * @Description: xxl-job定时执行器
 */
@Component
@Slf4j
public class XxlJobHandler {

    @XxlJob("domoJobHandler")
    public void domoJobHandler() throws Exception {
        for (int i = 0; i < 10; i++) {
            log.info("XXL-JOB, Hello World.");
        }
    }
}
