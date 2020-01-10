package ro.ase.translatorApp.entities.nullObject;

import ro.ase.translatorApp.searchedHistory.Language;

public class NonNullList extends List {

	public NonNullList(Language lang) {
	      this.lang = lang;		
	   }
		@Override
	   public Language limba() {
	      return this.lang ;
	   }
		@Override
		   public boolean isNull() {
		      return true ;
		   }
}
