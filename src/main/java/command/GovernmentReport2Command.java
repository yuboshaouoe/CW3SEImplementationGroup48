package command;

import controller.Context;
import model.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Search for all information about the consumers
 * who have active bookings for that entertainment
 * provider’s events that are both active and ticketed
 * using the organisation name of that entertainment
 * provider.
 */
public class GovernmentReport2Command implements ICommand{

    /**
     * Organisation name to be used for the search.
     */
    private String orgName;
    /**
     * list of all consumers with active bookings of active,
     * ticketed events provided by a specific entertainment provider.
     */
    private List<Consumer> result;


    GovernmentReport2Command(String orgName){
        this.orgName = orgName;
        this.result = null;
    }

    /**
     * Using the organisation name to look for all consumers with
     * active bookings of active, ticketed events provided by a
     * specific entertainment provider.
     *
     * @param context The object containing the states of the system's
     *                users, events, and bookings.
     */
    public void execute(Context context){

        // find the entertainment provider from name
        EntertainmentProvider provider = findProviderFromName(context, orgName);

        // get the event numbers of active and ticketed events from the provider
        List<Long> providerEventNumbers = getActiveTicketedEventNumbersFromProvider(provider);

        // find all active consumers from the active event numbers
        result = findActiveConsumersFromEventNumbers(context, providerEventNumbers);
    }

    /**
     * Using the context and organisation name to search for
     * the EntertainmentProvider object that has the provided
     * organisation name.
     *
     * @param context The object containing the states of the system's
     *                users, events, and bookings.
     *
     * @param orgName Organisation name of the entertainment provider.
     *
     * @return EntertainmentProvider object that has the given name.
     */
    private EntertainmentProvider findProviderFromName(Context context, String orgName){
        List<Event> events = context.getEventState().getAllEvents();
        EntertainmentProvider provider = null;
        for (Event e : events) {
            if (e.getOrganiser().getOrgName().equals(orgName)){
                provider = e.getOrganiser();
            }
        }
        return provider;
    }

    /**
     * Using the EntertainmentProvider object to filter and find
     * all ticketed and active events, then get their event numbers.
     *
     * @param provider EntertainmentProvider object to be filtered
     *
     * @return list of event numbers of all active and ticketed events
     * of the provided entertainment provider.
     */
    private List<Long> getActiveTicketedEventNumbersFromProvider(EntertainmentProvider provider){
        List<Event> providerEvents = provider.getEvents().stream()
                .filter(event -> event instanceof TicketedEvent &&
                        event.getStatus().equals(EventStatus.ACTIVE))
                .collect(Collectors.toList());
        return providerEvents.stream().map(Event::getEventNumber).collect(Collectors.toList());
    }

    /**
     * Using the system's context and the event numbers of the
     * active and ticketed events of a specific entertainment
     * provider to filter and find all active bookings and hence
     * all bookers of these bookings.
     *
     * @param context The object containing the states of the system's
     *                users, events, and bookings.
     *
     * @param providerEventNumbers list of event numbers of all active and ticketed events
     *                             of the provided entertainment provider.
     *
     * @return list of all consumers with active bookings of active,
     * ticketed events provided by a specific entertainment provider.
     */
    private List<Consumer> findActiveConsumersFromEventNumbers(Context context,
                                                               List<Long> providerEventNumbers){
        List<Booking> allBookings = null;
        for (Long eventNumber : providerEventNumbers){
            allBookings.addAll(context.getBookingState().findBookingsByEventNumber(eventNumber));
        }
        List<Booking> activeBookings = allBookings.stream()
                .filter(booking -> booking.getStatus().equals(BookingStatus.Active))
                .collect(Collectors.toList());
        List<Consumer> activeConsumers = activeBookings.stream()
                .map(Booking::getBooker)
                .collect(Collectors.toList());
        return activeConsumers;
    }

    /**
     * @return list of all consumers with active bookings of active,
     *         ticketed events provided by a specific entertainment provider.
     *         Or null if there isn't any.
     */
    public List<Consumer> getResult(){return result;}
}
