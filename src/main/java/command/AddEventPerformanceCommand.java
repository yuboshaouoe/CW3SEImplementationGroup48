package command;


import controller.Context;
import model.EntertainmentProvider;
import model.Event;
import model.EventPerformance;
import model.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AddEventPerformanceCommand implements ICommand{

    private long eventNumber;
    private String venueAddress;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<String> performerNames;
    private boolean hasSocialDistancing;
    private boolean hasAirFiltration;
    private boolean isOutdoors;
    private int capacityLimit;
    private int venueSize;

    private EventPerformance result = null;

    public AddEventPerformanceCommand(long eventNumber,
                                      String venueAddress,
                                      LocalDateTime startDateTime,
                                      LocalDateTime endDateTime,
                                      List<String> performerNames,
                                      boolean hasSocialDistancing,
                                      boolean hasAirFiltration,
                                      boolean isOutdoors,
                                      int capacityLimit,
                                      int venueSize){

        this.eventNumber = eventNumber;
        this.venueAddress = venueAddress;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.performerNames = performerNames;
        this.hasSocialDistancing = hasSocialDistancing;
        this.hasAirFiltration = hasAirFiltration;
        this.isOutdoors = isOutdoors;
        this.capacityLimit = capacityLimit;
        this.venueSize = venueSize;

    }

    public void execute(Context context){


        if(startDateTime.isBefore(endDateTime) && capacityLimit >= 1 && venueSize >= 1){

            User currUser = context.getUserState().getCurrentUser();
            Event event = context.getEventState().findEventByNumber(eventNumber);

            if(currUser instanceof EntertainmentProvider && event != null){ //also checking event exists
                String currEmail = currUser.getEmail();
                String organiserEmail = event.getOrganiser().getEmail();

                if(organiserEmail.equals(currEmail)){
                    List<Event> allEvents = context.getEventState().getAllEvents();
                    List<Event> titleSharingEvents = null;

                    for (Event e : allEvents) {
                        if (e.getTitle().equals(event.getTitle())){
                            titleSharingEvents.add(e);
                        }
                    }

                    List<EventPerformance> performances = null;
                    for (Event other : titleSharingEvents){
                         performances.addAll(other.getPerformances());
                    }

                    List<LocalDateTime> startTimes = performances.stream().map(EventPerformance::getStartDateTime)
                            .collect(Collectors.toList());
                    List<LocalDateTime> endTimes = performances.stream().map(EventPerformance::getEndDateTime)
                            .collect(Collectors.toList());

                    boolean NoRepeatedStartTime = startTimes.stream().allMatch(new HashSet<>()::add);
                    boolean NoRepeatedEndTime = endTimes.stream().allMatch(new HashSet<>()::add);
                    if (NoRepeatedEndTime && NoRepeatedStartTime){
                        EventPerformance newPerf = context.getEventState().createEventPerformance(
                                event,
                                venueAddress,
                                startDateTime,
                                endDateTime,
                                performerNames,
                                hasSocialDistancing,
                                hasAirFiltration,
                                isOutdoors,
                                capacityLimit,
                                venueSize);
                        result = newPerf;
                    }
                }
            }
        }
    }

    public EventPerformance getResult(){
        return result;
    }
}
