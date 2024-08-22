package App;

public class CadastroMembro {
    private Membro[] membros;
    private int index;
    private int tam;
    private int matricula;

    public CadastroMembro() {
        tam = 10;
        membros = new Membro[tam];
        index = 0;
        matricula = 1;
    }

    public boolean addMembro(String nome, String cidade) {
        if (index < tam) {
            nome = nome.toUpperCase().trim();
            cidade = cidade.toUpperCase().trim();

            Membro membro = new Membro(matricula, nome, cidade);
            membros[index] = membro;
            index++;
            matricula++;
            return true;
        } else
            return false;
    }

    public void buscaMembroNome(String nome) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (membros[i].getNome().equalsIgnoreCase(nome)) {
                nome.toUpperCase().trim();
                System.out.println(membros[i].toString());
                found = true;
                break;
            }
        }
        if (found == false)
            System.out.println("Nome não encontrado!");
    }

    public Membro buscaMembroMatricula(int matricula) {
        for (int i = 0; i < index; i++) {
            if (membros[i].getMatricula() == matricula) {
                return membros[i];
            }
        }
        return null;
    }

    public void mostrarMembros() {
        for (int i = 0; i < index; i++) {
            System.out.println(membros[i].toString());
        }
    }
}
