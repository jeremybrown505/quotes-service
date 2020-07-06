package edu.cnm.deepdive.quotes.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import org.springframework.lang.NonNull;

@JsonPropertyOrder(value = {"id", "created", "updated", "name"})
public interface FlatSource {

  public Long getId();

  @NonNull
  String getName();

  Date getCreated();

  Date getUpdated();

}
