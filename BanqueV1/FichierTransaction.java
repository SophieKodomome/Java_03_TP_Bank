package sauvegarde;

import operation.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FichierTransaction{
	File fichier= new File("C:/Users/Pyvas/OneDrive/Documents/C-ITU-Files/ITU-S2-04-Java/Java-TP-Banque/Logs/solde1.txt");

	public FichierTransaction(){}

	public FichierTransaction(Transaction t)
	{	
		try{
			FileWriter ecritureFichier= new FileWriter(fichier,true);
			ecritureFichier.write("Retrait: " + Double.toString(t.getRetrait())+"\n");
			ecritureFichier.write("Depot: " + Double.toString(t.getDepot())+"\n");
			ecritureFichier.write("Solde: " + Double.toString(t.getSolde())+"\n");
			ecritureFichier.write("Date: " + t.getTemps().getTime()+"\n");
			ecritureFichier.write("\n");
			ecritureFichier.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void effacerHistorique()
	{
		fichier.delete();
	}

}