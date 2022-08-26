package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Produto;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
public class ProdutoDAO extends AbstractDAO<Produto> {

    public List<Produto> buscar() {
        //JPQL
        //Sempre pensar em classe

        //SELECT p FROM Produto p  
        TypedQuery<Produto> query = getEntityManager()
                .createQuery("SELECT p FROM Produto p",
                        Produto.class);

        return query.getResultList();
    }

}
