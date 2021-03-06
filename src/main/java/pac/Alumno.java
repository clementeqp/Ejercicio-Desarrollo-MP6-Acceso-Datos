package pac;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representara a un alumno.
 * @author Clemente Quintana
 */


public class Alumno implements Serializable {
    //Atributos
    private Long id;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String sexo;
    private Set <Modulo> modulos = new HashSet<>();


    //Constructores
    public Alumno(){
    }


    public Alumno(Long id, String nombre, String nacionalidad, int edad, String sexo, Set <Modulo> modulos){
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.sexo = sexo;
        this.modulos = modulos;
    }


    //Getters & setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Set<Modulo> getModulos() {
        return modulos;
    }
    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }


    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        sb.append(" nombre: ").append(nombre);
        sb.append(", nacionalidad: ").append(nacionalidad);
        sb.append(", edad: ").append(edad);
        sb.append(", sexo: ").append(sexo);
        sb.append(", modulos: ").append(modulos.size());

        return sb.toString();
    }
}
