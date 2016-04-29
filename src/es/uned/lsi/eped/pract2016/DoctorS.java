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

	//FUNCIONA a medias
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
				
				while(it.hasNext()){
					
					TreeIF<DoctorIF>subArbol=it.getNext();
					 doc=subArbol.getRoot();
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

	
	@Override
	public CollectionIF<DoctorIF> getAncestors(int generations) {

		ListIF<DoctorIF> colec=new List<DoctorIF>();
		TreeIF<DoctorIF> arbol=new Tree<>();
		arbol= academia.GetTree();
		
		if(this.equals(arbol.getRoot())){
			
			return null;
		}else{
			
			return antecesores(generations, this, arbol);
		}
	
	}
	private ListIF<DoctorIF> antecesores(int generations, DoctorIF doctor, TreeIF<DoctorIF> tree){
			
			ListIF<DoctorIF> antece=new List<DoctorIF>();
		
		
			if(tree.getRoot().equals(doctor)){
				
				return null;
				
			}
			if(generations==0){
				
				antece.insert(this.getSupervisor(), antece.size());
				return antece;
			}else{
				
				DoctorS doc= ((DoctorS) doctor).getSupervisor();
				
				antece= antecesores(generations-1, doc, tree);
				antece.insert(doc, antece.size());
				return antece;
				
				
			}
			

		}
	
	


	@Override
	public CollectionIF<DoctorIF> getStudents() {
		TreeIF<DoctorIF> arbol=academia.GetTree();	
		return hijos(arbol, this);
	
	}
		private CollectionIF<DoctorIF> hijos(TreeIF<DoctorIF> tree, DoctorIF padre){
			
			ListIF<DoctorIF> lista=new List<DoctorIF>();
			if(tree.getRoot().equals(padre)){
				
				ListIF<TreeIF<DoctorIF>> list=tree.getChildren();
				
				IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
				while(it.hasNext()){
					
					TreeIF<DoctorIF> hijos=it.getNext();
					lista.insert(hijos.getRoot(), 1);
				}
				return lista;
			}
			
			ListIF<TreeIF<DoctorIF>> list=tree.getChildren();
			
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
				
				while(it.hasNext()){
					
					TreeIF<DoctorIF> arbol=it.getNext();
					
					return hijos(arbol,padre);
				}

			return lista;
		}

	@Override
	public CollectionIF<DoctorIF> getDescendants(int generations) {
		
		TreeIF<DoctorIF> tree=academia.GetTree();
		
		 TreeIF<DoctorIF> arbol=buscaDoctor(this, tree);
		
		
		return descendientes( generations, arbol);
	}
	
	private CollectionIF<DoctorIF> descendientes( int generations, TreeIF<DoctorIF> tree){
		
		Set<DoctorIF> conjunto=new Set<DoctorIF>();
		
		if(generations==0){
			
			return conjunto;
		}else{
			
			ListIF<TreeIF<DoctorIF>> lista=tree.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=lista.iterator();
			
			while (it.hasNext()){
				
				TreeIF<DoctorIF> subArbol=it.getNext();
				
				DoctorIF doc=subArbol.getRoot();
				SetIF<DoctorIF> conjuntoDescendiente = (SetIF<DoctorIF>) doc.getDescendants(generations - 1);
				SetIF<DoctorIF> descConHijos = new Set<DoctorIF>(doc).union(conjuntoDescendiente);
				
				conjunto=(Set<DoctorIF>) conjunto.union(descConHijos);
				
				
			
			}
			
			return conjunto;
		}
		
		
	}
	
	 public TreeIF<DoctorIF> buscaDoctor(DoctorIF doctor, TreeIF<DoctorIF> tree) {
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
	
	

	

	@Override
	public CollectionIF<DoctorIF> getSiblings() {
		
		
		
		return null;
	}

	public String toString()	{
		
		return "" + id;
	}
	

		
		
	
}
