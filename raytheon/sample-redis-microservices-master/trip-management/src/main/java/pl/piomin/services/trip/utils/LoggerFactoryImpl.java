package pl.piomin.services.trip.utils;

import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogConfigurationException;

import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.jcl.LogAdapter;
import org.apache.logging.log4j.spi.LoggerAdapter;
import org.apache.logging.log4j.jcl.LogFactoryImpl;

import java.io.IOException;

public class LoggerFactoryImpl extends LogFactoryImpl {

    private LoggerAdapter<Log> loggerAdapter = new LogAdapter();


    @Override
    public Log getInstance(final Class clazz) throws LogConfigurationException {

        return getInstance(clazz.getName());
    }

    @Override
    public Log getInstance(final String name) throws LogConfigurationException {
        this.initialize();
        return loggerAdapter.getLogger(name);


    }

    @Override
    public void release() {
        try {
            loggerAdapter.close();
        } catch (IOException ioe) {
            System.err.print("unable to cloase adapter");
        }
    }

    /**Initialize custom logger */
    private void initialize() {
        try {
            LoggerFactory.configureExternalLogger("1", "helloworld");
        } catch (LoggingException ex) {
            try {
                LoggerFactory.configureExternalLogger("MYLOGGER", "DEFAULT");

            } catch (LoggingException loge) {

            }
        }
    }


}