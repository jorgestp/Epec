package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.CollectionIF;
import es.uned.lsi.eped.DataStructures.List;

public class DoctorC implements DoctorIF {
	
	
	private int id;
	private AcademiaC academia;
	
	private CollectionIF<DoctorIF> students;
	
	
	public DoctorC(int id, AcademiaC academia){
		
		this.id=id;
		this.academia=academia;
		students=new List<DoctorIF>();
	}
	
	public DoctorC(int iDDoctor, AcademiaIF a, List<DoctorIF> supervisors) {
		
	id=iDDoctor;
		
		academia=(AcademiaC) a;
		
		students=supervisors;
	}	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AcademiaC getAcademia() {
		return academia;
	}

	public void setStudents(CollectionIF<DoctorIF> students) {
		
		this.students = students;
	}

	public DoctorC(int iD2) {
		id=iD2;

	}

	


	//por hacer tb
	public CollectionIF<DoctorIF> getSupervisor(){
		
		return null;
	}
	
	
	
	

	@Override
	public CollectionIF<DoctorIF> getAncestors(int generations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIF<DoctorIF> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIF<DoctorIF> getDescendants(int generations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIF<DoctorIF> getSiblings() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DoctorIF> getSupervisors() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAcademia(AcademiaC a) {

		academia=a;
	}

}
