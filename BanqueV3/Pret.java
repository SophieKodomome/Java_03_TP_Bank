package operation;

import erreurclasses.*;

public class Pret{
	double montantDuPret;
	Exception rentreeInsuffisante;
	//Exception nonRemboursee;
	Transaction transaction= new Transaction();

	//FichierPret pretLogs;
	public Pret(double montant,double revenue) throws Exception{
//		if(this.pretLogs.checkPret()==true)	throw nonRemboursee;
//		{
			this.setMontantDuPret(montant,revenue);
//		}

	}

	public void setMontantDuPret(double montant,double revenue) throws Exception{
			if(revenue*12<montant) throw rentreeInsuffisante;
			{
				this.montantDuPret=montant;
//				this.savePret();
				this.transaction.setDepot(montant);
					this.transaction.saveTransaction();
			}
	}

	public Transaction getTransaction(){
		return this.transaction;
	}

//	public void savePret() throws Exception{
//		this.pretLogs= new FichierPret(this);
//	}


}