public class Bike {
    private int codigo;
    private String modelo;
    private int qntdDeUnidades;

    public Bike(int codigo, String modelo){
        this.codigo = codigo;
        this.modelo = modelo;
        this.qntdDeUnidades = 1; 
    }
    
    public int getCodigo(){ return codigo; }
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public String getModelo(){ return modelo; }
    public void setModelo(String modelo){ this.modelo = modelo; }
    public int getQntdDeUnidades(){ return qntdDeUnidades; }
    public void setQntdDeUnidades(int qntdDeUnidades){ this.qntdDeUnidades = qntdDeUnidades; }

    public String toString(){
        return "Codigo: " + codigo + "\nModelo: " + modelo + "\n";
    }

    public boolean emprestarBike() {
        if (qntdDeUnidades > 0) {
            qntdDeUnidades--;
            return true;
        }
        return false;
    }

    public void devolverBike() {
        qntdDeUnidades++;
    }
}