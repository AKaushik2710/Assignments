package hospitalManagement;

public class Main {
	public static void main(String[] args) {
		Doctor d = new Doctor(1001, "Doc", "Cardio");
		Nurse n = new Nurse(1002, "Nurse", "Physio");
		
		d.calculateConsultationFee(12, 500);
		n.calculateDutyHours(40, 8);
	}
}
