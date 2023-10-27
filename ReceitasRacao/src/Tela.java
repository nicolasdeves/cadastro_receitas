import java.util.ArrayList;

public class Tela {
    private DAO dados;
    private String menu = "==================================\n" +
            "            MENU PRINCIPAL\n" +
            "==================================\n" +
            "\n" +
            "1 - Listar receitas\n" +
            "   \n" +
            "2 - Adicionar receita\n" +
            "   \n" +
            "3 - Editar receita\n" +
            "\n" +
            "4 - Excluir receita\n" +
            "\n" +
            "5 - Listar ingredientes\n" +
            "\n" +
            "6 - Adicionar ingrediente\n" +
            "\n" +
            "7 - Excluir ingrediente\n" +
            "\n" +
            "8 - Sair\n" +
            "\n" +
            "==================================";

    public Tela(DAO dados){
        this.dados = dados;
    }

    public void exibir(){
        int opcao;

        while(true){
            opcao = Entrada.leiaInt(menu);

            if(opcao==1){
                //listar todas receitas
                //l(receita.getCodigo_receita()+";"+receita.getNome_receira()+";"+receita.getIngredientes()+";"+receita.getQuant_ingrediente());
                ArrayList<String> receitas = dados.getReceitas();
                System.out.println("RECEITAS: ");
                for(int i=0; i<receitas.size(); i++){
                    String receitaDividida[] = receitas.get(i).split(";");
                    //0;RAÇÃO ANIMAL;[ARROZ, SOJA];[10.0, 2.0]
                    System.out.println("===================================");
                    System.out.println("Código: "+receitaDividida[0]+" | "+receitaDividida[1]);

                    String ingredientes = receitaDividida[2];
                    ingredientes = ingredientes.substring(1, ingredientes.length() - 1);
                    String[] ingredientesSeparados = ingredientes.split(", ");

                    String quantIngredientes = receitaDividida[3];
                    quantIngredientes = quantIngredientes.substring(1, quantIngredientes.length() - 1);
                    String[] quantIngredientesSeparados = quantIngredientes.split(", ");


                    for (int y=0; y<ingredientesSeparados.length;y++){
                        System.out.println(ingredientesSeparados[y] + " " + quantIngredientesSeparados[y] + "kg");
                    }
                    System.out.println("===================================");
                }





            }
            else if(opcao==2){
                //adicionar receita
                String nome = Entrada.leiaString("Qual nome da receita?").toUpperCase();

                boolean continuar = true;
                ArrayList<String> cadastroIngredientes = new ArrayList<String>();
                ArrayList<Double> cadastroQuantIngredientes = new ArrayList<Double>();

                while(continuar){
                    cadastroIngredientes.add(Entrada.leiaString("Qual ingrediente?").toUpperCase());
                    cadastroQuantIngredientes.add(Entrada.leiaDouble("Qual sua quantidade em kg?"));
                    continuar = Entrada.leiaBoolean("Deseja adicionar mais ingredientes?", "Sim", "Não" );
                }
                try {
                    dados.adicionarReceita(new Receita(nome,cadastroIngredientes,cadastroQuantIngredientes));
                } catch (IngredienteNaoExisteException e) {
                    System.out.println("Ingrediente não cadastrado. Verifique os ingredientes disponíveis");
                }
            }
            else if(opcao==3){
                //editar receita
                String nomeReceita = Entrada.leiaString("Qual nome da receita?").toUpperCase();
                String novoConteudo = Entrada.leiaString("Novo nome").toUpperCase();
                try {
                    dados.editar(nomeReceita, novoConteudo, 1);
                } catch (ReceitaNaoExisteException e) {
                    System.out.println("Receita não encontrada!");
                }
            }
            else if(opcao==4){
                //excluir receita
                String nomeReceita = Entrada.leiaString("Qual receita você deseja excluir?").toUpperCase();
                try {
                    dados.removerReceita(nomeReceita);
                } catch (ReceitaNaoExisteException e) {
                    System.out.println("Receita não encontrada");
                }

            }
            else if(opcao==5){
                //listar ingredientes
                System.out.println("Ingredientes: ");
                for(String ingre : dados.getListaIngrediente()){
                    System.out.println(ingre);
                }
            }
            else if(opcao==6){
                //adicionar ingredientes
                String novoIngrediente = Entrada.leiaString("Qual ingrediente gostaria de adicionar?").toUpperCase();
                try {
                    dados.adicionarIngrediente(novoIngrediente);
                } catch (IngredienteExisteException e) {
                    System.out.println("Ingrediente já registrado");
                }
            }

            else if(opcao==7){
                //excluir ingredientes
                String excluir = Entrada.leiaString("Qual ingrediente remover?").toUpperCase();
                try {
                    dados.excluirIngrediente(excluir);
                } catch (IngredienteNaoExisteException e) {
                    System.out.println("Ingrediente não existe");
                }
            }
            else if(opcao==8){
                break;
            }



        }
    }
}
