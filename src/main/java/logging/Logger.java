package logging;

import java.util.Map;
import java.util.List;

public class Logger{

    public static Logger getInstance(){}

    public void logAction(String callerName,
                           Object result){
        LogEntry newEntry = new LogEntry(callerName, result, Collections.emptyMap());
        this.fullLog.add(newEntry);
    }

    public void logAction(String callerName,
                           Object result,
                           Map<String,Object> additionalInfo){}

    public List<LogEntry> getLog(){}

    public void clearLog(){}

}
