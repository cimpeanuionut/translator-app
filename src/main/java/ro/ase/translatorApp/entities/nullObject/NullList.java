package ro.ase.translatorApp.entities.nullObject;

import ro.ase.translatorApp.searchedHistory.Language;

public class NullList extends List {
	@Override
	   public Language limba() {      
		return Language.EN ;
	   }
	@Override
	   public boolean isNull() {      
		return true;
	   }
}
