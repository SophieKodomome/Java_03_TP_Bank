package operation;

import erreurList.erreurClasses.*;

public class Pret{
	double montantDuPret;
	Exception rentreeInsuffisante;
	Exception champNonRemplit;
	//Exception nonRemboursee;
	Transaction transaction= new Transaction();

	//FichierPret pretLogs;
	public Pret(double montant,double revenue) throws Exception{
//		if(this.pretLogs.checkPret()==true)	throw nonRemboursee;
//		{
			this.setMontantDuPret(montant,revenue);
//		}

	}

	public void setMontantDuPret(double montant,double revenue) throws Exception
	{
		if(revenue<=0||montant<=0) throw champNonRemplit;
		{
			if(revenue*12<montant) throw rentreeInsuffisante;
			{
				this.montantDuPret=montant;
//				this.savePret();
				this.transaction.setDepot(montant);
				this.transaction.saveTransaction();
			}
		}
	}

	public Transaction getTransaction(){
		return this.transaction;
	}

//	public void savePret() throws Exception{
//		this.pretLogs= new FichierPret(this);
//	}


}