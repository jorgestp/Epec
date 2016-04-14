package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;




public class AcademiaS implements AcademiaIF {

	private TreeIF<DoctorIF> arbol;
	private  int size;
	
	
	
	public AcademiaS(){
		
		arbol=new Tree<DoctorIF>();
		size++;
	}
	public void setFounder(DoctorIF doctor){
		
		arbol.setRoot(doctor);
	}
	
	public TreeIF<DoctorIF> GetTree(){
		return arbol;
	}
	
	
	public boolean isEmpty() {
		
		return (arbol.getRoot()==null);
	}

	@Override
	public boolean contains(DoctorIF e) {
		
		if(arbol.isEmpty()){
			return false;
		}else if(e.equals(arbol.getRoot())){
			
			return true;
		}else{
			
			ListIF<TreeIF<DoctorIF>> list=arbol.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
				
				while(it.hasNext()){
					
					TreeIF<DoctorIF> root=it.getNext();
					DoctorIF hijo=root.getRoot();
					if(hijo.equals(e) || root.contains(e)){
						
						return true;
					}
				}
		}
	
		return false;
	}

	@Override
	public void clear() {
		
		DoctorIF root=arbol.getRoot();
		
		root=null;
		
		ListIF<TreeIF<DoctorIF>> hijos=arbol.getChildren();
		hijos=null;
		size=0;
		
	}




	@Override
	public DoctorIF getFounder() {
		
		return arbol.getRoot();
	}

	@Override
	public DoctorIF getDoctor(int id) {
		
		if(id==1){
			
			return arbol.getRoot();
		}
		
		return arbol.getChild(id).getRoot();
		
	}


	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
		
			Encuentra(arbol, supervisor, newDoctor);
		
		size++;
	
	}
	
	private void Encuentra(TreeIF<DoctorIF> tree,DoctorIF sup, DoctorIF newdoctor){
		
		if(tree.getRoot().equals(sup)){
			
			arbol.addChild(tree.getChildren().size()+1, new Tree<DoctorIF>(newdoctor));
		}else{
			
			
			ListIF<TreeIF<DoctorIF>> list=tree.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			while(it.hasNext()){
				TreeIF<DoctorIF> subarbol=it.getNext();
				if(subarbol.getRoot().equals(sup)){
					
					subarbol.addChild(subarbol.getChildren().size()+1, new Tree<DoctorIF>(newdoctor));
				}else{
					
					 Encuentra(subarbol, sup, newdoctor);
				}
				 
			}
		}
		
	
	}
	
	
	
	public void Mostrar(AcademiaS academia){	
			
		ImprimiRoot(arbol);	
		ListIF<TreeIF<DoctorIF>> list=arbol.getChildren();	
		IteratorIF<TreeIF<DoctorIF>> it=list.iterator();	
		while(it.hasNext()){		
			TreeIF<DoctorIF> doctor=it.getNext();		
			imprimir(arbol, doctor);	
		}	
	}
	
	private void imprimir(TreeIF<DoctorIF> tree, TreeIF<DoctorIF> doctor){
		DoctorS supervisor=(DoctorS) tree.getRoot();
		int sup=supervisor.getId();
		
		DoctorS hijo=(DoctorS) doctor.getRoot();
		int id_doctor=hijo.getId();
		
		if(tree.isLeaf()){
			
			System.out.println("La tesis de " + id_doctor+ " fue supervisada por " + sup);
		}else{
			
			ListIF<TreeIF<DoctorIF>> list=doctor.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			while(it.hasNext()){
				System.out.println("La tesis de " + id_doctor+ " fue supervisada por " + sup);
				imprimir(it.getNext(), arbol);
			}
		}
	}
		
	private void ImprimiRoot(TreeIF<DoctorIF> tree){
		
	DoctorS padre=(DoctorS) tree.getRoot();
		
		int id=padre.getId();
		
		System.out.println(" La academa fué fundada por " + id);
	}
			
	


	@Override
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		
		
			AñadeRelacionSupervision(arbol, student, supervisor);
			
	}
	
	private void AñadeRelacionSupervision(TreeIF<DoctorIF> tree, DoctorIF student, DoctorIF supervisor){
			
			if(tree.getRoot().equals(supervisor)){
				
				ListIF<TreeIF<DoctorIF>> hijos=tree.getChildren();
				
				hijos.set(hijos.size()+1, new Tree<DoctorIF>(student));
				
			}else{
				
				ListIF<TreeIF<DoctorIF>> hijos=tree.getChildren();
				IteratorIF<TreeIF<DoctorIF>> it=hijos.iterator();
				
					while(it.hasNext()){
						TreeIF<DoctorIF> subTree=it.getNext();
						
						AñadeRelacionSupervision(subTree, student, supervisor);
					}
				
				
			}
			
		}
	
	
	@Override
	public IteratorIF<DoctorIF> iterator() {
	
		return null;
	}


	

}
