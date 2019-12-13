package sn.esmt.proxibank.domaine;

public enum StatutUser {


	ADMIN("ADMIN"),
	CONSEILLER("CONSEILLER");
	
	private String statutUser;
	 
	  StatutUser(String statutUser){
	    this.statutUser = statutUser;
	  }
	   
	  public String toString(){
	    return statutUser;
	  }	

}
