package wellnessDiet.testAppointment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.fssa.wellnessDiet.service.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Appoinment;
import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.service.AppointmentService;

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
