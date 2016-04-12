
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
	 * Consulta los ancestros académicos del Doctor, limitándose al número de
	 * generaciones indicado por el parámatero
	 * @returns la coleccion de ancestros académicos del doctor limitada al numero
	 * de generaciones indicado o hasta llegar al fundador de la academia. No deberá contener
	 * repeticiones
	 * @param número de generaciones a considerar
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
	 * Consulta los descendientes académicos del doctor, limitándose al numero de generaciones
	 * indicado por el parametro.
	 * @returns la coleccion de descendientes academicos del doctor limitada al numero de
	 * generaciones indicado o hasta llegar a Doctores que no haya dirigido ninguna
	 * tesis. No deberá contener repeticiones
	 * 
	 */
	public CollectionIF<DoctorIF> getDescendants( int generations);
	
	/**
	 * Consulta los doctores que comparten director de tesis con el doctor.
	 * @returns la coleccion de hermanos academicos del doctor. No deberña contener
	 * repeticiones ni al doctor llamante
	 * 
	 
	 */
	public CollectionIF<DoctorIF> getSiblings();
	
	
	
	
	
	
	

}
