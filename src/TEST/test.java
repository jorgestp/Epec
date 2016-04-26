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

		DoctorS doctor4=new DoctorS(4,academia);
		DoctorS doctor5=new DoctorS(5,academia);
		DoctorS doctor6=new DoctorS(6,academia);
		DoctorS doctor7=new DoctorS(7,academia);
		DoctorS doctor8=new DoctorS(8,academia);
		
		academia.addDoctor(doctor2, doctor);
		
		academia.addDoctor(doctor3, doctor2);
		
		
		
		academia.addDoctor(doctor4, doctor2);
		academia.addDoctor(doctor6, doctor2);
		
		academia.addDoctor(doctor7, doctor3);
		
		academia.addDoctor(doctor5, doctor4);
		
		
		
		SetIF<DoctorIF> set=(SetIF<DoctorIF>) doctor2.getDescendants(3);
		IteratorIF<DoctorIF> iterator2=set.iterator();
		
		while(iterator2.hasNext()){
			
			DoctorS doc= (DoctorS) iterator2.getNext();
			
			System.out.print(doc.getId()+ ", ");
			
		}
		
		System.out.println();
		
	}
		
		
		
		
		
	//	System.out.println(doctor7.getSupervisor());
		
//		
//		System.out.println( "El supervisor del doctor " +  doctor7.getId() + " es:" + doctor7.getSupervisor());
//		
//		TreeIF<DoctorIF> arbol=academia.GetTree();
//		ListIF<TreeIF<DoctorIF>> lista=arbol.getChildren();
//		
//		IteratorIF<TreeIF<DoctorIF>> it=lista.iterator();
//		
//		while(it.hasNext()){
//			
//			TreeIF<DoctorIF> sigu=it.getNext();
//			
//			System.out.print(sigu.getRoot()+ ",");
//			
//		}
//		
//		System.out.println();
//		
//		academia.addSupervision(doctor7, doctor2);
//		
//		
//		TreeIF<DoctorIF> arbol1=academia.GetTree();
//		ListIF<TreeIF<DoctorIF>> lista1=arbol.getChildren();
//		
//		IteratorIF<TreeIF<DoctorIF>> it1=lista.iterator();
//		
//		while(it1.hasNext()){
//			
//			TreeIF<DoctorIF> sigu=it1.getNext();
//			
//			System.out.print(sigu.getRoot()+ ",");
//			
//		}
		
//		
//		//PRUEBA DEL METODO GETSTUDENTS
//		System.out.println();
//		
//		ListIF<DoctorIF> list=(ListIF<DoctorIF>) doctor2.getStudents();
//		
//		IteratorIF<DoctorIF> iterator=list.iterator();
//		
//		while(iterator.hasNext()){
//			
//			DoctorS doc= (DoctorS) iterator.getNext();
//			
//			System.out.print(doc.getId()+ ", ");
//			
//		}
//		
//		System.out.println();
		
		
		
		// PRUEBA DEL METODO GETDESCENDANTS
		

	
	
	

}
