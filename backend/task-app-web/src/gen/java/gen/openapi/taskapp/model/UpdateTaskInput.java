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
 * タスク更新入力
 */

@Schema(name = "UpdateTaskInput", description = "タスク更新入力")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-17T00:54:57.306825+09:00[Asia/Tokyo]")
public class UpdateTaskInput {

  private Integer id;

  private String title;

  private Boolean completed;

  /**
   * Default constructor
   * @deprecated Use {@link UpdateTaskInput#UpdateTaskInput(Integer)}
   */
  @Deprecated
  public UpdateTaskInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateTaskInput(Integer id) {
    this.id = id;
  }

  public UpdateTaskInput id(Integer id) {
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

  public UpdateTaskInput title(String title) {
    this.title = title;
    return this;
  }

  /**
   * タスクのタイトル
   * @return title
  */
  
  @Schema(name = "title", description = "タスクのタイトル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UpdateTaskInput completed(Boolean completed) {
    this.completed = completed;
    return this;
  }

  /**
   * タスクのステータス
   * @return completed
  */
  
  @Schema(name = "completed", description = "タスクのステータス", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    UpdateTaskInput updateTaskInput = (UpdateTaskInput) o;
    return Objects.equals(this.id, updateTaskInput.id) &&
        Objects.equals(this.title, updateTaskInput.title) &&
        Objects.equals(this.completed, updateTaskInput.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTaskInput {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

