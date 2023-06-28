package sauvegarde;

import operation.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FichierCompte
{
	public FichierCompte(){}
	public FichierCompte(Retrait r){
		try{
			File fichier = new File("C:/Users/Pyvas/OneDrive/Documents/C-ITU-Files/ITU-S2-04-Java/Java-TP-Banque/Logs/retrait.txt");
			fichier.createNewFile();
			FileWriter ecritureFichier= new FileWriter(fichier);
			ecritureFichier.write("Retrait:" + Double.toString(r.getMontant()));
			ecritureFichier.close();
		}
		catch(IOException erreurFichier){
			erreurFichier.printStackTrace();
		}
	}
}