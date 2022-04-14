package model;

public class ConsumerPreferences {

    public boolean preferSocialDistancing;
    public boolean preferAirFiltration;
    public boolean preferOutdoorsOnly;
    public int preferredMaxCapacity;
    public int preferredMaxVenueSize;

    public ConsumerPreferences(){
        preferSocialDistancing = false;
        preferAirFiltration = false;
        preferOutdoorsOnly = false;
        preferredMaxCapacity = Integer.MAX_VALUE;
        preferredMaxVenueSize = Integer.MAX_VALUE;
    }



}
