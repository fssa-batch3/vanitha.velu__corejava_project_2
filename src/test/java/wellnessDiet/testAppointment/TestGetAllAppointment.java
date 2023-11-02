package wellnessDiet.testAppointment;
import com.fssa.wellnessdiet.*;
import com.fssa.wellnessdiet.dao.AppoinmentDAO;
import com.fssa.wellnessdiet.dao.exception.DAOException;
import com.fssa.wellnessdiet.model.Appoinment;
import com.fssa.wellnessdiet.service.AppointmentService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;


public class TestGetAllAppointment {

	@Test

	void ValidGetAllAppointment() {  

		AppoinmentDAO appointmentDAO = new AppoinmentDAO();
		@SuppressWarnings("unused")
		AppointmentService Appointment = new AppointmentService();  

		try {
//			LocalDate localDate = LocalDate.of(2023, 9, 21);
//			Date sqlDate = Date.valueOf(localDate); 
			List<Appoinment> list = appointmentDAO.getAllAppointment();
			assertNotNull(list);

		} catch (DAOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
