package pl.zmudzinski.guice;

import java.util.logging.*;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 15:20:55
 */
public class GuiceDebug {
    /*private static final Handler HANDLER = new ConsoleHandler() {{
        setLevel(Level.ALL);
        setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return String.format("[Debug Guice] %s%n" + logRecord.getMessage());
            }
        });
    }};*/

    private GuiceDebug() {
    }

    public static void enable() {
        Logger guiceLogger = Logger.getLogger("com.google.inject");
        guiceLogger.setLevel(Level.ALL);
//        guiceLogger.addHandler(HANDLER);
//        guiceLogger.setLevel(Level.ALL);
    }
}
