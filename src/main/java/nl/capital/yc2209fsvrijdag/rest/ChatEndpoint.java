package nl.capital.yc2209fsvrijdag.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.capital.yc2209fsvrijdag.domein.Chat;
import nl.capital.yc2209fsvrijdag.persist.ChatService;

@RestController
public class ChatEndpoint {
	@Autowired
	ChatService map;

	@GetMapping("/ffproberen")
	public void proberen() {
		System.out.println("hij doet het");
		map.zomaar();
	}
	@GetMapping("/anders")
	public String proberen2() {
		System.out.println("hij doet het2");
		return "hoi <input>";
	}
	@GetMapping("/derde")
	public Chat proberen3() {
		Chat c = new Chat();
		c.setAfzender("Marije");
		c.setText("Dit is mijn bedrag");
		System.out.println("derde");
		return c;
	}
	@PostMapping("/ffproberen6/{mijnvar}")
	public void proberen6( @PathVariable("mijnvar")  String mijnvar2, @RequestParam("go") int go, @RequestBody Chat c ) {
		System.out.println("hij doet het" + mijnvar2);
		System.out.println("hij doet het --" + go);
		System.out.println("derde "+c.getText());
	}
	@PostMapping("/ditgaanweopslaan")
	public Chat postIets(@RequestBody Chat chatje) {
		return map.opslaan(chatje);
	}
	
	@GetMapping("/EenHeleLijst")
    public ResponseEntity<Iterable<Chat>> list() {
        return ResponseEntity.ok(this.map.findAll());
    }
	@GetMapping("/specifieke/{id}")
    public ResponseEntity<Chat> eentje(@PathVariable("id") long num) {
        return ResponseEntity.ok(this.map.findOne(num));
    }
	
	
}
