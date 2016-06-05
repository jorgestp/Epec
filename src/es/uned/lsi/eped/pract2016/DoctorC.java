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






	



	
	public CollectionIF<DoctorIF> getStudents() {
		return students;
	}
	
	

	public CollectionIF<DoctorIF> getAncestors(int generations) {
		
		return antece(this, generations, new List<DoctorIF>());
	}
	
	private CollectionIF<DoctorIF> antece(DoctorIF doc, int generation, ListIF<DoctorIF> list){
		
		
		
		if(generation ==1){
			
			ListIF<DoctorIF> list2= (ListIF<DoctorIF>) ((DoctorC) doc).getSupervisors();
			IteratorIF<DoctorIF> it=( (DoctorC) doc).getSupervisors().iterator();
			while(it.hasNext()){
				
				DoctorIF aux=it.getNext();
				list.insert(aux, list.size()+1);
			}
			return list;
		}
		else{
			
		
			ListIF<DoctorIF> sup=academiac.getSupervisors();
			
			IteratorIF<DoctorIF> it=sup.iterator();
			
			while(it.hasNext()){
				
				DoctorIF aux=it.getNext();

				if(beInList(aux.getStudents(), doc)){
					list.insert(aux, list.size()+1);
					list=(ListIF<DoctorIF>) antece(aux, generation-1, list);
					
					
					
				}
				
			}
			return list;
		}
		
		
		
	}
	

	
	
	
	


	public CollectionIF<DoctorIF> getDescendants(int generations) {
		
		return descen(this, generations, new List<DoctorIF>());
	}
	
	
	private CollectionIF<DoctorIF> descen(DoctorIF doc, int gene, ListIF<DoctorIF> list){
		
		if(gene==1){
			
			IteratorIF<DoctorIF> it = doc.getStudents().iterator();
			while(it.hasNext()){
				
				DoctorIF aux=it.getNext();
				list.insert(aux, list.size()+1);
			}
			
			return list;
		}
		
		
		
		IteratorIF<DoctorIF> it = doc.getStudents().iterator();
		
			while(it.hasNext()){
				
				DoctorIF aux=it.getNext();
				

					list.insert(aux, list.size()+1);
					list = (ListIF<DoctorIF>) descen(aux, gene-1, list);
				}
			
		
		
		return reverseRepetitions(list);
	}
	
	

	
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


	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	

	public CollectionIF<DoctorIF> getSupervisors(){
		
		ListIF<DoctorIF> list=new List<DoctorIF>();
		if(academiac.getSupervisors()!=null){
			IteratorIF<DoctorIF> it=academiac.getSupervisors().iterator();
			
			while(it.hasNext()){
				
				DoctorIF doc=it.getNext();
				
				if(beInList(doc.getStudents(), this)){
					
					list.insert(doc, list.size()+1);			
				}
			}
		}		
		
		return list;
	}

	
	void addStudent(DoctorIF newDoctor){
		
		((List<DoctorIF>) students).insert(newDoctor, students.size()+1);
	}



}
