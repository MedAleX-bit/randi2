package de.randi2.model.exceptions;

import de.randi2.utility.SystemException;

/**
 * Die Klasse kapselt die Fehler die waehrend der Randomisation auftreten. Es
 * sollte darauf geachtet werden, dass bei normalen Programmablauf diese Fehler
 * niemals auftreten. Insofern sollte ein Auftreten der Exception auf einen
 * Programmierfehler hinweisen.
 * 
 * @author Johannes Thoenes [johannes.thoenes@urz.uni-heidelberg.de]
 * @version $Id: RandomisationsException.java 2442 2007-05-07 08:45:21Z jthoenes $
 */
public class RandomisationsException extends SystemException {

	/**
	 * Fehler falls der zu randomisierende Patient andere Strata als die Studie
	 * hat.
	 */
	public static final String FALSCHE_STRATA = "Die Strata des Patienten entsprechen nicht den Strata, die f&uuml;r ";

	/**
	 * Fehler falls die gewaehlte Blockgroesse kein Vielfaches der Anzahl der
	 * Studienarme ist.
	 */
	public static final String BLOCKGROESSE_KEIN_VIELFACHES_DER_ARMEANZAHL = "Die &uuml;bergebene Blockgr&ouml;sse ist kein Vielfaches der Anzahl der Studienarme.";

	/**
	 * Fehler falls die uebergebenen Studie null ist.
	 */
	public static final String STUDIE_NULL = "Die &uuml;bergebene Studie darf nicht null sein.";

	/**
	 * Fehler falls versucht wird, einen neuen Block in der Datenbank anzulegen,
	 * obwohl noch Werte existieren.
	 */
	public static final String WERTE_EXISTIEREN = "Zu dem uebergebenen Block existieren noch Werte in der Datenbank.";

	/**
	 * Ein Konstruktor dieser Klasse
	 * 
	 * @param arg0
	 *            eine Konstante aus dieser Klasse als Message
	 */
	public RandomisationsException(String arg0) {
		super(arg0);
	}
}