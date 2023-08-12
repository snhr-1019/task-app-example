package com.example.taskapp.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PutTaskRequest
 */

@JsonTypeName("putTask_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-12T23:31:03.184108087+09:00[Asia/Tokyo]")
public class PutTaskRequest {

  private Boolean completed;

  /**
   * Default constructor
   * @deprecated Use {@link PutTaskRequest#PutTaskRequest(Boolean)}
   */
  @Deprecated
  public PutTaskRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PutTaskRequest(Boolean completed) {
    this.completed = completed;
  }

  public PutTaskRequest completed(Boolean completed) {
    this.completed = completed;
    return this;
  }

  /**
   * タスクのステータス
   * @return completed
  */
  @NotNull 
  @Schema(name = "completed", description = "タスクのステータス", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("completed")
  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutTaskRequest putTaskRequest = (PutTaskRequest) o;
    return Objects.equals(this.completed, putTaskRequest.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutTaskRequest {\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

