package javaproject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

// ==========================================
// 1. PASSENGER MODULE
// ==========================================
class Passenger {
    private int passengerId; 
    private String passengerName; 
    private int age; 
    private String gender; 
    private long mobileNumber; 
    private String email; 

    public Passenger(int passengerId, String passengerName, int age, String gender, long mobileNumber, String email) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public int getPassengerId() { return passengerId; }
    public String getPassengerName() { return passengerName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public long getMobileNumber() { return mobileNumber; }
    public String getEmail() { return email; }

    public void registerPassenger() { 
        System.out.println("Passenger registered successfully: " + passengerName + " (ID: " + passengerId + ")");
    }

    public void updatePassenger(String name, int age, String gender, long mobileNumber, String email) { 
        this.passengerName = name;
        this.age = age;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.email = email;
        System.out.println("Passenger details updated successfully for ID: " + passengerId);
    }

    public void displayPassenger() { 
        System.out.println("ID: " + passengerId + " | Name: " + passengerName + " | Age: " + age +
                " | Gender: " + gender + " | Mobile: " + mobileNumber + " | Email: " + email);
    }

    public void deletePassenger() { 
        System.out.println("Passenger ID " + passengerId + " record removed.");
    }
}

// ==========================================
// 2. TRAIN MODULE
// ==========================================
class Train {
    private int trainNumber;
    private String trainName; 
    private String sourceStation; 
    private String destinationStation; 
    private int totalSeats; 

    public Train(int trainNumber, String trainName, String sourceStation, String destinationStation, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.totalSeats = totalSeats;
    }

    public int getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getSourceStation() { return sourceStation; }
    public String getDestinationStation() { return destinationStation; }
    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int seats) { this.totalSeats = seats; }

    public void addTrain() { 
        System.out.println("Train " + trainName + " (" + trainNumber + ") added successfully.");
    }

    public void updateTrain(String trainName, String source, String dest, int totalSeats) { 
        this.trainName = trainName;
        this.sourceStation = source;
        this.destinationStation = dest;
        this.totalSeats = totalSeats;
        System.out.println("Train " + trainNumber + " details updated successfully.");
    }

    public void displayTrain() { 
        System.out.println("Train No: " + trainNumber + " | Name: " + trainName +
                " | Route: " + sourceStation + " -> " + destinationStation + " | Available Seats: " + totalSeats);
    }

    public boolean checkSeatAvailability() { 
        return totalSeats > 0;
    }
}

// ==========================================
// 3. RESERVATION MODULE
// ==========================================
class Reservation {
    private int reservationId; 
    private int passengerId; 
    private int trainNumber; 
    private String journeyDate; 
    private String reservationStatus; 

    public Reservation(int reservationId, int passengerId, int trainNumber, String journeyDate, String reservationStatus) {
        this.reservationId = reservationId;
        this.passengerId = passengerId;
        this.trainNumber = trainNumber;
        this.journeyDate = journeyDate;
        this.reservationStatus = reservationStatus;
    }

    public int getReservationId() { return reservationId; }
    public int getPassengerId() { return passengerId; }
    public int getTrainNumber() { return trainNumber; }
    public String getJourneyDate() { return journeyDate; }
    public String getReservationStatus() { return reservationStatus; }
    public void setReservationStatus(String status) { this.reservationStatus = status; }

    public void reserveTicket() { 
        System.out.println("Reservation Created successfully! ID: " + reservationId);
    }

    public void cancelReservation() { 
        this.reservationStatus = "Cancelled";
        System.out.println("Reservation ID " + reservationId + " has been cancelled.");
    }

    public void updateReservationStatus(String status) { 
        this.reservationStatus = status;
        System.out.println("Status updated to: " + status);
    }

    public void displayReservation() { 
        System.out.println("Res ID: " + reservationId + " | Passenger ID: " + passengerId +
                " | Train No: " + trainNumber + " | Date: " + journeyDate + " | Status: " + reservationStatus);
    }
}

// ==========================================
// 4. TICKET MODULE
// ==========================================
class Ticket {
    private int ticketId; 
    private int reservationId; 
    private String coachNumber; 
    private int seatNumber; 
    private double fareAmount; 

