package logging;

import java.util.Collections;
import java.util.Map;
import java.util.List;

public class Logger{

    private static List<Logger> allLog = null;
    private static List<LogEntry> fullLog = null;

    private Logger(){}

    public static Logger getInstance(){
        Logger log;
        if(allLog.isEmpty()){       //ONLY CREATE LOGGER IF ONE DOESN'T EXIST, OTHERWISE RETRIEVE EXISTING
            log = new Logger();
            allLog.add(log);
        }
        else{
            log = allLog.get(0);
        }
        return log;
    }

    public void logAction(String callerName,
                          Object result){
        LogEntry newEntry = new LogEntry(callerName, result, Collections.emptyMap());
        this.fullLog.add(newEntry);
    }

    public void logAction(String callerName,
                          Object result,
                          Map<String,Object> additionalInfo){
        LogEntry newEntry = new LogEntry(callerName, result, additionalInfo);
        this.fullLog.add(newEntry);
    }

    public List<LogEntry> getLog(){
        return this.fullLog;
    }

    public void clearLog(){
        this.fullLog.clear();
    }

}