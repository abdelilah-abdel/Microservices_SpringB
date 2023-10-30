package ma.cigma.rest.controller;

 import ma.cigma.rest.service.IProdcutService;
 import ma.cigma.rest.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.MediaType;
 import org.springframework.http.ResponseEntity;
 import org.springframework.validation.annotation.Validated;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;
 import java.util.Objects;

@RestController
public class ProductController {

    @Autowired
    private IProdcutService service;

    @GetMapping(value = "/products" , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping(value = "products/{id}" )
    public Product getProductById(@PathVariable(value = "id") Long ProductId){
        return service.getById(ProductId);
    }

    @PostMapping(value = "/products")
    // TODO : learn this syntax ; JAVA
    public ResponseEntity<Object> createProdut(@Validated @RequestBody Product product)
    {
        service.create(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);

    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(name = "id") Long productId ,@RequestBody Product product) {
        Product productFound = service.getById(productId);

        if (productFound == null)
            // TODO : learn : ResponseEntity and it's methodes
            return ResponseEntity.notFound().build();
        service.update(productId, product);
        return new ResponseEntity<>("Producty is updated sucessfully ", HttpStatus.OK);

    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id") Long productId){
        Product productFound = service.getById(productId);
        if ( productFound == null)
            return ResponseEntity.notFound().build();
        service.delete(productId);
        return new ResponseEntity<>("Product deleted succefully ", HttpStatus.OK);
    }

    public IProdcutService getService(){
        return service;
    }

    public void setService(IProdcutService service){
        this.service = service;
    }





}
