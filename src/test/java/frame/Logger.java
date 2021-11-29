package frame;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static org.apache.logging.log4j.Logger logger;


    public static org.apache.logging.log4j.Logger getLogger() {
        if (logger == null) {
            logger = LogManager.getLogger();
        }
        return logger;
    }
}
