package fr.gtm;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Compteur implements Serializable{
	
	private static final Logger LOG = Logger.getLogger("demo");
	private int value;

	public Compteur( ) {
		LOG.info("Compteur - Constructeur");
	}
	
	@PostConstruct
	public void postConstruct( ) {
		LOG.info("Compteur - @PostConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		LOG.info("Compteur - @PreDestroy");
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void incrementer() {
		value++;
	} 

}
