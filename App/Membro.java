package App;
public class Membro {
    private int matricula;
    private String nome;
    private String cidade;
    private Bike dadosBE;
    //construtor
    public Membro(int matricula, String nome, String cidade) {
        this.matricula = matricula;
        this.nome = nome;
        this.cidade = cidade;
        this.dadosBE = null;
    }
    
    // Getters and setters
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public Bike getDadosBE() { return dadosBE; }
    public void setDadosBE(Bike bike) { this.dadosBE = bike; }

    public String toString(){
        if (dadosBE != null) {
            return "Matricula: " + matricula + "\nNome: " + nome + "\nCidade: " + cidade + "\nDados Bike: " + dadosBE + "\n";
        } else {
            return "Matricula: " + matricula + "\nNome: " + nome + "\nCidade: " + cidade + "\nDados Bike: Nenhuma Bicicleta\n";
        }
    }
    //dados da Bicicleta quando mostra o membro
    public void emprestarBike(Bike bike) {
        this.dadosBE=bike;
    }
    public void devolverBike() {
        if (this.dadosBE != null) {
            this.dadosBE.devolverBike();
            this.dadosBE = null;
        }
    }
}