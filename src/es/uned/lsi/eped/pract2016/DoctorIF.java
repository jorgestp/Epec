
package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;

/**
 * @author Jorge
 * 
 * Representacion de un Doctor perteneciente a una Academia
 *
 */
public interface DoctorIF {
	
	/**
	 * Consulta los ancestros acad�micos del Doctor, limit�ndose al n�mero de
	 * generaciones indicado por el par�matero
	 * @returns la coleccion de ancestros acad�micos del doctor limitada al numero
	 * de generaciones indicado o hasta llegar al fundador de la academia. No deber� contener
	 * repeticiones
	 * @param n�mero de generaciones a considerar
	 * @pre generations > 0
	 */
	public CollectionIF<DoctorIF> getAncestors(int generations);
	
	/**
	 * Consulta los doctores a quienes el doctor ha dirigido sus tesis.
	 * @returns la coleecion de doctores cuyo director de tesis es el doctor.
	 *
	 */
	public CollectionIF<DoctorIF> getStudents();
	
	/**
	 * Consulta los descendientes acad�micos del doctor, limit�ndose al numero de generaciones
	 * indicado por el parametro.
	 * @returns la coleccion de descendientes academicos del doctor limitada al numero de
	 * generaciones indicado o hasta llegar a Doctores que no haya dirigido ninguna
	 * tesis. No deber� contener repeticiones
	 * 
	 */
	public CollectionIF<DoctorIF> getDescendants( int generations);
	
	/**
	 * Consulta los doctores que comparten director de tesis con el doctor.
	 * @returns la coleccion de hermanos academicos del doctor. No deber�a contener
	 * repeticiones ni al doctor llamante
	 * 
	 
	 */
	public CollectionIF<DoctorIF> getSiblings();
	
	
	
	
	
	
	

}
