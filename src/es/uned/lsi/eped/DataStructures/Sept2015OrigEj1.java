package es.uned.lsi.eped.DataStructures;



public class Sept2015OrigEj1 {

	public static void main(String[] args) {
		ListIF<Integer> lista = new List<Integer>();
		lista.insert(4, lista.size()+1);
		lista.insert(5, lista.size()+1);
		lista.insert(0, lista.size()+1);
		lista.insert(3, lista.size()+1);
		lista.insert(7, lista.size()+1);
		lista.insert(1, lista.size()+1);
		lista.insert(9, lista.size()+1);

		ListIF<Integer> prefijo = maxPrefixIterativo(lista, 10);
		System.out.println("Caso iterativo: ");		
		imprimirListaEnteros(prefijo);
		
		prefijo = maxPrefixRecursivoNoFinal(lista, 10);
		System.out.println("Caso recursivo NO final: ");
		imprimirListaEnteros(prefijo);
		
		prefijo = maxPrefixRecursivoFinal(lista, 10);
		System.out.println("Caso recursivo final: ");
		imprimirListaEnteros(prefijo);
		
	}
	
	/**
	 * Saca por pantalla el contenido de una lista de enteros
	 * 
	 * @param prefijo
	 */
	private static void imprimirListaEnteros(ListIF<Integer> prefijo) {
		System.out.print("[");
		for(int i=1; i<=prefijo.size();i++){
			System.out.print(prefijo.get(i));
			if(i<prefijo.size()){
				System.out.print(", ");	
			}
		}
		System.out.println("]");
	}

	/**
	 * Ejercicio 1 examen septiembre 2015
	 * 
	 * @param l
	 * @param n
	 * 
	 * @return
	 */
	public static ListIF<Integer> maxPrefixIterativo(ListIF<Integer>l, int n){
		ListIF<Integer> resultado = new List<Integer>();
		int suma = 0;
		
		IteratorIF<Integer>it = l.iterator();
		while(it.hasNext()){
			int aux = it.getNext();
			
			if(aux+suma<=n){
				suma += aux;
				resultado.insert(aux, resultado.size()+1);
			}else{
				break;
			}	
		}
		
		return resultado;
	}

	/**
	 * Ejercicio 1 examen septiembre 2015: versión Recursiva NO Final
	 * 
	 * Para la recursión no final la solución la vamos construyendo 
	 * conforme se deshacen las llamadas recursivas.
	 * 
	 * @param l
	 * @param n
	 * 
	 * @return
	 */
	public static ListIF<Integer> maxPrefixRecursivoNoFinal(ListIF<Integer>l, int n){
		return maxPrefixRecursivoAux(l, n, 1, 0);
	}

	private static ListIF<Integer> maxPrefixRecursivoAux(ListIF<Integer> l,
			int n, int i, int suma) {
		ListIF<Integer> resultado = new List<Integer>();
		if(l.isEmpty()){
			return resultado;
		}
		if(i>l.size()){
			return resultado;
		}
		if(l.get(i)+suma <= n){
			resultado = maxPrefixRecursivoAux(l,n,i+1,l.get(i)+suma);
			resultado.insert(l.get(i), 1);
			return resultado;
		}
		return resultado;
	}
	

	/**
	 * Ejercicio 1 examen septiembre 2015: versión Recursiva Final
	 * 
	 * Para convertir la recursión en final, necesitamos un parámetro 
	 * de entrada donde se vaya construyendo la solución
	 * 
	 * @param l
	 * @param n
	 * 
	 * @return
	 */
	public static ListIF<Integer> maxPrefixRecursivoFinal(ListIF<Integer>l, int n){
		return maxPrefixRecursivoAux2(l, n, 1, 0, new List<Integer>());
	}
	
	private static ListIF<Integer> maxPrefixRecursivoAux2(ListIF<Integer> l,
			int n, int i, int suma, ListIF<Integer> resultado) {
		if(l.isEmpty()){
			return resultado;
		}
		if(i>l.size()){
			return resultado;
		}
		if(l.get(i)+suma <= n){
			resultado.insert(l.get(i), 1);
			resultado = maxPrefixRecursivoAux2(l,n,i+1,l.get(i)+suma, resultado);
			return resultado;
		}
		return resultado;
	}
}
