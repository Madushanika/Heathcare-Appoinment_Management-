package Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Beans.AppointmentBean;
import Model.Appointment;

@Path("/Schedule")
public class AppointmentService {

	Appointment appointmentObj = new Appointment();

	// Read Doctor List
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readschedule() {
		return appointmentObj.readschedule();
	}
	
	
	
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertSchedule(String appoinmentData) {

        AppointmentBean appob = new AppointmentBean(appoinmentData);

        String output = appointmentObj.insertSchedule(appob);
        return output;

    }
    
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateSchedule(String appoinmentData) {

    	 AppointmentBean appob = new AppointmentBean(appoinmentData);


        String output = appointmentObj.updateSchedule(appob);
        return output;

    }

    @DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteschedule(String appoinmentData) {

  
		JsonObject AppoinmentObject = new JsonParser().parse(appoinmentData).getAsJsonObject();

	    String Shedule_ID = AppoinmentObject.get("Shedule_ID").getAsString();
        String output = appointmentObj.deleteschedule(Shedule_ID);

        return output;

    }


}
