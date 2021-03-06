package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

public class DoctorS implements DoctorIF {

	
	private int id;
	private AcademiaS academia;
	
	
	public  DoctorS(int id, AcademiaS academia) {
		
		this.id=id;
		this.academia=academia;
		
	}
	
	public DoctorS(int iD2) {
		id=iD2;
	}
	
	
	public DoctorS(String string) {

		id=Integer.parseInt(string);
	}

	


	

	public DoctorS() {
		// TODO Auto-generated constructor stub
	}

	public DoctorS(int iD2, AcademiaIF a, DoctorIF doctor) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public AcademiaS getAcademia(){
		
		return academia;
	}


	public DoctorS getSupervisor(){
	
		TreeIF<DoctorIF> c=academia.GetTree();

		return (DoctorS) buscarPadre(c, this);

	}
	
	private DoctorIF buscarPadre(TreeIF<DoctorIF> arbolActual, DoctorIF doctor){
		
		DoctorIF doc = null;
		if(arbolActual.getRoot().equals(doctor)){
			
			
			return doctor;
			
		}else{
			
			ListIF<TreeIF<DoctorIF>> list=arbolActual.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			if(EstaEnLista(list, it, doctor)){
				
					doc=arbolActual.getRoot();
				return doc;
				
			}else{
				
				it.reset();
				
				while(it.hasNext() && doc==null){
					
					TreeIF<DoctorIF>subArbol=it.getNext();
					 doc= buscarPadre(subArbol, doctor);
					
					
				}
			}
			
		}
		
		return doc;
	}
	
	private boolean EstaEnLista(ListIF<TreeIF<DoctorIF>> list, IteratorIF<TreeIF<DoctorIF>> it, DoctorIF doctor){
		
		while(it.hasNext()){
			
			TreeIF<DoctorIF> hijos=it.getNext();
			if(hijos.getRoot().equals(doctor)){
				
				return true;
			}
		}
		
		return false;
	}



	public CollectionIF<DoctorIF> getAncestors(int generations) {

		
		TreeIF<DoctorIF> arbol=new Tree<>();
		arbol= academia.GetTree();
		
		if(this.equals(arbol.getRoot())){
			
			return new List<DoctorIF>();
		
		}else{
			
			return antecesores(generations, this, arbol);
		}
	
	}
	private ListIF<DoctorIF> antecesores(int generations, DoctorIF doctor, TreeIF<DoctorIF> tree){
			
			ListIF<DoctorIF> antece=new List<DoctorIF>();
		
		
			if(tree.getRoot().equals(doctor)){
				
				 antece.insert(doctor, antece.size()+1);
			
				return antece;
				
			}
			if(generations==0){
				
				antece.insert(this.getSupervisor(), antece.size()+1);
				return antece;
			}else{
				
				DoctorS doc= ((DoctorS) doctor).getSupervisor();
				
				if(doc!=null){
					
					
					antece= antecesores(generations-1, doc, tree);
					antece.insert(doc, antece.size());
					return antece;
				}

			}
			
			return antece;
		}
	
	


	public CollectionIF<DoctorIF> getStudents() {
		
		ListIF<DoctorIF> students=new List<DoctorIF>();
		
		TreeIF<DoctorIF> arbol=academia.GetTree();
		
		TreeIF<DoctorIF> doctor= buscaDoctor(this, arbol);
		ListIF<TreeIF<DoctorIF>> list=doctor.getChildren();
		IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
		
			while(it.hasNext()){
				
				TreeIF<DoctorIF> hijo=it.getNext();
				students.insert(hijo.getRoot(), students.size()+1);
				
			}
	
		
		return students;
	
	}
				
		


	public CollectionIF<DoctorIF> getDescendants(int generations) {
		
		SetIF<DoctorIF> conj=new Set<DoctorIF>();
		
		 TreeIF<DoctorIF> nodo=buscaDoctor(this, academia.GetTree());
		
		 if(generations<0){
			 
			 throw new IllegalArgumentException("La generacion debe ser mayor a 0");
		 }
		 
		 if(generations==0){
			 
			 return conj;
		 }
		 
		 		ListIF<TreeIF<DoctorIF>> list=nodo.getChildren();
		 		IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
		 		
		 		while(it.hasNext()){
		 			
		 			TreeIF<DoctorIF> sub=it.getNext();
		 			
		 			DoctorIF aux=sub.getRoot();
		 			SetIF<DoctorIF> conjDescendiente=(SetIF<DoctorIF>) aux.getDescendants(generations-1);
		 			SetIF<DoctorIF> conjConHijos=new Set<DoctorIF>(aux).union(conjDescendiente);
		 			conj=conj.union(conjConHijos);
		 		}
		 
		 
		
		return conj;
	}
	

	
	 private TreeIF<DoctorIF> buscaDoctor(DoctorIF doctor, TreeIF<DoctorIF> tree) {
		  TreeIF<DoctorIF> result = null;
		  if (tree.getRoot().equals(doctor)) {

		   result = tree;
		  } else {

		   ListIF<TreeIF<DoctorIF>> list = tree.getChildren();
		   IteratorIF<TreeIF<DoctorIF>> it = list.iterator();

		   while (it.hasNext() && result == null) {

		    TreeIF<DoctorIF> subarbol = it.getNext();

		    result = buscaDoctor(doctor, subarbol);

		   }

		  }

		  return result;

		 }
	
	

	

	
	public CollectionIF<DoctorIF> getSiblings() {
		
		TreeIF<DoctorIF> padre=busqueda(academia.GetTree(), this);
		
		ListIF<TreeIF<DoctorIF>> list=padre.getChildren();

		return incluir(list, this);
	}
	
	
	
	
	private TreeIF<DoctorIF> busqueda(TreeIF<DoctorIF> arbolActual, DoctorIF doctor){
		
		TreeIF<DoctorIF> doc = null;
		
		if(arbolActual.getRoot().equals(doctor)){
			
			
			return arbolActual;
			
		}else{
			
			ListIF<TreeIF<DoctorIF>> list=arbolActual.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			if(EstaEnLista(list, it, doctor)){
					doc=arbolActual;
				return doc;
				
			}else{
				
				it.reset();
				
				while(it.hasNext() && doc==null){
					
					TreeIF<DoctorIF>subArbol=it.getNext();
					 doc= busqueda(subArbol, doctor);
					
					
				}
			}
			
		}
		
		return doc;
	}

	private CollectionIF<DoctorIF> incluir(ListIF<TreeIF<DoctorIF>> list, DoctorIF doctor){
		
		ListIF<DoctorIF> hermanos=new List<DoctorIF>();
		
		IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
		
		while(it.hasNext()){
			
			TreeIF<DoctorIF> doc=it.getNext();
			
			if(!doc.getRoot().equals(doctor)){
				
				hermanos.insert(doc.getRoot(), hermanos.size()+1);
			}
			
		}
		
		
		return hermanos;
	}

	public String toString()	{
		
		return "" + id;
	}

	public void setAcademia(AcademiaS a) {
		
		academia=a;
		
	}


	

		
		
	
}
