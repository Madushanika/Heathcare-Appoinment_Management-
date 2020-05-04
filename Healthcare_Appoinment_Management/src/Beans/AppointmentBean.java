package Beans;


import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@XmlRootElement

public class AppointmentBean {
	
	private int Shedule_ID;
	private int Doctor_ID;
//	private String Doctor_Name;
//	private String Specialization;
	private int Hospital_ID;
	private double Chargers;
	private String Available_Time;
	private String End_Time;
	private String Sever_Time;
	
	public AppointmentBean() {
    	
    }

	
	 public AppointmentBean(String appo)
	    {

	        JsonObject appointmentObject = new JsonParser().parse(appo).getAsJsonObject();

	        if (appointmentObject.get("Shedule_ID") != null) {
	            this.Shedule_ID = appointmentObject.get("Shedule_ID").getAsInt();
	        }

	        this.Doctor_ID = appointmentObject.get("Doctor_ID").getAsInt();
	        this.Hospital_ID = appointmentObject.get("Hospital_ID").getAsInt();
	        this.Chargers = appointmentObject.get("Chargers").getAsDouble();
	        this.Available_Time = appointmentObject.get("Available_Time").getAsString();
	        this.End_Time = appointmentObject.get("End_Time").getAsString();
	        this.Sever_Time = appointmentObject.get("Sever_Time").getAsString();
	        
	    }
		
	 
	 public AppointmentBean(int shedule_iD,int doctor_iD,int hospital_iD,double chargers,String available_time,
			 String end_time,String sever_time){
	    	
	    	this.Shedule_ID = shedule_iD;
	    	this.Doctor_ID = doctor_iD;
	    	this.Hospital_ID = hospital_iD;
	    	this.Chargers = chargers;
	    	this.Available_Time = available_time;
	    	this.End_Time = end_time;
	    	this.Sever_Time = sever_time;
	    	
	    }
	 
	 
	    public AppointmentBean(int doctor_iD,int hospital_iD,double chargers,String available_time,
	    		String end_time,String sever_time){
	    	
	    	this.Doctor_ID = doctor_iD;
	    	this.Hospital_ID = hospital_iD;
	    	this.Chargers = chargers;
	    	this.Available_Time = available_time;
	    	this.End_Time = end_time;
	    	this.Sever_Time = sever_time;
	    	
	    }
		

	public int getShedule_ID() {
		return Shedule_ID;
	}
	public void setShedule_ID(int shedule_ID) {
		Shedule_ID = shedule_ID;
	}
	public int getDoctor_ID() {
			return Doctor_ID;
	}
	public void setDoctor_ID(int doctor_ID) {
		Doctor_ID = doctor_ID;
	}
//	public String getDoctor_Name() {
//			return Doctor_Name;
//	}
//	public void setDoctor_Name(String doctor_Name) {
//		Doctor_Name = doctor_Name;
//		}
//	public String getSpecialization() {
//		return Specialization;
//	}
//	public void setSpecialization(String specialization) {
////		Specialization = specialization;
//	}
	public int getHospital_ID() {
		return Hospital_ID;
	}
	public void setHospital_ID(int hospital_ID) {
		Hospital_ID = hospital_ID;
	}
	public double getChargers() {
		return Chargers;
	}
	public void setChargers(double chargers) {
		Chargers = chargers;
	}
	public String getAvailable_Time() {
		return Available_Time;
	}
	public void setAvailable_Time(String available_Time) {
		Available_Time = available_Time;
	}
	public String getEnd_Time() {
		return End_Time;
	}
	public void setEnd_Time(String end_Time) {
		End_Time = end_Time;
	}
	public String getSever_Time() {
		return Sever_Time;
	}
	public void setSever_Time(String sever_Time) {
		Sever_Time = sever_Time;
	}
	

}
