package pac;

public class Modulo {
    //Atributos
    private Long id;
    private String nombre;
    private String codigo;

    //Constructor vacío
    public Modulo(){
    }

    //Constructor con todos los parámetros
    public Modulo (Long id,String nombre, String codigo){
        this.id = id;
        this.nombre=nombre;
        this.codigo=codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        sb.append("nombre: ").append(nombre);
        sb.append(", codigo: ").append(codigo);

        return sb.toString();
    }
}
