package sn.esmt.proxibank.domaine;

public enum TypePiece {

	PASSPORT("PASSPORT"),
	CNI("CNI"),
	PERMIS_CONDUITE("PERMIS_CONDUITE");
	
	private String categorieCompte;
	 
	  TypePiece(String categorieCompte){
	    this.categorieCompte = categorieCompte;
	  }
	   
	  public String toString(){
	    return categorieCompte;
	  }	

}
