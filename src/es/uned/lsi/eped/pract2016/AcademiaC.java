package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

public class AcademiaC implements AcademiaIF {

	private ListIF<DoctorIF> lista;
	
	
	
	public AcademiaC(){
		
		lista=new List<DoctorIF>();
	}
	
	public AcademiaC(DoctorIF founder){
		
		lista=new List<DoctorIF>();
		
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

		ListIF<DoctorIF> aux= new List<DoctorIF>();

		IteratorIF<DoctorIF> it=lista.iterator();
		while(it.hasNext()){
			DoctorIF doc=it.getNext();
			
			if(doc.equals(supervisor)){
				
				aux= (ListIF<DoctorIF>) supervisor.getStudents();
				
				aux.insert(newDoctor, aux.size()+1);	
				
				((DoctorC) newDoctor).setStudents(aux);
	
			}else{
				
				lista.insert(doc, lista.size()+1);
			}
			
		}
		
		
		
		
	}

	public ListIF<DoctorIF> getLista() {
		return lista;
	}

	public void setLista(ListIF<DoctorIF> lista) {
		this.lista = lista;
	}

	@Override
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		// TODO Auto-generated method stub

	}

	public void setFounder(DoctorC founder) {

		
	}

}
