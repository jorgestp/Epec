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
//
//		DoctorS doctor4=new DoctorS(4,academia);
//		DoctorS doctor5=new DoctorS(5,academia);
//		DoctorS doctor6=new DoctorS(6,academia);
//		DoctorS doctor7=new DoctorS(7,academia);
//		DoctorS doctor8=new DoctorS(8,academia);
//		
		academia.addDoctor(doctor2, doctor);
		
		academia.addDoctor(doctor3, doctor2);
////		
////		
////		
//		academia.addDoctor(doctor4, doctor2);
//		academia.addDoctor(doctor6, doctor2);
//		
//		academia.addDoctor(doctor7, doctor3);
//		
//		academia.addDoctor(doctor5, doctor4);
		//System.out.println(doctor.getSupervisor());
		
		
		TreeIF<DoctorIF> arbol=academia.GetTree();
		ListIF<TreeIF<DoctorIF>> lista=arbol.getChildren();
		
		IteratorIF<TreeIF<DoctorIF>> it=lista.iterator();
		
		while(it.hasNext()){
			
			TreeIF<DoctorIF> sigu=it.getNext();
			
			System.out.println(sigu.getRoot());
		}
		

	}

}
