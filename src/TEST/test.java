package TEST;
import es.uned.lsi.eped.DataStructures.*;
import es.uned.lsi.eped.pract2016.*;

public class test {

	public static void main(String[] args) {
	
		
		AcademiaS academia=new AcademiaS();
		DoctorS doctor=new DoctorS(1,academia);
		academia.setFounder(doctor);
	
		DoctorS doctor2=new DoctorS(2,academia);
		DoctorS doctor3=new DoctorS(3,academia);
		
		
		academia.addDoctor(doctor2, doctor);
		
		academia.addDoctor(doctor3, doctor);
		academia.Mostrar(academia);
		

	}

}
