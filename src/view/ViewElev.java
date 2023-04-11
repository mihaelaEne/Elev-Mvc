package view;

import controllers.ElevController;
import model.Elev;

import java.util.Scanner;

public class ViewElev {

    private ElevController elevController;
    private Scanner scanner;


    public ViewElev(){
        elevController=new ElevController();
        scanner=new Scanner(System.in);
        play();
    }


    public void meniu(){
        System.out.println("1-afis toti elevii");
        System.out.println("2-adauga un elev");
        System.out.println("3-eleimina un elev");
        System.out.println("4-modifica un elev ");
    }

    public void play(){
        elevController.load();
        int alegere=0;
        boolean running=true;
        while(running){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:elevController.afisareElev();
                break;
                case 2:adaugareElev();
                break;
                case 3: stergereElev();
                break;
                case 4: updateElev();
                break;
                default:
                    System.out.println("Alegere gresita");
                    break;
            }
        }

    }



    private void adaugareElev(){
        System.out.println("Introduceti nr matricol: ");
        int nrMatricol=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti numele ");
        String nume=scanner.nextLine();
        System.out.println("Introduceti prenumele ");
        String prenume=scanner.nextLine();
        System.out.println("Introduceti varsta");
        int varsta=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti clasa");
        int clasa=Integer.parseInt(scanner.nextLine());



        Elev elev=elevController.findByNrMatricol(nrMatricol);
        if(elev==null){
            Elev eNou=new Elev(nrMatricol,nume,prenume,varsta,clasa);
            elevController.addElev(eNou);
        }else{
            System.out.println("Elevul exista deja ");
        }

    }


    private void stergereElev(){
        System.out.println("Introduceti numele elevului ");
        String nume=scanner.nextLine();

        Elev elev=elevController.findByNume(nume);
        if(elev==null){
            System.out.println("Nu exista un elev cu numele introdus ");
        }else{
            elevController.removeElev(elev);
            System.out.println("Elevul a fost sters ");
        }
    }
    private void updateElev(){
        System.out.println("Introduceti numele elevului ");
        String nume=scanner.nextLine();

        Elev elev=elevController.findByNume(nume);

        if(elev==null){
            System.out.println("Nu exista un elev cu numele introdus ");
        }else {
            System.out.println("Introduceti cu virgula ce se modifica:varsta,clasa ");
            String [] upd=scanner.nextLine().split(",");
            Elev nou=new Elev();

            nou.setNume(elev.getNume());

            for(int i=0; i<upd.length; i++){
                switch (upd[i]){
                    case "varsta":
                        System.out.println("Intr varsta:");
                        int varsta=Integer.parseInt(scanner.nextLine());
                        break;
                    case "clasa":
                        System.out.println("Intr clasa:");
                        int clasa=Integer.parseInt(scanner.nextLine());
                        break;

                    default:
                        System.out.println("Alegere gresita");
                }
            }
            elevController.update(nou);
            }



        }



    }



