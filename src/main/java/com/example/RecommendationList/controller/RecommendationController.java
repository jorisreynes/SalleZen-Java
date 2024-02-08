package com.example.RecommendationList.controller;

import com.example.RecommendationList.model.Recommendation;
import com.example.RecommendationList.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/recommendation")
public class RecommendationController {
	private final RecommendationService recommendationService;
	public RecommendationController(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}
	@GetMapping
	public List<Recommendation> getAllRecommendations() {
		return recommendationService.getAllRecommendations();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Recommendation> getRecommendationById(@PathVariable String id) {
		return recommendationService.getRecommendationById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
		recommendation.setDate(LocalDate.now());
		return recommendationService.saveOrUpdateRecommendation(recommendation);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Recommendation> updateRecommendation(@PathVariable String id, @RequestBody Recommendation recommendation) {
		return recommendationService.getRecommendationById(id)
				.map(storedRecommendation -> {
					recommendation.setId(id); // Ensure the ID is set
					return ResponseEntity.ok(recommendationService.saveOrUpdateRecommendation(recommendation));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecommendation(@PathVariable String id) {
		if (recommendationService.getRecommendationById(id).isPresent()) {
			recommendationService.deleteRecommendation(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
