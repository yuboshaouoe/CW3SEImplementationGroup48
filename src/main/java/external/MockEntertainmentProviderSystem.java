package external;

public class MockEntertainmentProviderSystem implements EntertainmentProviderSystem{

    public MockEntertainmentProviderSystem(String orgName,
                                            String orgAddress){}

    public void recordNewEvent(long eventNumber,
                                String title,
                                int numTickets){}

    public void cancelEvent(long eventNumber,
                             String message){}

    public void recordNewPerformance(long eventNumber,
                                      long performanceNumber,
                                      LocalDateTime startDateTime,
                                      LocalDateTime endDateTime){}

    public int getNumTicketsLeft(long eventNumber,
                                  long performanceNumber){}

    public void recordNewBooking(long eventNumber,
                                  long performanceNumber,
                                  long bookingNumber,
                                  String consumerName,
                                  String consumerEmail,
                                  int bookedTickets){}

    public void cancelBooking(long bookingNumber){}

    public void recordSponsorshipAcceptance(long eventNumber,
                                             int sponsoredPricePercent){}

    public void recordSponsorshipRejection(long eventNumber){}

}
