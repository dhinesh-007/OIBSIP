package com.trainreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancellationManager {
    private Connection connection;

    public CancellationManager() {
        connection = DatabaseConnector.connect();
        if (connection == null) {
            System.err.println("Failed to connect to the database.");
        }
    }

    public void cancelReservation(String pnr) {
        String query = "UPDATE reservations SET cancelled = true WHERE reservation_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pnr);
            preparedStatement.executeUpdate();
            System.out.println("Reservation with PNR " + pnr + " is cancelled.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
