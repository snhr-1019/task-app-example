package com.example.taskapp.model;

import java.net.URI;
import java.util.Objects;
import com.example.taskapp.model.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * タスク一覧の取得レスポンス
 */

@Schema(name = "GetTasksResponse", description = "タスク一覧の取得レスポンス")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-31T17:49:51.369224443+09:00[Asia/Tokyo]")
public class GetTasksResponse {

  @Valid
  private List<@Valid Task> tasks;

  public GetTasksResponse tasks(List<@Valid Task> tasks) {
    this.tasks = tasks;
    return this;
  }

  public GetTasksResponse addTasksItem(Task tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

  /**
   * タスク一覧
   * @return tasks
  */
  @Valid 
  @Schema(name = "tasks", description = "タスク一覧", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tasks")
  public List<@Valid Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<@Valid Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTasksResponse getTasksResponse = (GetTasksResponse) o;
    return Objects.equals(this.tasks, getTasksResponse.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTasksResponse {\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
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

