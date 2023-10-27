import java.util.ArrayList;

public class Receita {
    private int codigo_receita;
    private String nome_receita;
    private ArrayList<String> ingredientes;
    private ArrayList<Double> quant_ingrediente;

    public Receita(String nome_receita, ArrayList<String> ingredientes, ArrayList<Double> quant_ingrediente){
        this.nome_receita = nome_receita;
        this.ingredientes = ingredientes;
        this.quant_ingrediente = quant_ingrediente;
    }


    //getters
    public String getNome_receira() {
        return nome_receita;
    }

    public int getCodigo_receita() {
        return codigo_receita;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public ArrayList<Double> getQuant_ingrediente() {
        return quant_ingrediente;
    }

    public int quantidadeItensIngredientes(){return quant_ingrediente.size();}




    //setters
    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setQuant_ingrediente(ArrayList<Double> quant_ingrediente) {
        this.quant_ingrediente = quant_ingrediente;
    }
}
