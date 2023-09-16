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
 * タスク削除入力
 */

@Schema(name = "DeleteTaskInput", description = "タスク削除入力")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-05T15:57:01.381743194+09:00[Asia/Tokyo]")
public class DeleteTaskInput {

  private Integer id;

  /**
   * Default constructor
   * @deprecated Use {@link DeleteTaskInput#DeleteTaskInput(Integer)}
   */
  @Deprecated
  public DeleteTaskInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DeleteTaskInput(Integer id) {
    this.id = id;
  }

  public DeleteTaskInput id(Integer id) {
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
    DeleteTaskInput deleteTaskInput = (DeleteTaskInput) o;
    return Objects.equals(this.id, deleteTaskInput.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteTaskInput {\n");
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

