package pac;



import java.io.Serializable;

public class Profesor implements Serializable {
    //Atributos
    private Long id;
    private String nombre;
    private String sexo;

    //Constructor vacío
    public Profesor(){
    }

    //Constructor con todos los parámetros
    public Profesor (Long id, String nombre, String sexo){
        this.id=id;
        this.nombre=nombre;
        this.sexo=sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    //toString
    @Override
    public String toString() {
        String sb = " " + "nombre: " + nombre +
                ", sexo: " + sexo;

        return sb;
    }
}
