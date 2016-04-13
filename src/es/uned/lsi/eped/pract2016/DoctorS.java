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

		return  (DoctorS) buscaDoctor(c, this);

	}
	
	private DoctorIF buscaDoctor(TreeIF<DoctorIF> tree, DoctorIF doctor){
		
		
		if(doctor.equals(tree.getRoot())){
			
			return null;
		}else{
			ListIF<TreeIF<DoctorIF>> hijos=tree.getChildren();
			
			IteratorIF<TreeIF<DoctorIF>> it=hijos.iterator();
			
			while(it.hasNext()){
				
				TreeIF<DoctorIF> subarbol=it.getNext();
				
				if(subarbol.getRoot().equals(doctor)){
					
					return subarbol.getRoot();
					 
				}else{
					
					buscaDoctor(subarbol, doctor);
				}
			}
			
		}
		return null;
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
