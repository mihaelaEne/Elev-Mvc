package controllers;

import model.Elev;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ElevController {
private ArrayList<Elev>elevs=new ArrayList();

    public ElevController(ArrayList<Elev> elevs) {
        this.elevs = elevs;

    }

    public ElevController(){
        this.elevs=new ArrayList<>();
        this.load();
    }
    public void load(){
        try{
            File file=new File("C:\\mycode\\OOP\\incapsularea\\Elev\\src\\data\\elev.txt");
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                Elev elev=new Elev(scanner.nextLine());
                this.elevs.add(elev);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void afisareElev(){
        for(int i=0; i<elevs.size(); i++){
            System.out.println(this.elevs.get(i).descriereElev());
            System.out.println("\n");
        }
    }


    public void addElev(Elev elev){this.elevs.add(elev);}
    public void removeElev(Elev elev){this.elevs.remove(elev);}

    public Elev findByNrMatricol(int nrMatricol){
        for(int i=0; i<elevs.size(); i++){
            if(elevs.get(i).getNrMatricol()==nrMatricol){
                return elevs.get(i);
            }
        }
        return null;
    }

    public Elev findByNume(String nume){
        for(int i=0; i<elevs.size(); i++){
            if(elevs.get(i).getNume().equals(nume)){
                return elevs.get(i);
            }
        }
        return null;
    }

    public void update(Elev elev){
        Elev deUpdatat=findByNrMatricol(elev.getNrMatricol());
        if(elev.getVarsta()!=0){
            deUpdatat.setVarsta(elev.getVarsta());
        }
        if(elev.getClasa()!=0){
            deUpdatat.setClasa(elev.getClasa() );
        }
    }

    //todo:toti elevii dintr-o clasa

    public ArrayList<Elev> eleviInClasa(int clasa) {
        ArrayList<Elev>elevs1=new ArrayList<>();
        for(int i=0; i<elevs.size(); i++){
            if(elevs.get(i).getClasa()==clasa){
                elevs1.add(elevs.get(i));
            }
        }
        return  elevs1;
    }




}
