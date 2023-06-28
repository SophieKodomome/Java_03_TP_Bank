package operation;

import sauvegarde.*;

public class Retrait{
	double montant;
	FichierRetrait fichierRetrait;
	public Retrait(){}
	public Retrait(Double m) throws Exception{
		this.setMontant(m);
	}

	private void setMontant(Double m) throws Exception{
		Exception erreurNegatif= new Exception();

		if(m<8) throw erreurNegatif;
		{
			this.montant=m;
			this.fichierRetrait= new FichierRetrait(this);
			System.out.println("it worked");
		}
	}

	public double getMontant(){
		return this.montant;
	}
	public String getMontantString(){
		return Double.toString(this.montant);
	}


}