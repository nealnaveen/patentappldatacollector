package pl.piomin.services.trip.utils;


public class LoggerFactory {

    private static String APPID;
    private static String appName;
    private static String isntanceID;
    private static String instanceName;



    public static void configureExternalLogger(String Appid, String appName) {

        //initialize here appid and appName
    }

    public static Logger getLogger(String logName) {
        Logger log = new Logger();
        return log;
    }

    //TODO add getters and setters./
}

