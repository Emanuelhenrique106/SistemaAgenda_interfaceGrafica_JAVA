package sistemaagenda;

	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.format.DateTimeParseException;

	public class DataNascimento {
	    private LocalDate data;
	    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    public DataNascimento(String dataStr) {
	        try {
	            this.data = LocalDate.parse(dataStr, FORMAT);
	        } catch (DateTimeParseException e) {
	            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
	            this.data = null;
	        }
	    }

	    public String getFormatada() {
	        if (data == null) return "";
	        return data.format(FORMAT);
	    }

	    @Override
	    public String toString() {
	        return getFormatada();
	    }
	}

	
	

