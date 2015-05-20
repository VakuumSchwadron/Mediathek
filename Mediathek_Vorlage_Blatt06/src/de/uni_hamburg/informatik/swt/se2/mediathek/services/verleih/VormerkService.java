package de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih;

import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.ObservableService;

/**
 * Der VormerkService erlaubt es, Medien vorzumerken.
 * 
 * Für jedes vorgemerkte Medium wird ein neues Array angelegt, in dem bis zu
 * drei Vormerker notiert werden können. Wird das Medium an den ersten Vormerker
 * verliehen, so rücken die folgenden Vormerker in der Position auf. Wird das
 * Medium an den einzig vorhandenen Vormerker verliehen, so wird das Array
 * gelöscht.
 * 
 * 
 * @author VakuumSchwadron
 * @version Blatt 6
 *
 */
public interface VormerkService extends ObservableService
{

    /**
     * Merkt die Medien für einen Kunden vor. Dabei wird der Kunde jeweils in
     * das Vormerk-Array der Medien an der ersten freien Position eingetragen.
     * 
     * @param kunde
     *            Ein Kunde, für den das Medium vorgemerkt werden soll
     * @param medien
     *            Die Medien, die vorgemerkt werden sollen
     * 
     * @require kundeImBestand(kunde)
     * @require medienImBestand(medien)
     * @require medienVonKundeVormerkbar(kunde, medien)
     * 
     */
    void merkeVor(Kunde kunde, List<Medium> medien);

    /**
     * Prüft, ob die ausgewählten Medien für den Kunden vorgemerkt werden
     * können.
     * 
     * @param kunde
     *            Der Kunde für den geprüft werden soll
     * @param medien
     *            die ausgewählten Medien
     * 
     * @return true, wenn das Vormkerken der Medien für den Kunden möglich ist,
     *         andernfalls false
     * 
     * @require kundeImBestand(kunde)
     * @require medienImBestand(medien)
     */
    boolean medienVonKundeVormerkbar(Kunde kunde, List<Medium> medien);

    /**
     * 
     * @return Eine Kopie des Vormerk-Arrays des ausgewählten Arrays. Ist kein
     *         Vormeker vorhanden, dann wird ein Array zurückgegeben, dass nur
     *         die Einträge null enthält.
     * 
     * @param medium
     *            Medium, dessen Vormerker ausgegeben werden
     * 
     * @require mediumImBestand(medium)
     * @require mediumHatVormerker(medium)
     * 
     * @ensure result != null
     */
    Kunde[] getVormerker(Medium medium);

    /**
     * Verschiebt die Vormerker im Vormerk-Array um jeweils eine Position nach
     * vorne. Der Vormerker auf der ersten Position geht dabei verloren.
     * 
     * @param medium
     *            Medium, dessen Vormerker aufrücken sollen
     * 
     * @require mediumHatVormerker(medium)
     * @require mediumImBestand(medium)
     */
    void rueckeAuf(Medium medium);

    /**
     * Prüft ob der angebene Kunde existiert. Ein Kunde existiert, wenn er im
     * Kundenstamm enthalten ist.
     * 
     * @param kunde
     *            Ein Kunde.
     * @return true wenn der Kunde existiert, sonst false.
     * 
     * @require kunde != null
     */
    boolean kundeImBestand(Kunde kunde);

    /**
     * Prüft, ob das Medium mindestens einen Vormerker hat.
     * 
     * @param medium
     *            Medium, das überprüft werden soll
     * @return true, wenn das Medium mindestens einen Vormerker hat.
     * 
     * @require mediumImBestand(medium)
     */
    boolean mediumHatVormerker(Medium medium);

    /**
     * Prüft ob das angebene Medium existiert. Ein Medium existiert, wenn es im
     * Medienbestand enthalten ist.
     * 
     * @param medium
     *            Ein Medium.
     * @return true wenn das Medium existiert, sonst false.
     * 
     * @require medium != null
     */
    boolean mediumImBestand(Medium medium);

    /**
     * Prüft ob die angebenen Medien existierien. Ein Medium existiert, wenn es
     * im Medienbestand enthalten ist.
     * 
     * @param medien
     *            Eine Liste von Medien.
     * @return true wenn die Medien existieren, sonst false.
     * 
     * @require medien != null
     * @require !medien.isEmpty()
     */
    boolean medienImBestand(List<Medium> medien);

    /**
     * Prüft, ob der angegebene Kunde ein Vormerker des ausgewählten Mediums
     * ist.
     * 
     * @param kunde
     *            Kunde, für den überprüft werden soll
     * @param medium
     *            Medium, das überprüft werden soll
     * 
     * @require kundeImBestand(kunde)
     * @require mediumImBestand(medium)
     * 
     * @return true, wenn der angebene Kunde ein Vormerker des ausgewählten
     *         Mediums ist
     */
    boolean istKundeVormerker(Kunde kunde, Medium medium);
}