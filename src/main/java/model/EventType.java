package model;

public enum EventType {
    DANCE,
    MOVIE,
    MUSIC,
    SPORTS,
    THEATRE
}

/*public static EventType[] values(){
        EventType[] types = {DANCE, MOVIE, MUSIC, SPORTS, THEATRE};
        return types;
    }

    public static EventType valueOf(String name) {
        return switch (name) {
            case "DANCE" -> DANCE;
            case "MOVIE" -> MOVIE;
            case "MUSIC" -> MUSIC;
            case "SPORTS" -> SPORTS;
            case "THEATRE" -> THEATRE;
            default -> null;
        };
    }

     */