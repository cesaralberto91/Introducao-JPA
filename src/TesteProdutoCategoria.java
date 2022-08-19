
import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author aluno
 */
public class TesteProdutoCategoria {

    private static ProdutoDAO produtoDAO = new ProdutoDAO();

    public static void main(String[] args) {

        adicionarProdutos();

        reajustarPrecoProdutos(5);
        exibirProdutos();

    }

    private static void teste() {
        Categoria categoria = new Categoria();
        categoria.setDescricao("Informática");

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.inserir(categoria);

        Produto produto = new Produto();
        produto.setDescricao("Teclado");
        produto.setPreco(new BigDecimal(60.0));
        produto.setQuantidade(100);

        produto.setCategoria(categoria);

        produtoDAO.inserir(produto);

        List<Produto> produtos = produtoDAO.buscar();
        for (Produto p : produtos) {
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Categoria: " + p.getCategoria().getDescricao());
        }
    }

    private static void adicionarProdutos() {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        for (int i = 0; i < 10; i++) {
            Categoria categoria = new Categoria();
            categoria.setDescricao("Categoria " + i);
            categoriaDAO.inserir(categoria);

            Produto produto = new Produto();
            produto.setDescricao("Produto " + i);
            produto.setPreco(new BigDecimal(60.0 * (i + 1)));
            produto.setQuantidade(100);

            produto.setCategoria(categoria);

            produtoDAO.inserir(produto);

        }

    }

    private static void reajustarPrecoProdutos(double porcentagem) {

    }

    private static void exibirProdutos() {
    }

}
