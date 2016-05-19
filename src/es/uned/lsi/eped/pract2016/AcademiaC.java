package es.uned.lsi.eped.pract2016;



import es.uned.lsi.eped.DataStructures.*;



public class AcademiaC implements AcademiaIF {

	private CollectionIF<DoctorIF> supervisors;
	private int size;
	
	
	
	
	
	public AcademiaC(DoctorIF founder){
		
		supervisors= new List<DoctorIF>();
		((List<DoctorIF>) supervisors).insert(founder, supervisors.size()+1);
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
	
		DoctorIF doc= ((List<DoctorIF>) supervisors).get(1);
		
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
	


	//FUNCIONA
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
			
			
			((List<DoctorIF>) supervisors).insert(newDoctor, supervisors.size()+1);
			
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
		

		DoctorC sup=(DoctorC) findDoctor(supervisor);
		
		sup.addStudent(student);
			
			
		
		
		
	}
	
	
	private DoctorIF findDoctor(DoctorIF doctor){
		
		
		boolean bandera=false;
		IteratorIF<DoctorIF> it = supervisors.iterator();
		
		while(it.hasNext() && !bandera){
			
			DoctorIF aux=it.getNext();
			
			if(aux.getId() == doctor.getId()){
				
				bandera=true;
				return aux;
				
			}
			
			
		}
		
		return null;
	}


	public ListIF<DoctorIF> getSupervisors() {
		return (ListIF<DoctorIF>) supervisors;
	}


}




