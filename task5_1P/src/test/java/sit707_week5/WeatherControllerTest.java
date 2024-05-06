package sit707_week5;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "S224143611";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Akshar";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperaturePersist() {
		
		System.out.println("+++ testTemperaturePersist +++");
		
		// Initialise controller
		WeatherController wController = WeatherController.getInstance();
		
		String now = new SimpleDateFormat("H:m:s").format(Date.from(Instant.now()));
		String persistTime = wController.persistTemperature(10, 19.5);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Compare the expected persist time with the actual persist time
		Assert.assertTrue(persistTime.equals(now));
		
		// Shutdown controller
		wController.close();
	}
}