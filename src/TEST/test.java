package TEST;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import es.uned.lsi.eped.DataStructures.*;
import es.uned.lsi.eped.pract2016.*;

public class test {

	public static void main(String[] args) throws IOException {
	
		
		

		
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
		

		
	
		DoctorIF doc= academia.getDoctor(doctor5.getId());
		
		System.out.println(" el doctor buscado es el " + ((DoctorS) doc).getId());
		
		
		
		
		
		
		
		
		////*********PRUEBA DEL MEOTOD GETSUPERVISOR******////////////////
		
	//	System.out.println( "El supervisor del doctor " +  doctor5.getId() + " es:" + doctor5.getSupervisor());


		
		
//		//PRUEBA DEL METODO GETSTUDENTS
//		System.out.println();
//		
//		ListIF<DoctorIF> list=(ListIF<DoctorIF>) doctor.getStudents();
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
//		
		
		
//		// PRUEBA DEL METODO GETDESCENDANTS
//		
//		SetIF<DoctorIF> set=(SetIF<DoctorIF>) doctor2.getDescendants(3);
//		
//		IteratorIF<DoctorIF> it=set.iterator();
//		
//		while(it.hasNext()){
//			
//			DoctorIF aux=it.getNext();
//			
//			System.out.print(aux.toString());
//		}
		
		
	//*************************GETANTECESORS
		
//		
//		ListIF<DoctorIF> list=(ListIF<DoctorIF>) doctor7.getAncestors(2);
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
	
//		///////GETSIBLING/////
//		
//		ListIF<DoctorIF> list=(ListIF<DoctorIF>) doctor4.getSiblings();
//		
//		IteratorIF<DoctorIF> iterator=list.iterator();
//		
//		while(iterator.hasNext()){
//			
//			DoctorS doc=(DoctorS) iterator.getNext();
//			
//			System.out.print(doc.getId());
//		}
		
		
	
	}

}
