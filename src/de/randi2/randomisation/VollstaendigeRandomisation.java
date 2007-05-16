package de.randi2.randomisation;

import java.util.Random;
import java.util.Vector;

import de.randi2.datenbank.exceptions.DatenbankFehlerException;
import de.randi2.model.exceptions.RandomisationsException;
import de.randi2.model.fachklassen.beans.PatientBean;
import de.randi2.model.fachklassen.beans.StudieBean;
import de.randi2.model.fachklassen.beans.StudienarmBean;

/**
 * Stellt eine Randomisationsverwaltung nach dem Verfahren der vollstaendigen
 * Randomisation zur Verfuegung. Dabei wird jeder Patient absolut zufaellig
 * einem Studienarm zugeordnet. Es findet keine Kontrolle nach Gleichverteilung
 * u.ae. zwischen den Studienarmen statt.
 * 
 * @author Johannes Thoenes [johannes.thoenes@urz.uni-heidelberg.de]
 * @version $Id: VollstaendigeRandomisation.java 2088 2007-04-23 16:20:02Z
 *          jthoenes $
 */
public class VollstaendigeRandomisation extends Randomisation {

	/**
	 * Der Zufallszahlgenerator.
	 */
	private Random zufall = null;

	/**
	 * Der Name der Randomistaion
	 */
	public static final String NAME = "Vollständige Randomisation";

	/**
	 * Erzeugt eine Randomisationsverwaltung fuer die vollstaendige
	 * Randomisierung.
	 * 
	 * @param studie
	 *            Die Studie deren Randomisation verwaltet werden soll.
	 * @throws RandomisationsException
	 *             Falls die uebergebene Studie null ist.
	 * @see Randomisation#Randomisation(String, StudieBean)
	 */
	public VollstaendigeRandomisation(StudieBean studie)
			throws RandomisationsException {
		super(NAME, studie);
		zufall = new Random();
	}

	/**
	 * Fuert die Randomisation eines Patienten nach vollstaendiger Randomisation
	 * durch. Das heisst, der Patient wird absolut zufaellig ohne jede
	 * Ausgewogenheitskorrektur unter den Studienarmen zugeordnet.
	 * 
	 * @param patient
	 *            Der Patient der durch die Randomisation einem Studienarm
	 *            zugeordnet werden soll. Nach erfolgreicher Ausfuehrung der
	 *            Methode, ist der Patient einem Studienarm hinzugefuegt.
	 * @throws RandomisationsException
	 *             Wenn der Patient nicht zur Verwalteten Studie gehoert.
	 * @throws DatenbankFehlerException
	 *             Falls ein Fehler in der Datenbank auftritt.
	 * @see Randomisation#randomisierePatient(PatientBean patient)
	 * @see RandomisationsException#PATIENT_NICHT_IN_STUDIE
	 */
	@Override
	public void randomisierenPatient(PatientBean patient)
			throws RandomisationsException, DatenbankFehlerException {
		Vector<StudienarmBean> studienarme = super.studie.getStudienarme();
		int index = (int) (this.zufall.nextDouble() * (studienarme.size()));
		studienarme.get(index).getPatienten().add(patient);
		patient.setStudienarm(studienarme.get(index));
	}

}
