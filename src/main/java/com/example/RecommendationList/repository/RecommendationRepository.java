package com.example.RecommendationList.repository;

import com.example.RecommendationList.model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecommendationRepository extends MongoRepository<Recommendation, String> {
}
