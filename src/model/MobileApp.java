package model;

import java.util.ArrayList;

public class MobileApp {
    private String nome;
    private String sistemaOperativo;
    private float prezzo;
    private ArrayList<Recensione> elencoRecensioni;
    private float ricavoTotale;

    // costruttore della classe: inizializza gli attributi passati e inizializza gli altri
    public MobileApp(String nome, String sistemaOperativo, float prezzo) {
        setNome(nome);
        setSistemaOperativo(sistemaOperativo);
        setPrezzo(prezzo);

        this.elencoRecensioni = new ArrayList<>();
        this.ricavoTotale = 0;
    }

    // incrementa il ricavoTotale del valore del prezzo
    public void download() {
        this.ricavoTotale += prezzo;
    }

    // incrementa il ricavoTotale del valore del prezzo * n download
    public void download(int numeroDownload) {
        this.ricavoTotale += prezzo * numeroDownload;
    }

    // l'app riceve una nuova recensione
    public void riceviRecensione(Recensione recensione) {
        elencoRecensioni.add(recensione);
    }

    // restituisce la media delle recensioni ricevute finora (nr stelle)
    public float valutazioneMedia() {
        if (elencoRecensioni.isEmpty()) {
            return 0; // Se non ci sono recensioni presenti vuol dire che è 0
        }
        int totaleStelle = 0;
        for (Recensione recensione : elencoRecensioni) {
            totaleStelle += recensione.getNumeroStelle();
        }
        return (float) totaleStelle / elencoRecensioni.size();
    }

    // Getter e setter per nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome non può essere vuoto");
        }
        this.nome = nome;
    }

    // Getter e setter per sistemaOperativo
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        if (sistemaOperativo == null || sistemaOperativo.trim().isEmpty()) {
            throw new IllegalArgumentException("Il sistema operativo non può essere vuoto");
        }
        this.sistemaOperativo = sistemaOperativo;
    }

    // Getter e setter prezzo
    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero");
        }
        this.prezzo = prezzo;
    }

    // getter ricavo totale, non serve il setter perchè lo setto già nel cotruttore e sopra ho due metodi per modificarne il valore
    public float getRicavoTotale() {
        return ricavoTotale;
    }

    // Getter per elenco recensioni
    public ArrayList<Recensione> getElencoRecensioni() {
        return elencoRecensioni;
    }
}
