package es.uned.lsi.eped.pract2016;

import es.uned.lsi.eped.DataStructures.*;



/**
 * Reperesentacion de una Academis formada por una coleccion de Doctores
 * @author Windows
 *
 */
public interface AcademiaIF extends CollectionIF<DoctorIF>{
	/*
	 * Consulta el doctor que fundó la Academia
	 * @returns el doctor fundador de la Academia
	 */

	public DoctorIF getFounder();
	
	/**
	 * Busca un Doctor dentro de la Academia a partir de su identificador
	 * @pre el doctor pertenece a la Academia && id>0
	 * @param el identificador del doctor a buscar
	 * @returns el doctor buscado
	 */
	public DoctorIF getDoctor (int id);
	
	/**
	 * Consulta el numero de doctores que pertenecen a una Academia
	 * @returns el numero de Doctores pertenecientes a la Academia
	 * 
	 */
	public int size();
	
	/**
	 * Añade un nuevo Doctor a la Academia a partir de la lectura de su Tesis.
	 * @paran el nuevo Doctor y su primer director de Tesis
	 * @pre el nuevo doctor no debe pertenecer a la Academia && el supervisor si debe pertenecer
	 * a la Academia
	 */
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor);
	
	
	/**
	 * Añade una relacion de direccion al Arbol Genealógico de la Academia.
	 * @param el nuevo Doctor y uno de sus codirectores de Tesis
	 * @pre ambos doctores deben pertenecer a la Academia && no existe una relacion
	 * de supervision previa entre ambos
	 */
	public void addSupervision (DoctorIF student, DoctorIF supervisor);
	
}

