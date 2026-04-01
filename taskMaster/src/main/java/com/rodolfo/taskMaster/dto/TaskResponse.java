package com.rodolfo.taskMaster.dto;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private Boolean  completed;

    private Long userId;
    private String name;

    public TaskResponse() {
    }

    public TaskResponse(Long id, String title, String description, Boolean  completed, Long userId, String name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.userId = userId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean  isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean  completed) {
        this.completed = completed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
