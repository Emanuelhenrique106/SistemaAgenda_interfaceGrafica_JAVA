package sistemaagenda;

public class Email {
	


	    private String endereco;

	    public Email(String endereco) {
	        this.endereco = endereco;
	    }

	    public String getEndereco() {
	        return endereco;
	    }

	    @Override
	    public String toString() {
	        return endereco;
	    }
	}


