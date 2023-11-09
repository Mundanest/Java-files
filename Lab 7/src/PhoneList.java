/*
  PhoneList — a model class representing a list of phones. There is 
  an addPhone method to add a phone to the list, a getAllPhones to get a list of all
  phones, and a getBestPhones method to get a list of just the ‘best’ phones.
 */


import java.util.*;

public class PhoneList {
	private final List<Phone> allPhones = new ArrayList<>();
	private final Set<Phone> bestPhones = new HashSet<>();
	
	/*
	 * Adds a phone to the list.
	 */
	public void addPhone(Phone phone) {
		allPhones.add(phone);
		
		// remove from bestPhones if dominated by the new phone
		Iterator<Phone> iter = bestPhones.iterator();
		while(iter.hasNext()) {
			Phone other = iter.next();
			if(phone.dominates(other)) {
				iter.remove();
			}
		} 
		
		// only add the new phone to bestPhones if it's not dominated
		if(!phoneIsDominated(phone)) {
			bestPhones.add(phone);
		}
	}
	
	/*
	 * Determines whether a phone is dominated by any other phone.
	 */
	public boolean phoneIsDominated(Phone phone) {
		// only need to compare with the undominated phones
		for(Phone other : bestPhones) {
			if(other.dominates(phone)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Gets all phones. The list returned is unmodifiable.  
	 */
	public List<Phone> getAllPhones() {
		// : return an unmodifiable view of the list
		// Task 3.1:
		//return allPhones;
		return Collections.unmodifiableList(allPhones);
		//return allPhones;
	}
	
	/*
	 * Gets all phones which are not dominated by another phone. The
	 * collection returned is unmodifiable.  
	 */
	public Collection<Phone> getBestPhones() {
		// : return an unmodifiable view of the set
		//Task 3.2:
		return Collections.unmodifiableSet(bestPhones);
		//return bestPhones;
		

	}
}
