package calculettePostFix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * La classe <b>LogFile</b> permet de gérer les fichiers textes d'erreurs et de
 * résultats
 * 
 * @author Thomas
 * 
 */
public class LogFile {
	private static final String ERREURS_FILENAME = "Erreurs.txt";
	private static final String RÉSULTATS_FILENAME = "Résultats.txt";

	/**
	 * Création du fichier Resultats
	 * 
	 * @param texte
	 */
	public static void resTXT(String texte) {
		logTXT(RÉSULTATS_FILENAME, texte);
	}

	/**
	 * Création du fichier Erreurs
	 * 
	 * @param texte
	 */
	public static void errorsTXT(String texte) {
		logTXT(ERREURS_FILENAME, texte);
		// On affiche aussi à l'écran les erreurs logguées
		System.out.println("Erreur:" + texte);
	}

	/**
	 * Méthode permettant de réinitialiser les fichiers
	 */
	public static void reinitFichier() {
		reinitFichier(RÉSULTATS_FILENAME);
		reinitFichier(ERREURS_FILENAME);
	}

	/**
	 * Permet de réinitialiser les fichiers
	 * 
	 * @param nom_fichier
	 */
	private static void reinitFichier(String nom_fichier) {
		File logFile = new File(nom_fichier);
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(logFile, false));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// On ferme le fichier quoi qu'il advienne
				writer.close();
			} catch (Exception e) {
				System.out.println("Impossible de créer le fichier");
			}
		}
	}

	/**
	 * Permet de créer un fichier
	 * 
	 * @info sous fonction afin d'alléger le code
	 * @param nom_fichier
	 * @param texte
	 */
	private static void logTXT(String nom_fichier, String texte) {
		File logFile = new File(nom_fichier);
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(texte);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// On ferme le fichier quoi qu'il advienne
				writer.close();
			} catch (Exception e) {
				System.out.println("Impossible de créer le fichier");
			}
		}
	}
}