    public Ticket(int ticketId, int reservationId, String coachNumber, int seatNumber, double fareAmount) {
        this.ticketId = ticketId;
        this.reservationId = reservationId;
        this.coachNumber = coachNumber;
        this.seatNumber = seatNumber;
        this.fareAmount = fareAmount;
    }

    public int getTicketId() { return ticketId; }
    public int getReservationId() { return reservationId; }
    public String getCoachNumber() { return coachNumber; }
    public int getSeatNumber() { return seatNumber; }
    public double getFareAmount() { return fareAmount; }

    public void generateTicket() { 
        System.out.println("Ticket generated successfully. Ticket ID: " + ticketId);
    }

    public void printTicket() { 
        System.out.println("\n========== PASSENGER TICKET ==========");
        System.out.println("Ticket ID     : " + ticketId);
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Coach Number  : " + coachNumber);
        System.out.println("Seat Number   : " + seatNumber);
        System.out.println("Fare Amount   : ₹" + fareAmount);
        System.out.println("======================================\n");
    }

    public double calculateFare(double baseFare, String coachType) { 
        if (coachType.equalsIgnoreCase("AC")) {
            return baseFare + 300.0;
        } else {
            return baseFare;
        }
    }

    public void displayTicket() { 
        System.out.println("Ticket ID: " + ticketId + " | Res ID: " + reservationId +
                " | Coach: " + coachNumber + " | Seat: " + seatNumber + " | Fare: ₹" + fareAmount);
    }
}

// ==========================================
// 5. JOURNEY MODULE
// ==========================================
class Journey {
    private int journeyId; 
    private int trainNumber; 
    private String departureTime;
    private String arrivalTime; 
    private int platformNumber; 

    public Journey(int journeyId, int trainNumber, String departureTime, String arrivalTime, int platformNumber) {
        this.journeyId = journeyId;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.platformNumber = platformNumber;
    }

    public int getJourneyId() { return journeyId; }
    public int getTrainNumber() { return trainNumber; }

    public void scheduleJourney() { 
        System.out.println("Journey scheduled for Train " + trainNumber);
    }

    public void updateJourneyStatus(String dep, String arr, int platform) {
        this.departureTime = dep;
        this.arrivalTime = arr;
        this.platformNumber = platform;
        System.out.println("Journey status updated for Journey ID: " + journeyId);
    }

    public String estimateArrivalTime() { 
        return arrivalTime;
    }

    public void displayJourney() { 
        System.out.println("Journey ID: " + journeyId + " | Train No: " + trainNumber +
                " | Dep: " + departureTime + " | Arr: " + arrivalTime + " | Platform: " + platformNumber);
    }
}

// ==========================================
// 6. VALIDATESERVICE MODULE
// ==========================================
class ValidateService {
    private int passengerId; 
    private int trainNumber; 
    private long mobileNumber; 
    private double fareAmount;

    public ValidateService(int passengerId, int trainNumber, long mobileNumber, double fareAmount) {
        this.passengerId = passengerId;
        this.trainNumber = trainNumber;
        this.mobileNumber = mobileNumber;
        this.fareAmount = fareAmount;
    }

    public boolean validatePassengerId() { 
        return passengerId > 0;
    }

    public boolean validateTrainNumber() { 
        return trainNumber > 10000 && trainNumber < 99999;
    }

    public boolean validateMobileNumber() { 
        return String.valueOf(mobileNumber).length() == 10;
    }

    public boolean validateFareAmount() { 
        return fareAmount > 0;
    }
}

// ==========================================
// 7. SEARCHSERVICE MODULE
// ==========================================
class SearchService {
    private List<Passenger> passengerList; 
    private List<Train> trainList; 
    private List<Reservation> reservationList; 
    private List<Ticket> ticketList;

    public SearchService(List<Passenger> passengerList, List<Train> trainList,
                         List<Reservation> reservationList, List<Ticket> ticketList) {
        this.passengerList = passengerList;
        this.trainList = trainList;
        this.reservationList = reservationList;
        this.ticketList = ticketList;
    }

    public Passenger searchPassenger(int passengerId) { 
        return passengerList.stream()
                .filter(p -> p.getPassengerId() == passengerId)
                .findFirst()
                .orElse(null);
    }

