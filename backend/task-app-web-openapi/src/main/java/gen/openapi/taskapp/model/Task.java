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
 * タスク情報
 */

@Schema(name = "Task", description = "タスク情報")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-06T17:47:49.913801616+09:00[Asia/Tokyo]")
public class Task {

  private Integer id;

  private String title;

  private Boolean completed;

  /**
   * Default constructor
   * @deprecated Use {@link Task#Task(Integer, String, Boolean)}
   */
  @Deprecated
  public Task() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Task(Integer id, String title, Boolean completed) {
    this.id = id;
    this.title = title;
    this.completed = completed;
  }

  public Task id(Integer id) {
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

  public Task title(String title) {
    this.title = title;
    return this;
  }

  /**
   * タスクのタイトル
   * @return title
  */
  @NotNull
  @Schema(name = "title", description = "タスクのタイトル", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Task completed(Boolean completed) {
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
    Task task = (Task) o;
    return Objects.equals(this.id, task.id) &&
        Objects.equals(this.title, task.title) &&
        Objects.equals(this.completed, task.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
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
