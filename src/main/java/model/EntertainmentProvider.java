package model;

import java.util.List;
import external.EntertainmentProviderSystem;
import external.MockEntertainmentProviderSystem;

public class EntertainmentProvider extends User{

    private String orgName;
    private String orgAddress;
    private String mainRepName;
    private List<String> otherRepNames;
    private List<String> otherRepEmails;

    private EntertainmentProviderSystem providerSystem;
    private List<Event> events;

    public EntertainmentProvider(String orgName,
                                 String orgAddress,
                                 String paymentAccountEmail,
                                 String mainRepName,
                                 String mainRepEmail,
                                 String password,
                                 List<String> otherRepNames,
                                 List<String> otherRepEmails){

        super(mainRepEmail, password, paymentAccountEmail);
        this.orgName = orgName;
        this.orgAddress = orgAddress;
        this.mainRepName = mainRepName;
        this.otherRepNames = otherRepNames;
        this.otherRepEmails = otherRepEmails;
        this.providerSystem = new MockEntertainmentProviderSystem(orgName, orgAddress);
    }

    public void addEvent(Event event){events.add(event);}

    public String getOrgName(){return this.orgName;}

    public void setOrgName(String orgName){this.orgName = orgName;}

    public String getOrgAddress(){return this.orgAddress;}

    public void setOrgAddress(String orgAddress){this.orgAddress = orgAddress;}

    public List<Event> getEvents(){return this.events;}

    public void setMainRepName(String mainRepName){this.mainRepName = mainRepName;}

    public void setMainRepEmail(String mainRepEmail){this.setEmail(mainRepEmail);}

    public void setOtherRepNames(List<String> otherRepNames){this.otherRepNames = otherRepNames;}

    public void setOtherRepEmails(List<String> otherRepEmails){this.otherRepEmails = otherRepEmails;}

    public EntertainmentProviderSystem getProviderSystem(){return providerSystem;}

    public String toString(){
        return "Org Name: " + this.orgName + "\nOrg Email: " + this.orgAddress + "\nOrg Main Rep: " + this.getEmail();
    }
}
