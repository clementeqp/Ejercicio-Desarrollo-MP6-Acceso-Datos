package pac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        System.out.println("Conectando ...");
        // Creación de la sesión y cargar el fichero de configuracion
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

        // Abrimos la sesión
        Session session = sessionFactory.openSession();
        System.out.println("Conexion realizada ....");

        //Creacion de Modulos
        Modulo prog = new Modulo(null, "Programacion B","M03B");
        Modulo datos = new Modulo(null,"Acceso a Datos","M06");
        Modulo dam = new Modulo(null,"Desarrollo de aplicaciones moviles","M08");
        Modulo procesos = new Modulo(null, "Servicios y procesos","M09");


        //Introducimos los Modulos en la BD a traves de nuestro metodo insertarModulo

        insertarModulo(prog, session);
        insertarModulo(datos, session);
        insertarModulo(dam, session);
        insertarModulo(procesos, session);

        // Creamos el Profesor
        Profesor profe = new Profesor(null,"Alvaro", "Hombre");
        // Introducimos el profesor en la BD a traves de nuestro metodo insertarProfesor
        insertarProfesor(profe, session);

        //Asignamos a cada alumno sus modulos
        HashSet<Modulo> modulosJuan = new HashSet<>();
        modulosJuan.add(prog);
        modulosJuan.add(datos);
        modulosJuan.add(dam);
        modulosJuan.add(procesos);

        HashSet<Modulo> modulosPedro = new HashSet<>();
        modulosPedro.add(prog);
        modulosPedro.add(datos);
        modulosPedro.add(procesos);

        HashSet<Modulo> modulosMarta = new HashSet<>();
        modulosMarta.add(dam);
        modulosMarta.add(procesos);

        HashSet<Modulo> modulosCarla = new HashSet<>();
        modulosCarla.add(datos);
        modulosCarla.add(dam);
        modulosCarla.add(procesos);

        //Inserciones de alumnos
        insertarAlumno("Juan", "Espaniola", 26,"Hombre", modulosJuan, session);
        insertarAlumno("Pedro", "Andorrana", 21,"Hombre", modulosPedro, session);
        insertarAlumno("Marta", "Espaniola", 19,"Mujer", modulosMarta, session);
        insertarAlumno("Carla", "Francesa", 35,"Mujer", modulosCarla, session);

        //Cerramos la sesión y el Factory
        session.close();
        sessionFactory.close();
    }

    /**
     * Metodo para introducir modulos
     * @param modulo
     * @param session
     */
    private static void insertarModulo(Modulo modulo, Session session) {
        session.beginTransaction();
        session.save(modulo);
        session.getTransaction().commit();

        System.out.println("Insert into modulo," + modulo);

    }

    /**
     * Metodo para introducir profesores
     * @param profesor
     * @param session
     */
    private static void insertarProfesor(Profesor profesor, Session session) {
        session.beginTransaction();
        session.save(profesor);
        session.getTransaction().commit();

        System.out.println("Insert into profesor," + profesor);


    }

    /**
     * Metodo para introducir alumnos
     * @param nombre
     * @param nacionalidad
     * @param edad
     * @param sexo
     * @param modulos
     * @param session
     */
    private static void insertarAlumno (String nombre, String nacionalidad, int edad, String sexo, Set<Modulo> modulos , Session session){
        Alumno a = new Alumno();
        a.setNombre(nombre);
        a.setNacionalidad(nacionalidad);
        a.setEdad(edad);
        a.setSexo(sexo);
        a.setModulos(modulos);
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        System.out.println("Insert into alumno," + a);
    }
}
