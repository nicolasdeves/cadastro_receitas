public class Main {
    public static void main(String[] args) {
        //objetos
        DAO dados = new DAO();
        Tela tela = new Tela(dados);
        dados.ler();
        tela.exibir();
        dados.salvar();
    }
}

//Nícolas Deves