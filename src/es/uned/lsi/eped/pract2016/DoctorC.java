package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.CollectionIF;
import es.uned.lsi.eped.DataStructures.List;

public class DoctorC implements DoctorIF {
	
	
	private int id;
	private AcademiaC academia;
	
	private CollectionIF<DoctorC> students;

	public DoctorC(int iD2) {
		id=iD2;

	}

	public DoctorC(int iDDoctor, AcademiaIF a, List<DoctorIF> supervisors) {
		// TODO Auto-generated constructor stub
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
