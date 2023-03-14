public class Libro {
    private String titolo;
    private int pagine;
    private String autore;
    private String editore;

    public Libro(String titolo, int pagine, String autore, String editore) {
        if(!isBookValid(titolo, pagine, autore, editore)){
            throw new IllegalArgumentException("C'è stato un errore nella creazione del tuo libro. Assicurati che il " +
                    "tuo libro abbia almeno 1 pagina, e che il nome dell'autore, editore, e titolo siano almeno di 1 " +
                    "carattere.");
        }
        this.titolo = titolo;
        this.pagine = pagine;
        this.autore = autore;
        this.editore = editore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        if(titolo.length() < 1){
            throw new IllegalArgumentException("Il titolo deve contenere almeno 1 carattere");
        }
        this.titolo = titolo;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        if(pagine < 1){
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di 1");
        }
        this.pagine = pagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        if(autore.length() < 1){
            throw new IllegalArgumentException("Il nome dell'autore deve contenere almeno 1 carattere.");
        }
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        if(editore.length() < 1){
            throw new IllegalArgumentException("Il nome dell'editore deve contenere almeno 1 carattere.");
        }
        this.editore = editore;
    }

    protected boolean isTitleValid(String titolo){
        return titolo.length() > 0;
    }

    protected boolean isAuthorValid(String autore){
        return autore.length() > 0;
    }

    protected boolean isEditorValid(String editore){
        return editore.length() > 0;
    }

    protected boolean isPagesValid(int pagine){
        return pagine > 0;
    }

    protected boolean isBookValid(String titolo, int pagine, String autore, String editore){
        return isAuthorValid(autore) && isEditorValid(editore) && isPagesValid(pagine) && isTitleValid(titolo);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", pagine=" + pagine +
                ", autore='" + autore + '\'' +
                ", editore='" + editore + '\'' +
                '}';
    }
}
