package es.uned.lsi.eped.pract2016;



import es.uned.lsi.eped.DataStructures.*;



public class AcademiaC implements AcademiaIF {

	private ListIF<DoctorIF> supervisors;
	private int size;
	
	
	
	
	
	public AcademiaC(DoctorIF founder){
		
		supervisors= new List<DoctorIF>();
		supervisors.insert(founder, supervisors.size()+1);
		size=1;
		
	}


	
	



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public boolean contains(DoctorIF e) {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public IteratorIF<DoctorIF> iterator() {
		// TODO Auto-generated method stub
		return null;
	}





	//FUNCIONA
	public DoctorIF getFounder() {
	
		DoctorIF doc= supervisors.get(1);
		
		return doc;
	}





	//FUNCIONA
	public DoctorIF getDoctor(int id) {
		
	IteratorIF<DoctorIF> it = supervisors.iterator();
		
		while(it.hasNext()){
			
			DoctorIF aux=it.getNext();
			
			if(aux.getId()==id){
				
				
				return aux;
				
			}
			
			
		}
		
		return null;
	}
	
		
		
		
		
	





	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}





	//FUNCIONA!
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
	
		DoctorC sup=(DoctorC) findDoctor(supervisor);
		
		ListIF<DoctorIF> listStudents=(ListIF<DoctorIF>) sup.getStudents();
		
		listStudents.insert(newDoctor, listStudents.size()+1);
		
		
		sup.setStudents(listStudents);
		
		if(!beInSupervisors(newDoctor)){
			
			
			supervisors.insert(newDoctor, supervisors.size()+1);
			
		}
		
		
		
		
		
	}
	
	private boolean beInSupervisors(DoctorIF newDoctor){
		
		IteratorIF<DoctorIF> it=supervisors.iterator();
		
		while(it.hasNext()){
			
			DoctorIF aux=it.getNext();
			if(aux.getId()==newDoctor.getId()){
				
				return true;
			}
		}
		size++;
		return false;
	}



	//FUNCIONA PERO NO SE SI ES LO QUE SE PIDE O NO.
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		
//		DoctorC stu=(DoctorC) findDoctor(student);
		DoctorC sup=(DoctorC) findDoctor(supervisor);
		
		sup.addStudent(student);
			
			
		
		
		
	}
	
	
	private DoctorIF findDoctor(DoctorIF doctor){
		
		
		boolean bandera=false;
		IteratorIF<DoctorIF> it = supervisors.iterator();
		
		while(it.hasNext() && !bandera){
			
			DoctorIF aux=it.getNext();
			
			if(aux.equals(doctor)){
				
				bandera=true;
				return aux;
				
			}
			
			
		}
		
		return null;
	}







	public ListIF<DoctorIF> getSupervisors() {
		return supervisors;
	}


}




	
//	private DoctorIF encuentraDoctor(DoctorIF doctor, int id){
//		
//		if(doctor.equals(new DoctorC(id))){
//			
//			return doctor;
//		}else{
//			
//			CollectionIF<DoctorIF> students=doctor.getStudents();
//			
//			if(students == null || students.isEmpty()){
//				
//				return null;
//			}else{
//				
//				IteratorIF<DoctorIF> it=students.iterator();
//				
//				while(it.hasNext()){
//					
//					DoctorIF doc=encuentraDoctor(it.getNext(), id);
//					return doc;
//				}
//			}
//			return null;
//		}
//		
//		
//
//
//	}









	





//	private DoctorC getDoctor(DoctorIF newDoctor) {
//		
//		
//		return (DoctorC) encuentraDoctor(founder, newDoctor.getId());
//	}


//	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
//		
//		
//
//		IteratorIF<DoctorIF> it=supervisors.iterator();
//		
//		boolean bandera=false;
//		while(it.hasNext() && !bandera){
//			DoctorC doc=(DoctorC) it.getNext();
//			
//			if(doc.getId() == supervisor.getId()){
//				
//			
//
//				((DoctorC) supervisor).addStudent(newDoctor);
//				
//				bandera=true;
//			
//			}
//			
//		}
//		
//	}
		



