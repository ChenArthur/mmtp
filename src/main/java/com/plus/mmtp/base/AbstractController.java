package com.plus.mmtp.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ch
 * @Desicription: 控制器基类
 * @Date: Created in 10:03 2018/7/12
 * @Modefied By:
 */
public class AbstractController {
    private static Logger logger = LoggerFactory.getLogger(AbstractController.class);

    /**
     * 计算当前页数
     *
     * @param start
     *            偏移量
     * @param length
     *            页大小
     * @return pageNo 当前页数
     */
    public static Integer getPageNo(Integer start, Integer length) {
        Integer pageNo = 1;
        if (++start > 1) {
            pageNo = start / length;
            if (start % length > 0)
                pageNo++;
        }
        return pageNo;
    }
}
