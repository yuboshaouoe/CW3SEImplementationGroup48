package model;

import java.util.List;

public class EntertainmentProvider extends User{
    public EntertainmentProvider(String orgName,
                                 String orgAddress,
                                 String paymentAccountEmail,
                                 String mainRepName,
                                 String mainRepEmail,
                                 String password,
                                 List<String> otherRepNames,
                                 List<String> otherRepEmails){}

    public void addEvent(Event event){}

    public String getOrgName(){}

    public void setOrgName(String orgName){}

    public String getOrgAddress(){}

    public void setOrgAddress(String orgAddress){}

    public List<Event> getEvents(){}

    public void setMainRepName(String mainRepName){}

    public void setMainRepEmail(String mainRepEmail){}

    public void setOtherRepNames(List<String> otherRepNames){}

    public void setOtherRepEmails(List<String> otherRepEmails){}

    public EntertainmentProviderSystem getProviderSystem(){}

    public String toString(){}
}