    public Train searchTrain(int trainNumber) { 
        return trainList.stream()
                .filter(t -> t.getTrainNumber() == trainNumber)
                .findFirst()
                .orElse(null);
    }

    public Reservation searchReservation(int reservationId) { 
        return reservationList.stream()
                .filter(r -> r.getReservationId() == reservationId)
                .findFirst()
                .orElse(null);
    }

    public Ticket searchTicket(int ticketId) { 
        return ticketList.stream()
                .filter(tk -> tk.getTicketId() == ticketId)
                .findFirst()
                .orElse(null);
    }
}

// ==========================================
// 8. REPORT GENERATION SERVICE MODULE
// ==========================================
class ReportGenerationService {
    private Passenger passenger; 
    private Reservation reservation; 
    private Ticket ticket;
    private String reportTitle;

    public ReportGenerationService(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public void generatePassengerReport(List<Passenger> passengers,
            List<Reservation> reservations,
            List<Train> trains) {
System.out.println("\n--- " + reportTitle + ": PASSENGER REPORT ---");
for (Passenger p : passengers) {
p.displayPassenger();

boolean hasBooking = false;
for (Reservation r : reservations) {
if (r.getPassengerId() != p.getPassengerId()) continue;

Train t = trains.stream()
.filter(tr -> tr.getTrainNumber() == r.getTrainNumber())
.findFirst()
.orElse(null);

if (t != null) {
System.out.println("    -> Route: " + t.getSourceStation() + " -> " + t.getDestinationStation()
+ " | Train: " + t.getTrainName() + " (" + t.getTrainNumber() + ")"
+ " | Date: " + r.getJourneyDate()
+ " | Status: " + r.getReservationStatus());
hasBooking = true;
}
}
if (!hasBooking) {
System.out.println("    -> Route: No bookings yet");
}
}
}

    public void generateReservationReport(List<Reservation> reservations) { 
        System.out.println("\n--- " + reportTitle + ": RESERVATION SUMMARY REPORT ---");
        reservations.forEach(Reservation::displayReservation);
    }

    public void generateCancellationReport(List<Reservation> reservations) { 
        System.out.println("\n--- " + reportTitle + ": CANCELLED TICKETS REPORT ---");
        reservations.stream()
                .filter(r -> r.getReservationStatus().equalsIgnoreCase("Cancelled"))
                .forEach(Reservation::displayReservation);
    }

    public void generateRevenueReport(List<Ticket> tickets) { 
        double totalRevenue = tickets.stream()
                .mapToDouble(Ticket::getFareAmount)
                .sum();
        System.out.println("\n--- " + reportTitle + ": REVENUE REPORT ---");
        System.out.println("Total Generated Ticket Revenue: ₹" + totalRevenue);
    }
}

// ==========================================
// 9. ANALYSIS SERVICE MODULE
// ==========================================
class AnalysisService {
    private List<Reservation> reservationList; 
    private List<Train> trainList; 
    private Map<String, Integer> routeMap;

    public AnalysisService(List<Reservation> reservationList, List<Train> trainList) {
        this.reservationList = reservationList;
        this.trainList = trainList;
        this.routeMap = new HashMap<>();
    }

    public double calculateOccupancyRate(int trainNumber, int bookedSeats) { 
        Train train = trainList.stream()
                .filter(t -> t.getTrainNumber() == trainNumber)
                .findFirst()
                .orElse(null);
        if (train == null || train.getTotalSeats() == 0) return 0.0;
        return ((double) bookedSeats / (bookedSeats + train.getTotalSeats())) * 100;
    }

