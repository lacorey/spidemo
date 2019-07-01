package com.ecua.spi.manager;

import com.ecua.spi.exception.LoadDriverNotFoundException;
import com.ecua.spi.model.DriverInfo;
import com.ecua.spi.service.LoadDriver;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by zxin on 2019-06-28.
 */
public class ParserManager {
    private final static CopyOnWriteArrayList<LoadDriver> registeredParsers = new CopyOnWriteArrayList<LoadDriver>();

    static {
        loadInitialParsers();
        System.out.println("DriverParser initialized");
    }

    private static void loadInitialParsers() {
        ServiceLoader<LoadDriver> loadDrivers = ServiceLoader.load(LoadDriver.class);
        Iterator<LoadDriver> driversIterator = loadDrivers.iterator();
        try{
            while(driversIterator.hasNext()) {
                driversIterator.next();
            }
        } catch(Throwable t) {
            // Do nothing
        }
    }

    public static synchronized void registerParser(LoadDriver driver) {
        registeredParsers.add(driver);
    }

    public static DriverInfo getDriver(byte[] data) {
        for (LoadDriver parserInfo : registeredParsers) {
            try {
                DriverInfo dirver = parserInfo.load(data);
                if (dirver != null) {
                    return dirver;
                }
            } catch (Exception e) {
                //wrong parser, ignored it.
            }
        }
        throw new LoadDriverNotFoundException("10001", "Can not find driver for data:" + new String(data));
    }
}
