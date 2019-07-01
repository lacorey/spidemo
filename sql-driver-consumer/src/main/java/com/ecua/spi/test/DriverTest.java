package com.ecua.spi.test;

import com.ecua.spi.manager.ParserManager;
import com.ecua.spi.model.DriverInfo;

/**
 * Created by zxin on 2019-07-01.
 */
public class DriverTest {

    public static void main(String[] args) {
        testMysql();
        testOracle();
    }

    public static void testMysql(){
        DriverInfo driver = ParserManager.getDriver("Mysql".getBytes());
        System.out.println(driver.getDriverName());
    }

    public static void testOracle(){
        DriverInfo driver = ParserManager.getDriver("Oracle".getBytes());
        System.out.println(driver.getDriverName());
    }
}
