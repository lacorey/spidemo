package com.ecua.spi.impl;

import com.ecua.spi.manager.ParserManager;
import com.ecua.spi.model.DriverInfo;
import com.ecua.spi.service.LoadDriver;

/**
 * Created by zxin on 2019-07-01.
 */
public class MySqlDriverImpl implements LoadDriver {

    static
    {
        try
        {
            ParserManager.registerParser(new com.ecua.spi.impl.MySqlDriverImpl());
        }
        catch (Exception e)
        {
            throw new RuntimeException("Can't register parser!");
        }
    }

    public DriverInfo load(byte[] data) throws Exception {
        String str = new String(data);
        if(!str.equals("Mysql")){
            return null;
        }
        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setDriverName("it's mysql driver");
        return driverInfo;
    }
}
