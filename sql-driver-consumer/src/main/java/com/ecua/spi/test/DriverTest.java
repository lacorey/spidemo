package com.ecua.spi.test;

import com.ecua.spi.manager.LoadDriverManager;
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
        String url = "jdbc:mysql://localhost:3306/mafengwo?useSSL=false";
        DriverInfo driver = LoadDriverManager.getDriver(url);
        System.out.println(driver.getDriverName());
    }

    public static void testOracle(){
        String url = "jdbc:oracle://localhost:1521/mafengwo?useSSL=false";
        DriverInfo driver = LoadDriverManager.getDriver(url);
        System.out.println(driver.getDriverName());
    }
}
