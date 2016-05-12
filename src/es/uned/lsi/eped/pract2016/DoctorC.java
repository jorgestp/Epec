package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

public class DoctorC implements DoctorIF {
	
	
	private int id;
	private AcademiaC academiac;
	private ListIF<DoctorIF> students;
	
	
	public DoctorC(int id, AcademiaC academiac){
		
		this.id = id;
		this.academiac = academiac;
		students = new List<DoctorIF>();
	}
	
	public DoctorC(int id){
		
		this.id = id;
		students = new List<DoctorIF>();
	}
	
	
	
	
	

	public AcademiaC getAcademiac() {
		return academiac;
	}






	public void setAcademiac(AcademiaC academiac) {
		this.academiac = academiac;
	}













	public void setStudents(ListIF<DoctorIF> students) {
		this.students = students;
	}






	@Override
	public CollectionIF<DoctorIF> getAncestors(int generations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIF<DoctorIF> getStudents() {
		return students;
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

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	

	


}
