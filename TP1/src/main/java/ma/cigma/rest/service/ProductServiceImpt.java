package ma.cigma.rest.service;
import java.util.ArrayList;
import java.util.List;

import ma.cigma.rest.service.model.Product;
import org.springframework.stereotype.Service;


//TODO : learn @Service
@Service
public class ProductServiceImpt implements IProdcutService {
	
	private static List<Product> ProductRepo = new ArrayList<>();

	static {

		ProductRepo.add( new Product(5L, "PC portable Hp"));
		ProductRepo.add( new Product( 2L, "TV LG "));
		ProductRepo.add( new Product( 3L, "TV SONY"));
		ProductRepo.add( new Product( 4L, "Camera"));
	}
	@Override
	public Product getById(Long id) {
		 if (ProductRepo == null || ProductRepo.isEmpty()) {
			 return null ; 
		 }
		 for (Product product : ProductRepo) {
			 if(id.equals(product.getId()))
				 return product;
		 }
		return null;
	}
	
	@Override
	public List<Product> getAll() {
		return ProductRepo;
	}
	
	@Override
	public  void create(Product product){
		ProductRepo.add(product);
	}



	@Override
	public void update(Long id, Product product) {
		Product productFound = getById(id);
		if (productFound == null)
			return;
		ProductRepo.remove(productFound);
		product.setId(id);
		ProductRepo.add(product);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Product productFound = getById(id);
		if (productFound == null)
			return;
		ProductRepo.remove(productFound);
	}

 
		
}
