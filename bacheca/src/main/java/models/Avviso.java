package models;

import java.util.LinkedList;

public class Avviso {
	
	
private int idAvviso;
private int idUtente;
private String livello;
private String dataPub;
private String dataMod;
private String dataScad;
private String testo;
private LinkedList<Allegato> allegati;
/**
 * @param idAvviso
 * @param idUtente
 * @param livello
 * @param dataPub
 * @param dataMod
 * @param dataScad
 * @param testo
 */

public Avviso(int idAvviso, int idUtente, String livello, String dataPub, String dataMod, String dataScad,
		String testo) {
	this.idAvviso = idAvviso;
	this.idUtente = idUtente;
	this.livello = livello;
	this.dataPub = dataPub;
	this.dataMod = dataMod;
	this.dataScad = dataScad;
	this.testo = testo;
}

/**
 * @param allegati
 */
public Avviso(LinkedList<Allegato> allegati) {
	super();
	this.allegati = allegati;
}

/**
 * 
 */
public Avviso() {
}
/**
 * @return the idAvviso
 */
public int getIdAvviso() {
	return idAvviso;
}
/**
 * @param idAvviso the idAvviso to set
 */
public void setIdAvviso(int idAvviso) {
	this.idAvviso = idAvviso;
}
/**
 * @return the idUtente
 */
public int getIdUtente() {
	return idUtente;
}
/**
 * @param idUtente the idUtente to set
 */
public void setIdUtente(int idUtente) {
	this.idUtente = idUtente;
}
/**
 * @return the livello
 */
public String getLivello() {
	return livello;
}
/**
 * @param livello the livello to set
 */
public void setLivello(String livello) {
	this.livello = livello;
}
/**
 * @return the dataPub
 */
public String getDataPub() {
	return dataPub;
}
/**
 * @param dataPub the dataPub to set
 */
public void setDataPub(String dataPub) {
	this.dataPub = dataPub;
}
/**
 * @return the dataMod
 */
public String getDataMod() {
	return dataMod;
}
/**
 * @param dataMod the dataMod to set
 */
public void setDataMod(String dataMod) {
	this.dataMod = dataMod;
}
/**
 * @return the dataScad
 */
public String getDataScad() {
	return dataScad;
}
/**
 * @param dataScad the dataScad to set
 */
public void setDataScad(String dataScad) {
	this.dataScad = dataScad;
}
/**
 * @return the testo
 */
public String getTesto() {
	return testo;
}
/**
 * @param testo the testo to set
 */
public void setTesto(String testo) {
	this.testo = testo;
}

public LinkedList<Allegato> getAllegati() {
	return allegati;
}

public void setAllegati(LinkedList<Allegato> allegati) {
	this.allegati = allegati;
}




}