    public Train findMostBookedTrain() {
        Map<Integer, Long> bookingsPerTrain = reservationList.stream()
                .collect(Collectors.groupingBy(Reservation::getTrainNumber, Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> maxEntry = bookingsPerTrain.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (maxEntry.isPresent()) {
            int topTrainNo = maxEntry.get().getKey();
            return trainList.stream()
                    .filter(t -> t.getTrainNumber() == topTrainNo)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public void routeWiseReservationAnalysis() { 
        routeMap.clear();
        for (Reservation res : reservationList) {
            Train train = trainList.stream()
                    .filter(t -> t.getTrainNumber() == res.getTrainNumber())
                    .findFirst()
                    .orElse(null);
            if (train != null) {
                String route = train.getSourceStation() + " to " + train.getDestinationStation();
                routeMap.put(route, routeMap.getOrDefault(route, 0) + 1);
            }
        }
        System.out.println("\n--- ROUTE-WISE RESERVATION STATISTICS ---");
        routeMap.forEach((route, count) -> System.out.println("Route: " + route + " | Total Bookings: " + count));
    }

    public void generateSummary() { //
        System.out.println("\n========== SYSTEM ANALYTICS SUMMARY ==========");
        System.out.println("Total Reservations Processed: " + reservationList.size());
        Train mostBooked = findMostBookedTrain();
        if (mostBooked != null) {
            System.out.println("Most Popular Train: " + mostBooked.getTrainName() + " (" + mostBooked.getTrainNumber() + ")");
        } else {
            System.out.println("Most Popular Train: No active bookings yet.");
        }
        routeWiseReservationAnalysis();
        System.out.println("===============================================\n");
    }
}

// ==========================================
// 10. MAIN MODULE
// ==========================================
public class RailConnectSystem {
    private static Scanner scanner = new Scanner(System.in); 
    private static ArrayList<Passenger> passengerList = new ArrayList<>(); 
    private static ArrayList<Train> trainList = new ArrayList<>(); 
    private static ArrayList<Reservation> reservationList = new ArrayList<>();
    private static ArrayList<Ticket> ticketList = new ArrayList<>();
    private static ArrayList<Journey> journeyList = new ArrayList<>();

    private static int passengerCounter = 101;
    private static int reservationCounter = 501;
    private static int ticketCounter = 901;

    public static void main(String[] args) { 
        seedInitialData();

        System.out.println("====================================================");
        System.out.println("  WELCOME TO RAILCONNECT - RAILWAY RESERVATION PORTAL ");
        System.out.println("====================================================");

        boolean exitFlag = false;
        while (!exitFlag) {
            displayMenu(); 
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                exitFlag = processChoice(choice); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid numerical menu choice.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() { 
        System.out.println("\n---------------- MAIN MENU ----------------");
        System.out.println("1. Register New Passenger");
        System.out.println("2. View All Trains");
        System.out.println("3. Book Railway Ticket");
        System.out.println("4. Cancel Reservation");
        System.out.println("5. Print Ticket Details");
        System.out.println("6. Search Service (Passenger / Train / Ticket)");
        System.out.println("7. View Management Reports");
        System.out.println("8. View Reservation Analytics");
        System.out.println("9. Exit Application");
        System.out.println("-------------------------------------------");
    }

    private static boolean processChoice(int choice) { //[cite: 8]
        SearchService searchService = new SearchService(passengerList, trainList, reservationList, ticketList);

        switch (choice) {
            case 1:
                System.out.print("Enter Passenger Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Gender (Male/Female): ");
                String gender = scanner.nextLine();
                System.out.print("Enter Mobile Number: ");
                long mobile = Long.parseLong(scanner.nextLine());
                System.out.print("Enter Email Address: ");
                String email = scanner.nextLine();

                ValidateService val = new ValidateService(passengerCounter, 12727, mobile, 500.0);
                if (!val.validateMobileNumber()) {
                    System.out.println("Validation Error: Mobile number must be 10 digits!");
                    break;
                }

                Passenger passenger = new Passenger(passengerCounter++, name, age, gender, mobile, email);
                passengerList.add(passenger);
                passenger.registerPassenger(); //[cite: 2]
                break;

            case 2:
                System.out.println("\n--- AVAILABLE TRAINS ---");
                trainList.forEach(Train::displayTrain);
                break;

            case 3:
                System.out.print("Enter Passenger ID: ");
                int pId = Integer.parseInt(scanner.nextLine());
                Passenger p = searchService.searchPassenger(pId);
                if (p == null) {
                    System.out.println("Error: Passenger ID not found! Register first.");
                    break;
                }

                System.out.print("Enter Train Number: ");
                int tNo = Integer.parseInt(scanner.nextLine());
                Train t = searchService.searchTrain(tNo);
                if (t == null) {
                    System.out.println("Error: Train not found!");
                    break;
                }

                if (!t.checkSeatAvailability()) {
                    System.out.println("Seats full for Train " + t.getTrainName());
                    break;
                }

                System.out.print("Enter Journey Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();

                Reservation res = new Reservation(reservationCounter++, pId, tNo, date, "Confirmed"); //[cite: 3]
                reservationList.add(res);
                res.reserveTicket(); //[cite: 3]

                t.setTotalSeats(t.getTotalSeats() - 1);

                double baseFare = 450.0;
                Ticket ticket = new Ticket(ticketCounter++, res.getReservationId(), "B1", 12, baseFare);
                ticketList.add(ticket);
                ticket.generateTicket(); //[cite: 4]
                break;

            case 4:
                System.out.print("Enter Reservation ID to cancel: ");
                int rId = Integer.parseInt(scanner.nextLine());
                Reservation resToCancel = searchService.searchReservation(rId);
                if (resToCancel != null) {
                    resToCancel.cancelReservation(); //[cite: 3]
                    Train bookedTrain = searchService.searchTrain(resToCancel.getTrainNumber());
                    if (bookedTrain != null) {
                        bookedTrain.setTotalSeats(bookedTrain.getTotalSeats() + 1);
                    }
                } else {
                    System.out.println("Error: Reservation ID not found.");
                }
                break;

            case 5:
                System.out.print("Enter Ticket ID: ");
                int tkId = Integer.parseInt(scanner.nextLine());
                Ticket foundTicket = searchService.searchTicket(tkId);
                if (foundTicket != null) {
                    foundTicket.printTicket(); //[cite: 4]
                } else {
                    System.out.println("Error: Ticket not found.");
                }
                break;

            case 6:
                System.out.println("Search Options: 1. Passenger | 2. Train | 3. Ticket");
                System.out.print("Choice: ");
                int sChoice = Integer.parseInt(scanner.nextLine());
                if (sChoice == 1) {
                    System.out.print("Enter Passenger ID: ");
                    Passenger pFound = searchService.searchPassenger(Integer.parseInt(scanner.nextLine()));
                    if (pFound != null) pFound.displayPassenger(); //[cite: 2]
                    else System.out.println("Passenger not found.");
                } else if (sChoice == 2) {
                    System.out.print("Enter Train Number: ");
                    Train tFound = searchService.searchTrain(Integer.parseInt(scanner.nextLine()));
                    if (tFound != null) tFound.displayTrain(); //[cite: 3]
                    else System.out.println("Train not found.");
                } else if (sChoice == 3) {
                    System.out.print("Enter Ticket ID: ");
                    Ticket tkFound = searchService.searchTicket(Integer.parseInt(scanner.nextLine()));
                    if (tkFound != null) tkFound.displayTicket(); //[cite: 4]
                    else System.out.println("Ticket not found.");
                }
                break;

            case 7:
                ReportGenerationService reportService = new ReportGenerationService("MONTHLY AUDIT");
                reportService.generatePassengerReport(passengerList, reservationList, trainList); //[cite: 7]
                reportService.generateReservationReport(reservationList); //[cite: 7]
                reportService.generateCancellationReport(reservationList); //[cite: 7]
                reportService.generateRevenueReport(ticketList); //[cite: 7]
                break;

            case 8:
                AnalysisService analysisService = new AnalysisService(reservationList, trainList);
                analysisService.generateSummary(); //[cite: 8]
                break;

            case 9:
                exit(); //[cite: 8]
                return true;

            default:
                System.out.println("Invalid selection. Please choose options 1 through 9.");
        }
        return false;
    }

    private static void exit() { //[cite: 8]
        System.out.println("\nThank you for using RailConnect Railway Reservation Portal! Exiting safely...");
        scanner.close();
    }

    private static void seedInitialData() {
        trainList.add(new Train(12727, "Godavari Express", "Visakhapatnam", "Hyderabad", 50));
        trainList.add(new Train(12760, "Charminar Express", "Hyderabad", "Chennai", 30));
        trainList.add(new Train(12805, "Janmabhoomi Express", "Visakhapatnam", "Vijayawada", 40));

        journeyList.add(new Journey(1, 12727, "17:20", "06:15", 1)); //[cite: 4, 5]
        journeyList.add(new Journey(2, 12760, "18:00", "08:00", 3)); //[cite: 4, 5]
    }
}