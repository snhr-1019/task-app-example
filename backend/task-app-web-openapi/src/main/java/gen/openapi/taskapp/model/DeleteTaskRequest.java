package gen.openapi.taskapp.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * タスク削除のリクエスト
 */

@Schema(name = "DeleteTaskRequest", description = "タスク削除のリクエスト")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-06T17:47:49.913801616+09:00[Asia/Tokyo]")
public class DeleteTaskRequest {

  private Integer id;

  /**
   * Default constructor
   * @deprecated Use {@link DeleteTaskRequest#DeleteTaskRequest(Integer)}
   */
  @Deprecated
  public DeleteTaskRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DeleteTaskRequest(Integer id) {
    this.id = id;
  }

  public DeleteTaskRequest id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * タスクのID
   * @return id
  */
  @NotNull
  @Schema(name = "id", description = "タスクのID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteTaskRequest deleteTaskRequest = (DeleteTaskRequest) o;
    return Objects.equals(this.id, deleteTaskRequest.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteTaskRequest {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
