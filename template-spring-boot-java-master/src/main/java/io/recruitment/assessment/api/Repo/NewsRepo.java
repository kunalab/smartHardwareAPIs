package io.recruitment.assessment.api.Repo;

import io.recruitment.assessment.api.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Integer> {
}
