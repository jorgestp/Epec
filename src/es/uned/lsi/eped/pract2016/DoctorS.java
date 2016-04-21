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
	
		TreeIF<DoctorIF> c=academia.GetTree();

		return (DoctorS) BuscarPadre(c, this);

	}
	
	private DoctorIF BuscarPadre(TreeIF<DoctorIF> arbolActual, DoctorIF doctor){
		
		if(arbolActual.getRoot().equals(doctor)){
			
			return null;
		}else{
			
			ListIF<TreeIF<DoctorIF>> list=arbolActual.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			if(EstaEnLista(list, it, doctor)){
				
				return arbolActual.getRoot();
			}else{
				
				while(it.hasNext()){
					
					TreeIF<DoctorIF>subArbol=it.getNext();
					BuscarPadre(subArbol, doctor);
				}
			}
			
		}
		
		return null;
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

		TreeIF<DoctorIF> tree=new Tree<DoctorIF>(this);
		ListIF<DoctorIF> colec=new List<>();
		TreeIF<DoctorIF> arbol=new Tree<>();
		arbol= academia.GetTree();
		
		if(this.equals(arbol.getRoot())){
			
			return null;
		}else{
			
			return Antecesores(generations, this, arbol, colec);
		}
	
	}
	private CollectionIF<DoctorIF> Antecesores(int generations, DoctorIF doctor, TreeIF<DoctorIF> tree, ListIF<DoctorIF> list){
			
			if(generations == 1){
				
				list.set(0, doctor);
				
				return list;
			}else{
				
				doctor=tree.getRoot();
				/////// FALTARIA LA PARTE RECURSIVA EN ESTE PUNTO PARA QUE VAYA SUBIENDO
				///DE PADRE A PADRE HASTA QUE generations==1
				
			}
			
			
			return list;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIF<DoctorIF> getSiblings() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString()	{
		
		return "" + id;
	}
	

		
		
	
}
