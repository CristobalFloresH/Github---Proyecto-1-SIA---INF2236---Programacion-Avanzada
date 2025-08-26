public class Bus{
  private int capacidad;
  private String patente;
  private String disponibilidad;
  private String tipo;
  private boolean[] asientosUsados;  

  //Contstructor
  public Bus(int capacidad, String patente,String disponibilidad, String tipo ){
    this.patente = patente;
    this.capacidad = capacidad;
    this.disponibilidad = disponibilidad;
    this.tipo = tipo;
    this.asientosUsados = new boolean[capacidad]; 
   }

  //Getter
    public String getPatente(){
        return patente;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public String getDisponibilidad(){
        return disponibilidad;
    }

    public String getTipo(){
        return tipo;
    }

    public boolean[] getAsientosUsados(){
        return asientosUsados;
    }

  //Setter
    public void setPatente(String patente){
        this.patente = patente;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
        this.asientosUsados = new boolean[capacidad]; 
    }

    public void setDisponibilidad(String disponibilidad){
        this.disponibilidad = disponibilidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}






