package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

public class DoctorS implements DoctorIF {

	
	private int id;
	private AcademiaS academia;
	
	
	public  DoctorS(int id, AcademiaS academia) {
		
		this.id=id;
		this.academia=academia;
		
	}
	
	public int getId() {
		return id;
	}

	public AcademiaS getAcademia(){
		
		return academia;
	}

	public DoctorS getSupervisor(){
		
		AcademiaS acad = academia;
		TreeIF<DoctorIF> c=acad.GetTree();
	
		return (DoctorS) c.getRoot();
	

	
	}
	
	@Override
	public CollectionIF<DoctorIF> getAncestors(int generations) {
		
		CollectionIF<DoctorIF> colec=new List<>();
		
		
		
		TreeIF<DoctorS> arbol=new Tree<DoctorS>();
		
		
		
		return colec;
	}
	
	
	private ListIF<DoctorIF> GeneracionAntecesores (TreeIF<DoctorS> arbol, int num, ListIF<DoctorIF> colec){
		
		
		
			if(arbol.getRoot().equals(academia.getFounder()) && num>0){
				
				colec.insert(arbol.getRoot(), num);
				
				
			}
	
			
			
			
		
	
		
		
		return null;
		
	}

	@Override
	public CollectionIF<DoctorIF> getStudents() {
		ListIF<DoctorIF> lista = null;
		
		AcademiaS academia = null;
		TreeIF<DoctorIF> arbol=academia.GetTree();
		
		
		return lista ;
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

	public String toString()	{
		
		return " " + id;
	}
	

		
		
	
}
