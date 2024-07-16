public class CadastroBikes
{
    private Bike []bikes;
    private int index;
    private int tam;   
    private int codigo;
    
    public CadastroBikes()
    {
        tam=10;
        bikes = new Bike[tam];
        index=0;
        codigo=1000;
    }  
    
    public boolean addBikes(String modelo){
        if (index < tam) {
            Bike bike = new Bike(codigo,modelo);
            bikes[index] = bike;
            index++;
            codigo++;
            return true;
        }
        else return false;
    }
    public void buscaBikeModelo(String modelo){
        boolean found=false;
        int soma=0;
        for(int i=0;i<index;i++){
            if(bikes[i].getModelo().equalsIgnoreCase(modelo)){
                modelo.toUpperCase().trim();
                System.out.println(bikes[i].toString()); 
                found=true;
                if(found==true)soma++;
            } 
        }
        if(found==true)System.out.print("Quantidade do modelo: "+soma+"\n");
        if(found==false)System.out.println("Nome não encontrado!");
    }
    public void totalUnidades() {
        int totalUnidadesDisponiveis = 0;
        for (int i = 0; i < index; i++) {
            totalUnidadesDisponiveis += bikes[i].getQntdDeUnidades();
        }
        System.out.println("Quantidade total de unidades disponíveis: " + totalUnidadesDisponiveis);
    }
    public Bike buscarBikeDisponivel(String modelo) {
        for (int i = 0; i < index; i++) {
            if (bikes[i].getModelo().equalsIgnoreCase(modelo) && bikes[i].getQntdDeUnidades() > 0) {
                return bikes[i];
            }
        }
        return null;
    }
    
    public void mostrarBikes(){
        for(int i=0;i<index;i++){
            System.out.println(bikes[i].toString());
        }
    }
    }

