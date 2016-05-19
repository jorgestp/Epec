package es.uned.lsi.eped.pract2016;

import org.w3c.dom.stylesheets.LinkStyle;

import es.uned.lsi.eped.DataStructures.*;

public class DoctorC implements DoctorIF {
	
	
	private int id;
	private AcademiaC academiac;
	private CollectionIF<DoctorIF> students;
	
	
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






	



	//FUNCIONA
	public CollectionIF<DoctorIF> getStudents() {
		return students;
	}
	
	
	@Override
	public CollectionIF<DoctorIF> getAncestors(int generations) {
		
		return null;
	}

	
	
	
	

	
	public CollectionIF<DoctorIF> getDescendants(int generations) {

		ListIF<DoctorIF> listaAretornar = new List<DoctorIF>();
		
		if(generations==0){
			return listaAretornar;
		}
		if(generations==1){
			return this.students;
		}
		
		IteratorIF<DoctorIF> it=students.iterator();
		while(it.hasNext()){
			DoctorIF aux=it.getNext();
			ListIF<DoctorIF> list2 = (ListIF<DoctorIF>) getDescendants(generations-1);
			
				IteratorIF<DoctorIF> it2=list2.iterator();
				
					while(it.hasNext()){
						
						DoctorIF aux2=it.getNext();
						
						if(!listaAretornar.contains(aux2)){
							
							listaAretornar.insert(aux2, listaAretornar.size()+1);
						}
					}
		}
		
		return listaAretornar;
		
		
	}

	
	//Funciona
	public CollectionIF<DoctorIF> getSiblings() {
		
		ListIF<DoctorIF> list = new List<DoctorIF>();
		
		list= (ListIF<DoctorIF>) beSiblings(this, academiac.getSupervisors(), 1);
		
		return reverseRepetitions(list);
	}
	
	private CollectionIF<DoctorIF> beSiblings( DoctorIF doctor, ListIF<DoctorIF> supervisors, int index){
		
		ListIF<DoctorIF> list = new List<DoctorIF>();
		
		if(index> supervisors.size()){
			
			return list;
		}else{
			
			DoctorIF doc=supervisors.get(index);
			
			if(beInList(doc.getStudents(), doctor)){
				
				ListIF<DoctorIF> hermanos=(ListIF<DoctorIF>) doc.getStudents();
				
				list=(ListIF<DoctorIF>) beSiblings(doctor, supervisors, index+1);
				
				list=includeInlist(list, hermanos, doctor);
				
				return list;
				
			}else{
				
				list=(ListIF<DoctorIF>) beSiblings(doctor, supervisors, index+1);
			}
				

		
		return list;
		
	}
	}



	private ListIF<DoctorIF> includeInlist(ListIF<DoctorIF> list, ListIF<DoctorIF> hermanos, DoctorIF doctor) {
		
		IteratorIF<DoctorIF> it=hermanos.iterator();
		
		while(it.hasNext()){
			
			DoctorIF doc=it.getNext();
			
			if(!doc.equals(doctor)){
				
				list.insert(doc, list.size()+1);
			}
		}
		
		return list;
	}

	private boolean beInList(CollectionIF<DoctorIF> students, DoctorIF doctor) {
	IteratorIF<DoctorIF> it=students.iterator();
		
		while(it.hasNext()){
			
			DoctorIF aux=it.getNext();
			
			if(aux.getId()==doctor.getId()){
				
				return true;
			}
		}

	
		return false;
	}
	
	private CollectionIF<DoctorIF> reverseRepetitions(ListIF<DoctorIF> hermanos){
		
		ListIF<DoctorIF> list = new List<DoctorIF>();
		
		list.insert(hermanos.get(1), list.size()+1);
		
		IteratorIF<DoctorIF> itHermanos=hermanos.iterator();
		
		while(itHermanos.hasNext()){
			
			DoctorIF aux=itHermanos.getNext();
			
			if(!beInList(list, aux)){
				
				list.insert(aux, list.size()+1);
			}
		}
		
		
		return list ;
		
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	//metodo para que no de error en la linea 60 de ParseCScenarario
	public CollectionIF<DoctorIF> getSupervisors(){
		
		ListIF<DoctorIF> list=new List<DoctorIF>();
		
		IteratorIF<DoctorIF> it=academiac.getSupervisors().iterator();
		
		while(it.hasNext()){
			
			DoctorIF doc=it.getNext();
			
			if(beInList(doc.getStudents(), this)){
				
				list.insert(doc, list.size()+1);			
			}
		}
		
		
		
		return list;
	}

	
	void addStudent(DoctorIF newDoctor){
		
		((List<DoctorIF>) students).insert(newDoctor, students.size()+1);
	}



}
