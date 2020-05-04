package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Beans.AppointmentBean;

import DbConnect.DBConnection;

public class Appointment {

	// insert------------------------------------------
	
	public String insertSchedule(AppointmentBean appo) {
		String output = "";
		try
		{
			Connection con = DBConnection.connect();
			
				if (con == null)
				{    
					return "Error while connecting to the database for inserting.";
				}
				
				// create a prepared statement
				String query = "insert into schedule"
						+"(`Shedule_ID`, `Doctor_ID`,`Hospital_ID`, `Chargers`, `Available_Time`, `End_Time`, `Sever_Time`)"
						 + " values (?,?,?,?,?,?,?)";
						PreparedStatement preparedStmt = con.prepareStatement(query); 
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setInt(2, appo.getDoctor_ID());
				preparedStmt.setInt(3, appo.getHospital_ID());
				preparedStmt.setDouble(4, appo.getChargers());
				preparedStmt.setString(5, appo.getAvailable_Time());
				preparedStmt.setString(6, appo.getEnd_Time());
				preparedStmt.setString(7, appo.getSever_Time()); 
	
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			}
				catch (Exception e)
			{
					output = "Error while inserting the item.";
					System.err.println(e.getMessage());
			}
			return output;
    		}

	//View-------------------------------------
	
	public String readschedule() {
		
		String output = "";
		try{
			Connection con = DBConnection.connect();
		
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			output = "<table border=\"1\">"
					+ "<tr>"
					+ "<th>Shedule ID</th>" 
					+ "<th>Doctor ID</th>"
					+ "<th>Hospital ID</th>"
					+ "<th>Available Time</th>"
					+ "<th>End Time</th>"
					+ "<th>Chargers</th>"
					+ "<th>Sever Time</th>"
					+ "</tr>";

			String query = "select * from schedule";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String Shedule_ID = Integer.toString(rs.getInt("Shedule_ID"));
				String Doctor_ID = Integer.toString(rs.getInt("Doctor_ID"));
				String Hospital_ID = Integer.toString(rs.getInt("Hospital_ID"));
				String Chargers = Double.toString(rs.getDouble("Chargers"));
				String Available_Time = rs.getString("Available_Time");
				String End_Time = rs.getString("End_Time");
				String Sever_Time = rs.getString("Sever_Time");
				
				
				// Add into the html table
				output += "<tr><td>" + Shedule_ID + "</td>";
				output += "<td>" + Doctor_ID + "</td>";
				output += "<td>" + Hospital_ID + "</td>";
				output += "<td>" + Available_Time + "</td>";
				output += "<td>" + End_Time + "</td>";
				output += "<td>" + Chargers + "</td>";
				output += "<td>" + Sever_Time + "</td>";
				
				
			}

			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Schedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//Update--------------------------------------------
	
	public String updateSchedule(AppointmentBean appo) {
		
		String output = "";
		try {
			
			Connection con = DBConnection.connect();
			
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE `schedule` SET `Doctor_ID`=?,`Hospital_ID`=?,`Chargers`=?,`Available_Time`=?,`End_Time`=?,`Sever_Time`=? WHERE `Shedule_ID`=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setInt(1, appo.getDoctor_ID());
			preparedStmt.setInt(2, appo.getHospital_ID());
			preparedStmt.setDouble(3, appo.getChargers());
			preparedStmt.setString(4, appo.getAvailable_Time());
			preparedStmt.setString(5, appo.getEnd_Time());
			preparedStmt.setString(6, appo.getSever_Time());
			preparedStmt.setInt(7, appo.getShedule_ID());
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Schedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	//Delete ----------------------------------------------------
	
	public String deleteschedule(String schedule_ID) {

		String output = "";
		try {
			
			Connection con = DBConnection.connect();
			
			if (con == null) {

				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from schedule where Shedule_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(schedule_ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the Schedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
