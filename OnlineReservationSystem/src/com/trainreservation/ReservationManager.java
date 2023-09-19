package com.trainreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationManager {
    private Connection connection;

    public ReservationManager() {
        connection = DatabaseConnector.connect();
        if (connection == null) {
            System.err.println("Failed to connect to the database.");
        }
    }

    public void makeReservation(String username, String trainNumber, String classType, String dateOfJourney, String fromLocation, String toLocation) {
        String query = "INSERT INTO reservations (username, train_number, class_type, date_of_journey, from_location, to_location) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, trainNumber);
            preparedStatement.setString(3, classType);
            preparedStatement.setString(4, dateOfJourney);
            preparedStatement.setString(5, fromLocation);
            preparedStatement.setString(6, toLocation);
            preparedStatement.executeUpdate();
            System.out.println("Reservation successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
