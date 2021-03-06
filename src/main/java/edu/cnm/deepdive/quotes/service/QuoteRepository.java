package edu.cnm.deepdive.quotes.service;

import edu.cnm.deepdive.quotes.model.entity.Quote;
import edu.cnm.deepdive.quotes.model.entity.Source;
import edu.cnm.deepdive.quotes.model.entity.Tag;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

  Iterable<Quote> getAllByOrderByTextAsc();

  Iterable<Quote> getAllBySourceOrderByTextAsc(Source source);

  Iterable<Quote> getAllByTagsContainingOrderByTextAsc(Tag tag);

  Iterable<Quote> getAllByTextContainingOrderByTextAsc(String filter);

  Iterable<Quote> getAllByCreatedBetweenOrderByCreatedAsc(Date start, Date end);

  @SuppressWarnings("SqlResolve")
  @Query(value = "SELECT * FROM sa.Quote ORDER BY RANDOM() OFFSET 0 ROWS FETCH NEXT 1 ROW ONLY",
      nativeQuery = true)
  Optional<Quote> getRandom();

  @Query("SELECT COUNT(q) from Quote As q")
  long getCount();
}
