package com.ecua.spi.impl;

import com.ecua.spi.manager.LoadDriverManager;
import com.ecua.spi.model.DriverInfo;
import com.ecua.spi.service.LoadDriver;

/**
 * Created by zxin on 2019-07-01.
 */
public class OracleDriverImpl implements LoadDriver {

    static {
        try
        {
            LoadDriverManager.registerDriver(new OracleDriverImpl());
        }
        catch (Exception e)
        {
            throw new RuntimeException("Can't register driver!");
        }
    }

    public DriverInfo load(String url) throws Exception {
        if(url.indexOf("oracle") == -1){
            return null;
        }
        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setDriverName("it's oracle driver");
        return driverInfo;
    }
}
