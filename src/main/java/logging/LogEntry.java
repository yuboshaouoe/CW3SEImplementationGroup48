package logging;

import java.util.Map;

public class LogEntry {

    private String callerName;
    private Object result;
    private Map<String,Object> additionalInfo;

    LogEntry(String callerName,
             Object result,
             Map<String,Object> additionalInfo){
        this.callerName = callerName;
        this.result = result;
        this.additionalInfo = additionalInfo;
    }

    public Object getResult(){
        return result.toString();
    }

    public String toString(){
        String output = "Caller Name: " + this.callerName + "\nResult: " + this.result;
        return output;
    }
}
