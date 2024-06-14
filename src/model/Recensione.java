package model;
import java.time.LocalDate;

public class Recensione {
    private LocalDate data;
    private String nomeUtente;
    private int numeroStelle;
    private String testo;

    // costruttore che richiama i setter
    public Recensione(LocalDate data, String nomeUtente, int numeroStelle, String testo) {
        setData(data);
        setNomeUtente(nomeUtente);
        setNumeroStelle(numeroStelle);
        setTesto(testo);
    }

    // Setter per data
    public void setData(LocalDate data) {
        this.data = data;
    }

    // Getter per data
    public LocalDate getData() {
        return data;
    }

    // Setter per nomeUtente
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    // Getter per nomeUtente
    public String getNomeUtente() {
        return nomeUtente;
    }

    // Setter per numeroStelle con controllo numero valido stelle
    public void setNumeroStelle(int numeroStelle) {
        if (numeroStelle < 1 || numeroStelle > 5) {
            throw new IllegalArgumentException("Il numero di stelle deve essere compreso tra 1 e 5");
        }
        this.numeroStelle = numeroStelle;
    }

    // Getter per numeroStelle
    public int getNumeroStelle() {
        return numeroStelle;
    }

    // Setter per testo
    public void setTesto(String testo) {
        this.testo = testo;
    }

    // Getter per testo
    public String getTesto() {
        return testo;
    }

    @Override
    public String toString() {
        return "Nuova recensione inserita in data: " + data +
                ", da: '" + nomeUtente + '\'' +
                ", " + numeroStelle + " stelle" +
                ", testo='" + testo + '\'' +
                '.';
    }
}


