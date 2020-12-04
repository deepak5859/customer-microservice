package io.omnirio.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.omnirio.customerservice.models.User;
import io.omnirio.customerservice.repository.CustomerRepository;

@RestController
public class CustomerController {

//	@Autowired
//	WebClient.Builder webClientBuilder;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/")
	public String getWelcomeMessage() {
		return "CustomerMicroservice";
	}

	@GetMapping("/customer")
	List<User> getAllUsers() {
		return customerRepository.findAll();
	}

	@PostMapping("/customer")
	User AddUser(@RequestBody User newUser) {
		return customerRepository.save(newUser);
	}

//	@RequestMapping("/{customerId}")
//	public Customer getCustomer(@PathVariable("customerId") String customerId) {
//		return webClientBuilder.build().get()
//				.uri("http://ratings-data-service/ratingsdata/customer/" + customerId).retrieve()
//				.bodyToMono(Customer.class).block();
//	}

//    @RequestMapping("/{userId}")
//    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//
//        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);
//
//        return userRating.getRatings().stream()
//                .map(rating -> {
//                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
//                })
//                .collect(Collectors.toList());
//
//    }
}

/*
 * Alternative WebClient way Movie movie =
 * webClientBuilder.build().get().uri("http://localhost:8082/movies/"+
 * rating.getMovieId()) .retrieve().bodyToMono(Movie.class).block();
 */