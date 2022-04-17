package model;

import java.util.List;

public enum EventStatus {
    ACTIVE,
    CANCELLED
}

    /*public static EventStatus[] values(){
        EventStatus[] statuses = {ACTIVE, CANCELLED};
        return statuses;
    }

    public static EventStatus valueOf(String name){
        return switch (name) {
            case "ACTIVE" -> ACTIVE;
            case "CANCELLED" -> CANCELLED;
            default -> null;
        };
    }
     */
