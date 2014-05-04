package calculettePostFix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LogFile {
	private static final String ERREURS_FILENAME = "Erreurs.txt";
	private static final String RÉSULTATS_FILENAME = "Résultats.txt";
	
	public static void resTXT(String texte) {
		logTXT(RÉSULTATS_FILENAME, texte);
	}

	public static void errorsTXT(String texte) {
		logTXT(ERREURS_FILENAME, texte);
		// on affiche aussi à l'écran les erreurs logguées
		System.out.println("Erreur:" + texte);
	}

	public static void reinitFichier() {
		reinitFichier(RÉSULTATS_FILENAME);
		reinitFichier(ERREURS_FILENAME);
	}
	
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
	// sous fonction pour alléger le code
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
