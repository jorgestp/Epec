package es.uned.lsi.eped.pract2016;



import es.uned.lsi.eped.DataStructures.*;



public class AcademiaC implements AcademiaIF {

	private ListIF<DoctorIF> supervisors;
	
	
	
	
	
	public AcademiaC(DoctorIF founder){
		
		supervisors= new List<DoctorIF>();
		supervisors.insert(founder, supervisors.size()+1);
		
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





	@Override
	public DoctorIF getFounder() {
	
		return null;
	}





	@Override
	public DoctorIF getDoctor(int id) {
		
		return null;
	}





	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}





	@Override
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
	
		DoctorC sup=(DoctorC) encuentraDoctor(supervisor);
		
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
		return false;
	}





	public ListIF<DoctorIF> getSupervisors() {
		return supervisors;
	}







	@Override
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		
		
		
		
		
	}
	
	
	private DoctorIF encuentraDoctor(DoctorIF doctor){
		
		
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
		



