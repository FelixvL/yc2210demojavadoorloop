package nl.capital.yc2209fsvrijdag.domein;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chat {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	long id;

	String onderwerp;
	String text;
	String afzender;
	String ontvanger;
	LocalDateTime verzonden;
	int priority;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOnderwerp() {
		return onderwerp;
	}
	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAfzender() {
		return afzender;
	}
	public void setAfzender(String afzender) {
		this.afzender = afzender;
	}
	public String getOntvanger() {
		return ontvanger;
	}
	public void setOntvanger(String ontvanger) {
		this.ontvanger = ontvanger;
	}
	public LocalDateTime getVerzonden() {
		return verzonden;
	}
	public void setVerzonden(LocalDateTime verzonden) {
		this.verzonden = verzonden;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
	
	
	
}
