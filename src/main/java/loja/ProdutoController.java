package loja;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	private static final List<Produto> listProdutos = new ArrayList<Produto>();
	public ProdutoController() {
		listProdutos.add(new Produto(1, "Caixa de fosforo"));
		listProdutos.add(new Produto(2, "Caixa de arame"));
		listProdutos.add(new Produto(3, "Caixa de bala"));
	}
	@RequestMapping("api/produtos")
	public List<Produto> listaProdutos(){	
		return listProdutos;		
	}
	
	@RequestMapping(value="/api/produtos/{id}", method=RequestMethod.GET)
	public Produto produto(@PathVariable("id") Long id) {
		for (Produto produto : listProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}		
		return null;
	}
	@RequestMapping(value="/api/produtos/{id}", method=RequestMethod.DELETE)
	public List<Produto> deleteProduto(@PathVariable("id") Long id) {	
		for (Produto produto : listProdutos) {
			if (produto.getId() == id) {
				listProdutos.remove(produto);
				return listProdutos;
			}
		}		
		return null;
	}
	@RequestMapping(value="/api/produtos/{id}", method=RequestMethod.PUT)
	public Produto updateProduto(@PathVariable("id") Long id, @RequestParam String nome) {	
		for (Produto produto : listProdutos) {
			if (produto.getId() == id) {
				
				produto.setNome(nome);
				
				return produto;
			}
		}		
		return null;
	}

}
