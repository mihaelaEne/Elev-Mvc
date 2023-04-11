package controllers;

import model.Elev;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ElevControllerTest {

    @Test
    public void testFindByNrMatricol(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,111);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,222);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,333);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,444);
        elevs.add(e4);

        ElevController elevController=new ElevController(elevs);
        assertEquals(01,elevController.findByNrMatricol(01).getNrMatricol());
    }

    @Test
    public void testFindByNume(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,111);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,222);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,333);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,444);
        elevs.add(e4);

        ElevController elevController=new ElevController(elevs);
        assertEquals("nume1",elevController.findByNume("nume1").getNume());
    }

    @Test
    public void testFindWithoutNume(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,111);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,222);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,333);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,444);
        elevs.add(e4);

        ElevController elevController=new ElevController(elevs);
        assertNull(elevController.findByNume("ionel"));
    }
    @Test
    public void testFindWithoutNrMatricol(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,111);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,222);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,333);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,444);
        elevs.add(e4);

        ElevController elevController=new ElevController(elevs);
        assertNull(elevController.findByNrMatricol(500));
    }

    @Test
    public void testUpdate(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,111);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,222);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,333);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,444);
        elevs.add(e4);

        ElevController elevController=new ElevController(elevs);
        Elev eNou=new Elev(01,"nume1","prenume1",99,999);
        elevController.update(eNou);


        assertEquals(99,elevController.findByNrMatricol(01).getVarsta());
        assertEquals(999,elevController.findByNrMatricol(01).getClasa());

    }
    @Test
    public void testAdd(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,111);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,222);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,333);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,444);

        ElevController elevController=new ElevController(elevs);
        elevController.addElev(e4);
        assertNotNull(elevController.findByNrMatricol(04));
    }

    @Test
    public void testRemove(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,111);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,222);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,333);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,444);
        elevs.add(e4);

        ElevController elevController=new ElevController(elevs);
        elevController.removeElev(e4);

        assertEquals(null, elevController.findByNrMatricol(04));

    }


    @Test
    public void testClasaX(){
        ArrayList<Elev> elevs=new ArrayList();
        Elev e1=new Elev(01,"nume1","prenume1",11,5);
        elevs.add(e1);
        Elev e2=new Elev(02,"nume2","prenume2",22,5);
        elevs.add(e2);
        Elev e3=new Elev(03,"nume3","prenume3",33,5);
        elevs.add(e3);
        Elev e4=new Elev(04,"nume4","prenume4",44,2);
        elevs.add(e4);

        ElevController elevController=new ElevController(elevs);
        ArrayList<Elev> eleviCls=elevController.eleviInClasa(5);

        for(int i=0;i<eleviCls.size();i++){

            assertEquals(5,eleviCls.get(i).getClasa());
        }



    }
}
