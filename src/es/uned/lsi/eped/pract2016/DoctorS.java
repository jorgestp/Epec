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
	
	private ListIF<DoctorIF> descendientes( int generations, TreeIF<DoctorIF> tree){
		
		ListIF<DoctorIF> lista=new List<DoctorIF>();
		
		if(generations==0){
			
			return lista;
		}
		if(tree.isLeaf()){
			
			return lista;
		}
		
		ListIF<TreeIF<DoctorIF>> listaHijos=tree.getChildren();
		
		incluirEnLista(listaHijos, lista, generations-1);
		
		
		IteratorIF<TreeIF<DoctorIF>> it=listaHijos.iterator();
		
		while(it.hasNext()){
			
			TreeIF<DoctorIF> subarbol=it.getNext();

			
			lista=descendientes(generations -1, subarbol);
			
		}
		
		return lista;
	}
	
	private ListIF<DoctorIF> incluirEnLista(ListIF<TreeIF<DoctorIF>> hijos, ListIF<DoctorIF> lista, int generations){
		
		
		TreeIF<DoctorIF> sub = null;
		if(generations==0){
			
			return lista;
		}
		IteratorIF<TreeIF<DoctorIF>> it=hijos.iterator();
		
		while(it.hasNext()){
			
			 sub=it.getNext();
			lista.insert(sub.getRoot(), lista.size());
			
		}
		descendientes(generations-1, sub);
		
		return lista;
	}
	
	
	private TreeIF<DoctorIF> buscaDoctor(DoctorIF doctor, TreeIF<DoctorIF> tree){
		
		if(tree.getRoot().equals(doctor)){
			
			return tree;
		}
		else{
			
			ListIF<TreeIF<DoctorIF>> list= tree.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			
			while(it.hasNext()){
				
				TreeIF<DoctorIF> subarbol=it.getNext();
				
				subarbol=buscaDoctor(doctor, subarbol);
				
			}
			
		}
		
		return tree;
	
	}
	

	@Override
	public CollectionIF<DoctorIF> getSiblings() {
		
		
		
		return null;
	}

	public String toString()	{
		
		return "" + id;
	}
	

		
		
	
}
