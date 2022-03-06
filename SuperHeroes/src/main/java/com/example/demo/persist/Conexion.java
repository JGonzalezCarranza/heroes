package com.example.demo.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Entity;


public class Conexion {

  public void guardaLike(int id){
    SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(
        Heroe.class).buildSessionFactory();
    Session miSesion = miFactory.openSession();
    try{

      miSesion.beginTransaction();

      List<Heroe> heroes = miSesion.createQuery("from Heroe h1 where h1.ID = "+ id).list();

      if(heroes.size() == 0){
        miSesion.save(new Heroe(id, 1));
      } else {
        for (Heroe heroe : heroes) {
          if (heroe.getID() == id) {
            heroe.setLIKES(heroe.getLIKES()+1);
            miSesion.save(heroe);
          }
        }
      }
      miSesion.getTransaction().commit();
      System.out.println("Registro insertado");
    } finally {
      miSesion.close();
      miFactory.close();
    }
  }

}
