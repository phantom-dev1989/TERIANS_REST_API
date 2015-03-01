package com.terians.dto;

/**
 * Created by stromero on 12/11/2014.
 */
public class Issue {

    // Properties
    private String teriansId;
    private String issue;
    private String description;
    private String fileName;
    private String severity;
    private String lineNumber;
    private String packageName;
    private String className;
    private String priority;
    private String scanTool;
    private String issueType;
    private String category;
    private String filePath;
    private String techDebtMinutes;

    public Issue() {
    }

    public Issue(String category, String className, String description, String fileName, String filePath,
                 String issue, String issueType, String lineNumber, String packageName, String priority,
                 String scanTool, String severity, String techDebtMinutes, String teriansId) {

        this.category = category;
        this.className = className;
        this.description = description;
        this.fileName = fileName;
        this.filePath = filePath;
        this.issue = issue;
        this.issueType = issueType;
        this.lineNumber = lineNumber;
        this.packageName = packageName;
        this.priority = priority;
        this.scanTool = scanTool;
        this.severity = severity;
        this.techDebtMinutes = techDebtMinutes;
        this.teriansId = teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getScanTool() {
        return scanTool;
    }

    public void setScanTool(String scanTool) {
        this.scanTool = scanTool;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTechDebtMinutes() {
        return techDebtMinutes;
    }

    public void setTechDebtMinutes(String techDebtMinutes) {
        this.techDebtMinutes = techDebtMinutes;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

}
