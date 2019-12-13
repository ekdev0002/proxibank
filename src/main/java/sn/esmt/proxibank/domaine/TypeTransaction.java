package sn.esmt.proxibank.domaine;

public enum TypeTransaction {


	DEBIT("DEBIT"),
	CREDIT("CREDIT");
	
	private String typetransaction;
	 
	  TypeTransaction(String typetransaction){
	    this.typetransaction = typetransaction;
	  }
	   
	  public String toString(){
	    return typetransaction;
	  }	

}
