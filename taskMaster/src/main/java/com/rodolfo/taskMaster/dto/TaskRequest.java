package com.rodolfo.taskMaster.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {

    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 100, message = "El titulo no puede tener mas de 100 caracteres")
    @Schema(description = "Título de la tarea", example = "Estudiar Spring Boot")
    private String title;

    @Size(max = 255, message = "La descripcion es muy larga")
    @Schema(description = "Descripcion de la tarea", example = "Repasar JWT y seguridad")
    private String description;

    @Schema(description = "Estado de la tarea", example = "false")
    private Boolean  completed;

    private Long userId;

    public TaskRequest() {
    }

    public TaskRequest(String title, String description, Boolean  completed, Long userId) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
