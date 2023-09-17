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
 * タスク登録入力
 */

@Schema(name = "CreateTaskInput", description = "タスク登録入力")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-17T22:57:38.803552812+09:00[Asia/Tokyo]")
public class CreateTaskInput {

  private String title;

  /**
   * Default constructor
   * @deprecated Use {@link CreateTaskInput#CreateTaskInput(String)}
   */
  @Deprecated
  public CreateTaskInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateTaskInput(String title) {
    this.title = title;
  }

  public CreateTaskInput title(String title) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTaskInput createTaskInput = (CreateTaskInput) o;
    return Objects.equals(this.title, createTaskInput.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTaskInput {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

