public class AirTrip {
    private String destination;
    private String flightNumber;
    private String departureTime;
    private String status;
    private String delay;

    public AirTrip(String destination, String flightNumber, String departureTime) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.status = "OnTime";
        this.delay = null;
    }
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }
    public String getStatus() {
        if (status.equals("OnTime")) {
            return "پرواز سروقت انجام می شود";
        } else if (status.equals("Delayed")) {
            return "پرواز با تاخیر " + delay + " انجام می شود";
        } else if (status.equals("Boarding")) {
            return "در حال مسافرگیری";
        } else {
            return "وضعیت پرواز نامشخص";
        }
    }

    public void setStatus(String newStatus, String newDelay)
       {
        if (!newStatus.equals("OnTime") && !newStatus.equals("Delayed") && !newStatus.equals("Boarding")) {
            throw new IllegalArgumentException("وضعیت پرواز نامعتبر");
        }

        this.status = newStatus;
        this.delay = newDelay;
    }
}
