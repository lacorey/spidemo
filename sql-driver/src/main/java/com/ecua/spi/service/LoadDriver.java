package com.ecua.spi.service;

import com.ecua.spi.model.DriverInfo;

/**
 * Created by zxin on 2019-06-28.
 */
public interface LoadDriver {

    public DriverInfo load(byte[] data) throws Exception;

}
