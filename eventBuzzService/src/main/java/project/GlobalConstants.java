package project;

public class GlobalConstants{
    
public enum EventCategory {
    Seminar, Conference, Workshop, Reunion, Party;
}

public enum EventType {
    Open, Closed;
}

public enum TicketType {
    Regular, VIP;
}

public enum OrganizedType {
    Private, Corporate;
}

public enum HeadCount {
     Limited, Unlimited;
}
public enum Status {
     Approved, Pending;
}

public enum Currency {
    EUR, USD;
}
    
public static final String SALT = "rosogolla";

    
}