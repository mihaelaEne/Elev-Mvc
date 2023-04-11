package model;

public class Elev {
    private int nrMatricol;
    private String nume;
    private String prenume;
    private int varsta;
    private int clasa;

    public Elev(){}
    public Elev (int nrMatricol, String nume,String prenume, int varsta, int clasa){
        this.nrMatricol=nrMatricol;
        this.nume=nume;
        this.prenume=prenume;
        this.varsta=varsta;
        this.clasa=clasa;
    }

    public Elev(String prop){
        String [] split =prop.split(",");
        this.nrMatricol=Integer.parseInt(split[0]);
        this.nume=split[1];
        this.prenume=split[2];
        this.varsta=Integer.parseInt(split[3]);
        this.clasa=Integer.parseInt(split[4]);
    }

    public int getNrMatricol() {
        return nrMatricol;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getClasa() {
        return clasa;
    }

    public void setClasa(int clasa) {
        this.clasa = clasa;
    }

    public String descriereElev(){
        String text="";
        text+="Nr matricol este: "+this.nrMatricol+"\n";
        text+="Nume: "+this.nume+"\n";
        text+="Prenume: "+this.prenume+"\n";
        text+="Vasta: "+this.varsta+"\n";
        text+="Clasa: "+this.clasa;

        return text;
    }
}
