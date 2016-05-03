package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

public class AcademiaC implements AcademiaIF {

	private ListIF<DoctorC> lista;
	
	
	
	public AcademiaC(){
		
		lista=new List<DoctorC>();
	}
	
	public AcademiaC(DoctorIF founder){
		
		lista=new List<DoctorC>();
		
		lista.insert((DoctorC) founder, lista.size()+1);
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {

		
		
		
	}

	@Override
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		// TODO Auto-generated method stub

	}

	public void setFounder(DoctorC founder) {

		
	}

}
