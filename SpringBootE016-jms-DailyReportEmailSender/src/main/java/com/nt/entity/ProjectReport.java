package com.nt.entity;

public class ProjectReport {

    private String projectName;
    private int completedTasks;
    private int pendingTasks;

    public ProjectReport(String projectName, int completedTasks, int pendingTasks) {
        this.projectName = projectName;
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getPendingTasks() {
        return pendingTasks;
    }
}
