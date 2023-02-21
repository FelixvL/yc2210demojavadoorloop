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
	public Chat opslaan(Chat c) {
		return sammie.save(c);
	}

	public Chat findById(long l) {
		// TODO Auto-generated method stub
		return sammie.findById(l).get();
	}
	public Iterable<Chat> findAll(){
		return sammie.findAll();
	}
	public Chat findOne(long num) {
		// TODO Auto-generated method stub
		return sammie.findById(num).get();
	}
}



