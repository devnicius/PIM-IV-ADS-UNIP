package com.sha.gestaoHoteleira.controller;

import com.sha.gestaoHoteleira.model.Contact;
import com.sha.gestaoHoteleira.repository.ContactRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;


/**
 * @author Vinicius
 * @see Controller - é a classe responsável por expor cada URI que estará disponível na API
 * @apiNote @RestController - A anotação @RestController contém as anotações @Controller e @ResponseBody (pode omitir essas duas para deixar o código mais limpo).
 *  A anotação @Controller representa uma classe com endpoints (URIs que serão expostas pela API) e a classe indica que o valor retornado pelos métodos devem ser vinculados ao corpo da resposta (response body).
 * @apiNote @RequestMapping("/contacts") indica que a URL da API desse controller começa com /contacts, isso significa que pode-se acessar usando a URL http://localhost:8080/contacts (acesso local).
 */

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
    private ContactRepository repository;

    ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }
    // métodos do CRUD

    @GetMapping
    public List findAll() {
        // O método findAll é direto ao ponto: utiliza o método findAll da interface JpaRepository que faz um select * from contacts.
        return (List) repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        // Vincula o parâmetro passado pelo método com a variável do path (/contacts). Note que o parâmetro long id tem o mesmo nome do path declarado em @GetMapping(path = {"/{id}"})
        return repository.findById(id)
           .map(record -> ResponseEntity.ok().body(record))
           .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        // Cria o registro na tabela e retorna o contato com o atributo id e o registro é retornado no corpo da resposta.
        // @RequestBody indica que o parâmetro contact será vinculado do corpo da requisição. Isto significa que o método espera um conteúdo em JSON.
        return repository.save(contact);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                      @RequestBody Contact contact) {
        // Para atualizar um registro, é necessário informar seu ID no caminho da URL (similar ao processo de obter um registro específico).
        return repository.findById(id)
           .map(record -> {
                record.setName(contact.getName());
                record.setEmail(contact.getEmail());
                record.setPhone(contact.getPhone());
                Contact updated = repository.save(record);
                return ResponseEntity.ok().body(updated);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        // Para remover um contato pelo ID, utiliza-se o id que foi passado como parâmetro para procurar se o registro existe na base. Caso exista, é usado o método deleteById da interface JpaRepository e retorna o status HTTP 200 para indicar sucesso. Caso o registro não exista, retorna um erro HTTP 404.
        return repository.findById(id)
           .map(record -> {
               repository.deleteById(id);
               return ResponseEntity.ok().build();
           }).orElse(ResponseEntity.notFound().build());
    }
}
