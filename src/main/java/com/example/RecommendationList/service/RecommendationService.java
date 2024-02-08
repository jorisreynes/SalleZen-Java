package com.example.RecommendationList.service;

import com.example.RecommendationList.model.Recommendation;
import com.example.RecommendationList.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {
	private final RecommendationRepository recommendationRepository;
	public RecommendationService(RecommendationRepository recommendationRepository) {
		this.recommendationRepository = recommendationRepository;
	}

	public List<Recommendation> getAllRecommendations() {
		return recommendationRepository.findAll();
	}

	public Optional<Recommendation> getRecommendationById(String id) {
		return recommendationRepository.findById(id);
	}

	public Recommendation saveOrUpdateRecommendation(Recommendation recommendation) {
		return recommendationRepository.save(recommendation);
	}

	public void deleteRecommendation(String id) {
		recommendationRepository.deleteById(id);
	}
}
