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
	
		
		
		String scenario = args[0];
//		String fileData = args[1];
//		String fileOperations=args[2];
		
		AcademiaS academia=new AcademiaS();
		
	
		
		long inicial=System.currentTimeMillis();
		
		
		BufferedReader bfr=new BufferedReader(new FileReader(new File(scenario)));
		
		String line1=bfr.readLine();
		
		int cont=0;
		while(line1 !=null){
			
			if(cont==0){
				
				String[] txtDividido=line1.split(" ");
				DoctorS doctor=new DoctorS(txtDividido[5]);
				academia.setFounder(doctor);
				
				line1=bfr.readLine();
				
			}
			else{
				
				
				String[] txtDividido=line1.split(" ");
				
				academia.addDoctor(new DoctorS(txtDividido[2]), new DoctorS(txtDividido[5]));
				
				line1=bfr.readLine();
			}
			
			cont++;
		}
		
		bfr.close();
		
		
		long tfinal= System.currentTimeMillis();
		
		System.out.println(tfinal-inicial);
		
		
//		DoctorS doctor=new DoctorS(1,academia);
//		academia.setFounder(doctor);
//		
//		DoctorS doctor2=new DoctorS(2,academia);
//		DoctorS doctor3=new DoctorS(3,academia);
//
//		DoctorS doctor4=new DoctorS(4,academia);
//		DoctorS doctor5=new DoctorS(5,academia);
//		DoctorS doctor6=new DoctorS(6,academia);
//		DoctorS doctor7=new DoctorS(7,academia);
//		DoctorS doctor8=new DoctorS(8,academia);
//		
//		academia.addDoctor(doctor2, doctor);
//		
//		academia.addDoctor(doctor3, doctor2);
//		
//		
//		
//		academia.addDoctor(doctor4, doctor2);
//		academia.addDoctor(doctor6, doctor2);
//		
//		academia.addDoctor(doctor7, doctor3);
//		
//		academia.addDoctor(doctor5, doctor4);
//		
//	
		
		
		
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
