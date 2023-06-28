package operation;

import java.util.*;

import sauvegarde.*;

public class Transaction{
	double depot;
	double retrait;
	Exception erreurNegatif;
	Exception erreurCompteVide;
	static double solde;
	static double soldeinitial=100000;
	FichierTransaction transaciontlogs;
	GregorianCalendar date= new GregorianCalendar();

	public Transaction(){}

	public void setRetrait(double montant) throws Exception{
		if(montant<0) throw erreurNegatif;{
			this.retrait=montant;
			this.depot=0;		
		}
	}

	public void setDepot(double montant) throws Exception{
		if(montant<0) throw erreurNegatif;{
			this.retrait=0;
			this.depot=montant;
		}
	}
	public void saveTransaction() throws Exception{
		this.transaciontlogs= new FichierTransaction(this);
	}

	public void deleteTransaction()
	{
		this.transaciontlogs.effacerHistorique();
	}

	public double getRetrait()
	{
		return this.retrait;
	}

	public double getDepot()
	{
		return this.depot;
	}
	public double getSolde()
	{
		if(this.solde==0)
		{
			this.solde=this.soldeinitial;
		}
		else
		{
			this.solde=this.solde;			
		}
		this.solde=solde+this.depot-this.retrait;
		return this.solde;	
	}

	public GregorianCalendar getTemps(){
		return this.date;
	}
}