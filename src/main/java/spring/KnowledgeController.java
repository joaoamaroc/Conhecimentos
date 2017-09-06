package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Web service that returns Product objects.
 * @author Prof. Júlio Machado
 * @author Renan Kummer
 */
@Controller
public class KnowledgeController {

	private KnowledgesRepository know;
	private PersonRepository per;

	/**
	 * Constructor: sets repository of Knowledges.
	 * @param repo Repository of Knowledges.
	 */
	@Autowired
	public KnowledgeController(KnowledgesRepository knowledgeRep, PersonRepository personRep) {
		this.know = knowledgeRep;
		this.per = personRep;
	}

	/**
	 *
	 *
	 */
// ------------------------------- Consult Knowleges  -----------------------------------------------------------------------------
	@GetMapping("/listKnowledges")
	public String listKnowledges(Model model) {
		model.addAttribute("knowledge", know.findAll());
		return "listKnowledges";
	}
	
// ------------------------------- Consult Knowleges  -----------------------------------------------------------------------------
	@GetMapping("/listPeople")
	public String listPeople(Model model) {
		model.addAttribute("person", per.findAll());
		return "listPeople";
	}
	
	
// ------------------------------- Create a Person ---------------------------------------------------------------------------------
	@GetMapping("/newPerson")
	public String getNewPersonForm(Model model) {
		model.addAttribute("person", this.per);
		return "newPerson";
	}
	
	@PostMapping("/newPerson")
	public String setNewPerson(@RequestParam(name = "nome") String name, @RequestParam(name = "idade") int idade, Model model) {
		Person p = new Person(name, idade);
		per.save(p);
		return "redirect:/home";
	}
	
// ------------------------------- Create a Knowledge -----------------------------------------------------------------------------
		@GetMapping("/newKnowledge")
		public String newPersonForm(Model model) {
			model.addAttribute("knowledge", this.know);
			return "newKnowledge";
		}
		
		@PostMapping("/newKnowledge")
		public String newPerson(@RequestParam(value = "id", required = true) int idPessoa, @RequestParam(name = "knowledge") String knowledge, @RequestParam(name = "level") Level level, Model model) {
			Person p = per.findOne(idPessoa);
			
			Knowledges k = new Knowledges(knowledge, level, p);
			know.save(k);
			return "redirect:/home";
			//return "newKnowledge";
		}
		

	/**
     *
     *
     *
	 */
	/*// GET http://localhost:8080/product?id=<param>
	@GetMapping("/knowledges")
	public String allPersonKnowledge(@RequestParam(value = "id") int id, Model model) {
		model.addAttribute();
		return "knowledges";
	}

	*//**
	 * Find and return all sales.
	 * @return List of Sale objects.
	 *//*
	// GET http://localhost:8080/all-sales
	@GetMapping("/all-sales")
	public Iterable<Sale> findAllSales() {
		return this.allSales.findAll();
	}

	*//**
	 * Find and return a specific sale.
	 * @param id ID of sale to be found.
	 * @return Reference to Sale object if found, null otherwise.
	 *//*
	// GET http://localhost:8080/all-sales/<param>
	@GetMapping("/all-sales/{id}")
	public ResponseEntity<Sale> findSaleById(@PathVariable("id") int id) {
		Sale s = this.allSales.findOne(id);

		if (s != null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	*//**
	 * Add item to existing sale in database.
	 * @param saleId Existing sale's ID.
	 * @param productId Sold product's ID.
	 * @param amount Amount sold.
	 * @return HTTP's response.
	 *//*
	// PUT http://localhost:8080/new-sale/<param>/<param>/<param>
	@PutMapping("/new-sale")
	public ResponseEntity<Sale> insertSale(	@RequestParam("saleId") int saleId, @RequestParam("productId") int productId,
											@RequestParam("amount") int amount, Model model) {
		Sale s = this.allSales.findOne(saleId);

		if (s != null) {
			Product p = this.allProducts.findOne(productId);

			if (p != null) {
				s.sell(p, amount);
				this.allSales.save(s);
				return new ResponseEntity<>(s, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/

	/**
	 * Insert new sale in database.
	 * @param s Sale to be inserted.
	 * @param uri ??
	 * @return HTTP's response.
	 */
	// POST http://localhost:8080/new-sale
	/*
	 * @PostMapping("/new-sale") public ResponseEntity<Void> insertSale(@RequestBody
	 * Sale s, UriComponentsBuilder uri) { if ((s.getId() != 0) &&
	 * this.allSales.exists(s.getId())) { return new
	 * ResponseEntity<>(HttpStatus.CONFLICT); } Sale newSale =
	 * this.allSales.save(s); HttpHeaders header = new HttpHeaders();
	 * header.setLocation(uri.path("/new-sale/{id}").buildAndExpand(newSale.getId())
	 * .toUri()); return new ResponseEntity<>(header, HttpStatus.CREATED); }
	 */
}

