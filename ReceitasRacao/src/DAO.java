import java.util.ArrayList;
import comum.Arquivo;


public class DAO {
    private ArrayList<String> dadosTabela;
    private Arquivo dadosReceita;
    private Arquivo dadosIngrediente;
    private ArrayList <String> listaReceita;
    private ArrayList <String> listaIngrediente;

    public DAO(){
        dadosReceita = new Arquivo("receitas.txt");
        dadosIngrediente = new Arquivo("ingredientes.txt");
        listaReceita = new ArrayList<String>();
        listaIngrediente = new ArrayList<String>();
        dadosTabela = new ArrayList<String>(); //receitas + ingredientes
    }
    public void adicionarReceita(Receita receita) throws IngredienteNaoExisteException{
        boolean ingredientesExistem = true;
        for(String ingrediente : receita.getIngredientes()){
            if(!listaIngrediente.contains(ingrediente)){
                ingredientesExistem = false;
            }
        }
        if(ingredientesExistem){
            listaReceita.add(receita.getCodigo_receita()+";"+receita.getNome_receira()+";"+receita.getIngredientes()+";"+receita.getQuant_ingrediente());
        }else{
            throw new IngredienteNaoExisteException();
        }
    }

    //salvar
    public void salvar(){
        //arraylist => arquivo.txt
        dadosReceita.abrirEscrita();
        for(int i=0; i<listaReceita.size(); i++){
            dadosReceita.escreverLinha(listaReceita.get(i));
        }
        dadosReceita.fecharArquivo();

        dadosIngrediente.abrirEscrita();
        for(int i=0; i<listaIngrediente.size(); i++){
            dadosIngrediente.escreverLinha(listaIngrediente.get(i));
        }
        dadosIngrediente.fecharArquivo();
    }

    public void ler(){
        //arquivo.txt => arraylist


        String linhaReceita;
        dadosReceita.abrirLeitura();

        linhaReceita = dadosReceita.lerLinha();

        while(linhaReceita!=null){
            listaReceita.add(linhaReceita);
            linhaReceita = dadosReceita.lerLinha();
        }
        dadosReceita.fecharArquivo();

        String linhaIngredientes;
        dadosIngrediente.abrirLeitura();

        linhaIngredientes = dadosIngrediente.lerLinha();
        while(linhaIngredientes!=null){
            listaIngrediente.add(linhaIngredientes);
            linhaIngredientes = dadosIngrediente.lerLinha();
        }
        dadosIngrediente.fecharArquivo();
    }

    public ArrayList<String> getReceitas(){
        return listaReceita;
    }


    public void removerReceita(String nomeReceita) throws ReceitaNaoExisteException{
        String listaReceitaDividida[];
        int indiceRemover = -1;
        for (int i=0; i<listaReceita.size(); i++){
            listaReceitaDividida = listaReceita.get(i).split(";");
            if(listaReceitaDividida[1].equals(nomeReceita)){
                indiceRemover = i;
                break;
            }

        }

        if(indiceRemover == -1){
            throw new ReceitaNaoExisteException();
        }

        listaReceita.remove(indiceRemover);
        this.salvar();
    }


    public void editar(String nomeReceita, String novoConteudo, int opcao) throws ReceitaNaoExisteException{
        String listaReceitaDividida[];
        int indiceEditar = -1;
        for (int i=0; i<listaReceita.size(); i++){
            listaReceitaDividida = listaReceita.get(i).split(";");
            if(listaReceitaDividida[1].equals(nomeReceita)){
                indiceEditar = i;
                break;
            }
        }

        if(indiceEditar == -1){
            throw new ReceitaNaoExisteException();
        }
        else {
            String[] divisao = listaReceita.get(indiceEditar).split(";");

            //mudar nome
            if(opcao == 1){
                listaReceita.set(indiceEditar,divisao[0]+";"+novoConteudo+";"+divisao[2]+";"+divisao[3]);
                this.salvar();
            }


            //mudar ingrediente



            //mudar quantidade ingrediente
        }
    }

    public ArrayList<String> getListaIngrediente(){
        return listaIngrediente;
    }

    public void adicionarIngrediente(String novoIngrediente) throws IngredienteExisteException {

        if(listaIngrediente.contains(novoIngrediente)){
            throw new IngredienteExisteException();
        } else{
            listaIngrediente.add(novoIngrediente);
            this.salvar();
        }
    }

    public void excluirIngrediente(String ingredienteExcluir) throws IngredienteNaoExisteException{
        int indiceExcluir = -1;

        for(int i=0; i<listaIngrediente.size(); i++){
            if(listaIngrediente.get(i).equals(ingredienteExcluir)){
                indiceExcluir = i;
                break;
            }
        }
        if(indiceExcluir == -1){
            throw new IngredienteNaoExisteException();
        }
        else{
            listaIngrediente.remove(indiceExcluir);
        }


    }










}
