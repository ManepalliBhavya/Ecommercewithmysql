package com.example.Mysqldemo.controller;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.Mysqldemo.model.Category;
import com.example.Mysqldemo.model.Product;
import com.example.Mysqldemo.model.Supplier;
import com.example.Mysqldemo.repository.CategoryRepository;
import com.example.Mysqldemo.repository.ProductRepository;
import com.example.Mysqldemo.repository.SupplierRepository;
import com.example.Mysqldemo.service.CategoryService;
import com.example.Mysqldemo.service.ProductService;
import com.example.Mysqldemo.service.SupplierService;

/**
 * Adding Spring MVC annotation before the class name.
 */
@Controller
public class ProductController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	/**
	 * Declare the previously created `ProductRepository` after the class name.
	 */
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SupplierService supplierService;

	/**
	 * The request mapping annotation lets spring MVC know which controller class
	 * method to call. This annotation takes two parameters called path/value and
	 * method. This way we could map them based on path as well as HTTP methods like
	 * , GET, POST, PUT and DETELE.
	 */
	@RequestMapping(value = "/productadd", method = RequestMethod.GET)
	public ModelAndView productsPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelView = new ModelAndView();
		List<Category> list = new ArrayList<Category>();
		list = categoryService.findAllCategory();
		System.out.println(list);
		modelView.addObject("categoryList", list);

		List<Supplier> list1 = new ArrayList<Supplier>();
		list1 = supplierService.findAllSupplier();
		System.out.println(list1);
		modelView.addObject("supplierList", list1);
		modelView.setViewName("productAdd");
		return modelView;
	}

	@PostMapping("/productadd")
	public String createProduct(@Validated Product product, @RequestParam("catName") long catName,
			@RequestParam("suppName") long suppName, @RequestParam("proName") final String name,
			@RequestParam("proDesc") final String prodesc, @RequestParam("price") final String price,
			@RequestParam("file") MultipartFile file, @RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2,
			@RequestParam("file3") MultipartFile file3) {
		ModelAndView modelView = new ModelAndView();
		System.out.println(catName);
		Category cat = new Category();
		Optional<Category> cats = categoryService.findCategory(catName);
		cat = cats.get();

		System.out.println("Hiii" + suppName);
		Set<Supplier> supp = new HashSet<>();
		Optional<Supplier> supps = supplierService.findSupplier(suppName);
		// supp=(Set<Supplier>) supps.get();
		supp.add(supps.get());
		System.out.println(supp);

		try {
			HttpHeaders headers = new HttpHeaders();
			if (product == null) {
				return null;
			}

			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String imageName1 = file1.getOriginalFilename();
			String imagePath1 = Paths.get(uploadDirectory, imageName1).toString();
			String imageName2 = file2.getOriginalFilename();
			String imagePath2 = Paths.get(uploadDirectory, imageName2).toString();
			String imageName3 = file3.getOriginalFilename();
			String imagePath3 = Paths.get(uploadDirectory, imageName3).toString();

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			BufferedOutputStream stream1 = new BufferedOutputStream(new FileOutputStream(new File(imagePath1)));
			stream1.write(file1.getBytes());
			stream1.close();
			BufferedOutputStream stream2 = new BufferedOutputStream(new FileOutputStream(new File(imagePath2)));
			stream2.write(file2.getBytes());
			stream2.close();

			BufferedOutputStream stream3 = new BufferedOutputStream(new FileOutputStream(new File(imagePath3)));
			stream3.write(file3.getBytes());
			stream3.close();

			System.out.println(name);
			product.setProName(name);
			product.setProDesc(prodesc);
			product.setPrice(price);
			product.setFileName(fileName);
			product.setFilePath(filePath);
			product.setImageName1(imageName1);
			product.setImagePath1(imagePath1);
			product.setImageName2(imageName2);
			product.setImagePath2(imagePath2);
			product.setImageName3(imageName3);
			product.setImagePath3(imagePath3);
			product.setCategories(cat);
			product.getSuppliers().addAll(supp);

			boolean status = productService.saveUser(product);

			if (status) {
				modelView.setViewName("productAdd");
				headers.add("Product Saved With Image - ", fileName);
				headers.add("Product Saved With Image - ", imageName1);
				headers.add("Product Saved With Image - ", imageName2);
				headers.add("Product Saved With Image - ", imageName3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/productadd";
	}

	/**
	 * model and view method for the productList page.
	 */
	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public ModelAndView productList(ModelMap model) {
		List<Product> productList = new ArrayList<Product>();
		productList = productService.listAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("productList", productList);
		modelandview.setViewName("productList");
		return modelandview;
	}

	/**
	 * model and view method for the productsearch page.
	 */
	@RequestMapping(value = "/search")
	public ModelAndView viewHomePage(Model model, @Param("proName") String proName) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(proName);
		modelAndView.setViewName("search");
		List<Product> listAllProducts = new ArrayList<Product>();
		listAllProducts = productService.listAll();
		boolean productName = false;
		for (Product product : listAllProducts) {
			if (product.getProName().equals(proName)) {
				productName = true;
			}
		}
		List<Category> listAllCategories = new ArrayList<Category>();
		listAllCategories = categoryRepository.findAll();
		boolean categoryName = false;
		for (Category category : listAllCategories) {
			if (category.getCatName().equals(proName)) {
				categoryName = true;
			}
		}
		List<Supplier> listAllsuppliers = new ArrayList<Supplier>();
		listAllsuppliers = supplierRepository.findAll();
		boolean supplierName = false;
		for (Supplier supplier : listAllsuppliers) {
			if (supplier.getSuppName().equals(proName)) {
				supplierName = true;
				System.out.println("supplierName");
			}
		}
		if (productName) {
			List<Product> listProducts = productService.listAll(proName);
			modelAndView.addObject("listProducts", listProducts);
		} else if (categoryName) {
			Category cats = categoryService.findCategoryByName(proName).get();
			List<Product> listPro = new ArrayList<Product>();
			listPro = productService.productByCategoryId(cats.getId());
			System.out.println(listPro);
			modelAndView.addObject("listProducts", listPro);
		} else if (supplierName) {
			Supplier supp = supplierService.findSupplierByName(proName).get();
			Set<Product> products = new HashSet<Product>();
			products = supp.getProducts();
			// System.out.println(products);
			System.out.println("hiii");
			modelAndView.addObject("listProducts", products);

		} else {
			modelAndView.setViewName("welcome");
		}
		return modelAndView;
	}

	/**
	 * model and view method for the userproductsearch page.
	 */
	@RequestMapping(value = "/userSearch")
	public ModelAndView viewUserSearchPage(Model model, @Param("proName") String proName) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(proName);
		modelAndView.setViewName("userSearch");
		List<Product> listAllProducts = new ArrayList<Product>();
		listAllProducts = productService.listAll();
		boolean productName = false;
		for (Product product : listAllProducts) {
			if (product.getProName().equals(proName)) {
				productName = true;
			}
		}
		List<Category> listAllCategories = new ArrayList<Category>();
		listAllCategories = categoryRepository.findAll();
		boolean categoryName = false;
		for (Category category : listAllCategories) {
			if (category.getCatName().equals(proName)) {
				categoryName = true;
			}
		}
		
		if (productName) {
			List<Product> listProducts = productService.listAll(proName);
			modelAndView.addObject("listProducts", listProducts);
		} else if (categoryName) {
			Category cats = categoryService.findCategoryByName(proName).get();
			List<Product> listPro = new ArrayList<Product>();
			listPro = productService.productByCategoryId(cats.getId());
			System.out.println(listPro);
			modelAndView.addObject("listProducts", listPro);
		}  else {
			modelAndView.setViewName("welcomeUser");
		}
		return modelAndView;
	}

	/**
	 * delete product from productList using id
	 */
	@RequestMapping(value = "productdelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") long id) {
		// System.out.println(id);
		productService.delete(id);
		return "redirect:/productlist";
	}

	// Handles the POST method.
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product) {
		Optional<Product> prod = productService.findProduct(product.getId());
		Product productUpdate = new Product();
		productUpdate = prod.get();
		productUpdate.setId(product.getId());
		productUpdate.setPrice(product.getPrice());
		productUpdate.setProDesc(product.getProDesc());
		productUpdate.setProName(product.getProName());
		productService.saveProduct(productUpdate);
		return "redirect:/productlist";
	}

	/**
	 * model and view method for the updateProduct page that effects in productList
	 * page after doing update operation.
	 */
	@RequestMapping(value = "productupdate/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id, @ModelAttribute Product product) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Optional<Product> product1 = productRepository.getProductById(id);
		System.out.println(product1);
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("product", product1);
		modelview.setViewName("updateProduct");
		return modelview;
	}

	/**
	 * model and view method for the productdetails.
	 */
	@RequestMapping(value = "/productdetails/{id}", method = RequestMethod.GET)
	public ModelAndView productdetails(ModelMap model, @PathVariable("id") long id) {
		Optional<Product> productList = productService.findProduct(id);
		Product product = new Product();
		product = productList.get();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("product", product);
		modelandview.setViewName("productDetails");
		return modelandview;
	}

	/**
	 * model and view method for the user productdetails.
	 */
	@RequestMapping(value = "/userProductdetails/{id}", method = RequestMethod.GET)
	public ModelAndView userproductdetails(ModelMap model, @PathVariable("id") long id) {
		Optional<Product> productListuser = productService.findProduct(id);
		Product productuser = new Product();
		ModelAndView modelview = new ModelAndView();
		productuser = productListuser.get();
		modelview.addObject("productuser", productuser);
		modelview.setViewName("userProductDetails");
		return modelview;
	}

	/**
	 * model and view method for the userProductList page.
	 */
	@RequestMapping(value = "/userproductlist", method = RequestMethod.GET)
	public ModelAndView userProductList(ModelMap model) {
		List<Product> productList = new ArrayList<Product>();
		productList = productService.listAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("productList", productList);
		modelandview.setViewName("userProductList");
		return modelandview;
	}

	/**
	 * model and view method for the welcomeOrderPage page.
	 */
	@RequestMapping(value = "/welcomeOrderPage/{id}", method = RequestMethod.GET)
	public ModelAndView welcomeOrderPage(ModelMap model, @PathVariable("id") long id) {
		Optional<Product> productList = productService.findProduct(id);
		Product product1 = new Product();
		product1 = productList.get();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("product1", product1);
		modelandview.setViewName("welcomeOrderPage");
		return modelandview;
	}
}