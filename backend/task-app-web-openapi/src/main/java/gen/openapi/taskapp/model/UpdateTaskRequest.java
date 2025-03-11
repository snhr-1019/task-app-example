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
 * タスク更新のリクエスト
 */

@Schema(name = "UpdateTaskRequest", description = "タスク更新のリクエスト")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-06T17:47:49.913801616+09:00[Asia/Tokyo]")
public class UpdateTaskRequest {

  private Integer id;

  private String title;

  private Boolean completed;

  /**
   * Default constructor
   * @deprecated Use {@link UpdateTaskRequest#UpdateTaskRequest(Integer)}
   */
  @Deprecated
  public UpdateTaskRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateTaskRequest(Integer id) {
    this.id = id;
  }

  public UpdateTaskRequest id(Integer id) {
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

  public UpdateTaskRequest title(String title) {
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

  public UpdateTaskRequest completed(Boolean completed) {
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
    UpdateTaskRequest updateTaskRequest = (UpdateTaskRequest) o;
    return Objects.equals(this.id, updateTaskRequest.id) &&
        Objects.equals(this.title, updateTaskRequest.title) &&
        Objects.equals(this.completed, updateTaskRequest.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTaskRequest {\n");
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
