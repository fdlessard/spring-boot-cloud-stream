package io.fdlessard.codebites.cloud.stream.api.model;

public interface Publisher<T> {

  void publishCreate(T t);

  void publishUpdate(T t);
}
