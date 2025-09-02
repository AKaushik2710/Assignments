package hospitalManagement;

public class Nurse extends HospitalMember{
	Nurse(int id, String name, String dept){
		super(id, name, dept);
	}
	
	void calculateDutyHours(int shifts, int hoursPerShift) {
		System.out.println("Total duty hours are "+shifts*hoursPerShift);
	}
}
