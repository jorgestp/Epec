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
		
		arbol.setRoot(null);
		
	}




	@Override
	public DoctorIF getFounder() {
		
		return arbol.getRoot();
	}

	
	//funciona
	public DoctorIF getDoctor(int id) {
		
		
		
		if(id==1){
			
			return arbol.getRoot();
		}
		
		
		
		return find(arbol.getChildren(), id);
		
	}
	
		private DoctorIF find(ListIF<TreeIF<DoctorIF>> list, int id){
			//No funciona bien el find este. Ya añade bien a la academia.
			DoctorIF doc=null;

			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			
			while(it.hasNext() && doc==null ){
				
				TreeIF<DoctorIF> aux=it.getNext();
				DoctorS doctor=(DoctorS) aux.getRoot();
				
				if(doctor.getId()==id){
					
					doc=doctor;
					
					return doc;
					
					
				}else{
					
					doc=find(aux.getChildren(), id);
					
					
				}
			}
			
			
			return doc;
		}
		
		
		
	


	@Override
	public int size() {
		
		return size;
	}

	//FUNCIONA
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
		
			encuentra(GetTree(), newDoctor, supervisor);
		
		
	
	}
	
	private void encuentra(TreeIF<DoctorIF> tree,DoctorIF newdoctor, DoctorIF sup){
		DoctorS doctorS = (DoctorS) sup;
		DoctorS academiaDoctorS = (DoctorS) tree.getRoot();
		
		//No se pueden comparar referencias ya que no son iguales. Por eso daba el error.
		if(academiaDoctorS.getId()==doctorS.getId()){
			
			tree.addChild(tree.getChildren().size()+1, new Tree<DoctorIF>(newdoctor));
			size++;
		}else{
			
			
			ListIF<TreeIF<DoctorIF>> list=tree.getChildren();
			IteratorIF<TreeIF<DoctorIF>> it=list.iterator();
			
			boolean bandera=false;
			while(it.hasNext() && !bandera){
				TreeIF<DoctorIF> subarbol=it.getNext();
				DoctorS docSubarbol=(DoctorS) subarbol.getRoot();
//				if(subarbol.getRoot().equals(doc)){
				//No se pueden comparar referencias ya que no son iguales. Por eso daba el error.
				if(docSubarbol.getId()==doctorS.getId()){	
					subarbol.addChild(subarbol.getChildren().size()+1, new Tree<DoctorIF>(newdoctor));
					size++;
					bandera=true;
				}else{
					
					 encuentra(subarbol, sup, newdoctor);
				}
				 
			}
		}
		
	
	}
	
	
	
	


	//FUNCIONA
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		
		
			anadeRelacionSupervision(arbol, student, supervisor);
			
	}
	
	private void anadeRelacionSupervision(TreeIF<DoctorIF> tree, DoctorIF student, DoctorIF supervisor){
			
			ListIF<TreeIF<DoctorIF>> hijos=tree.getChildren();
			
			if(tree.getRoot().equals(supervisor)){
				
				
				
				hijos.insert(new Tree<DoctorIF>(student), hijos.size()+1);
				
			}else{
				
				
				IteratorIF<TreeIF<DoctorIF>> it=hijos.iterator();
				
					while(it.hasNext()){
						TreeIF<DoctorIF> subTree=it.getNext();
						
						if(subTree.getRoot().equals(supervisor)){
							
							
						}
						anadeRelacionSupervision(subTree, student, supervisor);
					}
				
				
			}
			
		}
	
	
	@Override
	public IteratorIF<DoctorIF> iterator() {
	
		return null;
	}


	

}
