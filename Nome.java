package sistemaagenda;

public class Nome {
	

	    private String primeiroNome;
	    private String sobrenome;

	    public Nome(String primeiroNome, String sobrenome) {
	        this.primeiroNome = primeiroNome;
	        this.sobrenome = sobrenome;
	    }

	    public String getPrimeiroNome() {
	        return primeiroNome;
	    }

	    public String getSobrenome() {
	        return sobrenome;
	    }

	    @Override
	    public String toString() {
	        return primeiroNome + " " + sobrenome;
	    }
	}

