package sn.esmt.proxibank.domaine;

public enum StatutTransaction {

	BLOQUEE("BLOQUEE"),
	ENCLENCHEE("ENCLENCHEE"),
	EFFECTUEE("EFFECTUEE"),
	ANNULEE("ANNULEE");
	
	private String statutTransaction;
	 
	  StatutTransaction(String statutTransaction){
	    this.statutTransaction = statutTransaction;
	  }
	   
	  public String toString(){
	    return statutTransaction;
	  }	

}
