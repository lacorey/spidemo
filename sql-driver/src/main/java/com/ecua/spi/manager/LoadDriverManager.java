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
public class LoadDriverManager {
    private final static CopyOnWriteArrayList<LoadDriver> registeredDrivers = new CopyOnWriteArrayList<LoadDriver>();

    static {
        loadDrivers();
        System.out.println("DriverManager initialized");
    }

    private static void loadDrivers() {
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

    public static synchronized void registerDriver(LoadDriver driver) {
        registeredDrivers.add(driver);
    }

    public static DriverInfo getDriver(String url) {
        for (LoadDriver driver : registeredDrivers) {
            try {
                DriverInfo dirver = driver.load(url);
                if (dirver != null) {
                    return dirver;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new LoadDriverNotFoundException("10001", "Can not find driver for url:" + url);
    }
}
