package fr.gtm;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 10)
public class Compteur {
	
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
	
	@Remove
	public void remove() {
	} 
	
}
