package sn.esmt.proxibank.domaine;

public enum StatutCompte {

	BLOQUE("BLOQUE"),
	DECOUVERT("DECOUVERT"),
	ENDORMI("ENDORMI"),
	OUVERT("OUVERT"),
	ARCHIVE("ARCHIVE");
	
	private String statutCompte;
	 
	  StatutCompte(String statutCompte){
	    this.statutCompte = statutCompte;
	  }
	   
	  public String toString(){
	    return statutCompte;
	  }	

}
