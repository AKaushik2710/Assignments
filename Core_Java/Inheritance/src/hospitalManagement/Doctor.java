package hospitalManagement;

public class Doctor extends HospitalMember{
	Doctor(int id, String name, String dept){
		super(id, name, dept);
	}
	
	void calculateConsultationFee(int patients, double feePerPatient) {
		System.out.println("The total fee generated is "+ patients * feePerPatient);
	}
}
