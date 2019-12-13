package sn.esmt.proxibank.domaine;

public enum CategorieCompte {

	COURANT("COURANT"),
	EPARGNE("EPARGNE");
	
	private String categorieCompte;
	 
	  CategorieCompte(String categorieCompte){
	    this.categorieCompte = categorieCompte;
	  }
	   
	  public String toString(){
	    return categorieCompte;
	  }	

}
