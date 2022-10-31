package nl.capital.yc2209fsvrijdag.persist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.capital.yc2209fsvrijdag.domein.Chat;

@Service
public class ChatService {
	@Autowired
	ChatRepository sammie;
	
	
	public void zomaar() {
		System.out.println("zomaar in de service");
		Chat c = new Chat();
		c.setAfzender("Piet");
		sammie.save(c);
		
		
		
	}

}



