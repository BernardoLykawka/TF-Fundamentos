import java.util.Scanner;

public class Clube
{
    private Scanner in = new Scanner(System.in);
    private int opcao, opcmodelo,matricula;
    private String nome, cidade,modelo;
    private CadastroMembro cm;
    private CadastroBikes cb;
    
    public Clube(){
        opcao=0;
        nome="";
        cidade="";
        modelo="";
        opcmodelo=-1;
        matricula=-1;
        cm = new CadastroMembro();
        cb = new CadastroBikes();
    }

    public void perguntaMenu()
    {
        System.out.println("\n[1] Incluir Membro");
        System.out.println("[2] Mostrar membros");
        System.out.println("[3] Pesquisar membro por nome");
        System.out.println("[4] Incluir bicicletas");
        System.out.println("[5] Mostrar bicicletas");
        System.out.println("[6] Pesquisar bicicletas por modelo");
        System.out.println("[7] Emprestar bicicleta");
        System.out.println("[8] Devolver bicicleta");
        System.out.println("[9] Quantidade total de unidades disponiveis");
        System.out.println("[10] Sair do programa");
    }
    
    public void acoes(){
        while(opcao!=10){
            perguntaMenu();
            opcao = in.nextInt();
    
            switch(opcao){
                case 1:{
                    System.out.println("\f");
                
                    in.nextLine();
                    System.out.println("Qual o nome que deseja inserir?");
                    nome=in.nextLine();
                    System.out.println("Qual a cidade do titular da conta?");
                    cidade=in.nextLine();
                    cm.addMembro(nome,cidade);
                    break;
                }
                case 2:{
                    System.out.println("\f");
                    cm.mostrarMembros();
                    break;
                }
                case 3:{
                    in.nextLine();
                    System.out.println("\fDigite o nome:");
                    nome=in.nextLine();
                    cm.buscaMembroNome(nome);
                    break;
                }
                case 4: {
                    in.nextLine();
                    System.out.println("\f");
                    modelo = escolherModelo();
                    cb.addBikes(modelo);
                    break;
                }
                case 5:{
                    System.out.println("\f");
                    cb.mostrarBikes();
                    break;
                }
                case 6: {
                    System.out.println("\f");
                    modelo = escolherModelo();
                    cb.buscaBikeModelo(modelo);
                    break;
                }
                case 7: {
                    in.nextLine();
                    System.out.println("\fDigite a matrícula do membro que deseja emprestar a bicicleta:");
                    matricula = in.nextInt();
                    Membro membro = cm.buscaMembroMatricula(matricula);
                    if (membro != null) {
                        if (membro.getDadosBE() == null) {
                            System.out.println("Escolha o modelo da bicicleta para emprestar:");
                            modelo = escolherModelo();
                            Bike bike = cb.buscarBikeDisponivel(modelo);
                            if (bike != null && bike.emprestarBike()) {
                                membro.emprestarBike(bike);
                                System.out.println("Bicicleta emprestada com sucesso!");
                            } else {
                                System.out.println("Não foi possível emprestar a bicicleta. Verifique se há bicicletas disponíveis.");
                            }
                        } else {
                            System.out.println("O membro já possui uma bicicleta emprestada.");
                        }
                    } else {
                        System.out.println("Membro não encontrado.");
                    }
                    break;
                }
                case 8: {
                    in.nextLine();
                    System.out.println("\fDigite a matrícula do membro que deseja devolver a bicicleta:");
                    matricula = in.nextInt();
                    Membro membro = cm.buscaMembroMatricula(matricula);
                    if (membro != null && membro.getDadosBE() != null) {
                        membro.devolverBike();
                        System.out.println("Bicicleta devolvida com sucesso!");
                    } else {
                        System.out.println("Membro não encontrado ou não possui bicicleta para devolver.");
                    }
                    break;
                }
                case 9: {
                    cb.totalUnidades();
                    break;
                }                
                case 10:{
                    System.out.println("\fSaindo do programa...");
                    break;
                }
                default: System.out.println("Insira um número valido...");
                
            }
        }
    }
    
    public String escolherModelo() {
        while (true) {
            System.out.println("Escolha um modelo: ");
            System.out.println("\n[1] Bicicleta de passeio");
            System.out.println("[2] Bicicleta BMX");
            System.out.println("[3] Bicicleta Speed");
            System.out.println("[4] Bicicleta Elétrica");

            opcmodelo = in.nextInt();
            in.nextLine();  

            switch (opcmodelo) {
                case 1:
                    return "Bicicleta de passeio";
                case 2:
                    return "Bicicleta BMX";
                case 3:
                    return "Bicicleta Speed";
                case 4:
                    return "Bicicleta Elétrica";
                default:
                    System.out.println("Insira um número válido...");
            }
        }
    }
}
