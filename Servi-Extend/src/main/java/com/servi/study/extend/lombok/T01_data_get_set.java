package com.servi.study.extend.lombok;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author servi
 * @date 2020/7/1
 */
@Data
@Slf4j
public class T01_data_get_set {
    private String a;

    public static void main(String[] args) {
        T01_data_get_set t = new T01_data_get_set();
        t.setA("1");
        log.info(t.toString());
    }
}
