package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.Date;

@Entity
public class Dijete extends Osoba{

	private Date datumRodjenja;
        
   
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

    
  
	
	
}
