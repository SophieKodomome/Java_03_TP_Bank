package operation;

import java.util.*;

import sauvegarde.*;
import erreurclasses.*;

public class Transaction{
	double depot;
	double retrait;
	Exception erreurNegatif;
	NegativeValueException erreurCompteVide;
	static double solde;
	static double soldeinitial=100000;
	FichierTransaction transaciontlogs;
	GregorianCalendar date= new GregorianCalendar();

	public Transaction(){}


	public Transaction(double montant,boolean action) throws Exception,NegativeValueException{
		if(action==true){this.setRetrait(montant);}
		else{this.setDepot(montant);}
		this.setSolde();
		this.saveTransaction();
	}

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
	public void setSolde() throws NegativeValueException{
		if(this.solde==0)
		{
			this.solde=this.soldeinitial;
		}
		else
		{
			this.solde=this.solde;			
		}
		if(this.solde<=0) throw erreurCompteVide;
		{
			this.solde=this.solde+this.depot-this.retrait;
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
		return this.solde;	
	}

	public GregorianCalendar getTemps(){
		return this.date;
	}
}