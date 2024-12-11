package com.klef.jfsd.springboot.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "course_table")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String courseId;
    private String title;
    private String description;
    private String topicsCovered;
    private String duration;
    private String level;

    private String language;

  
    private LocalDate startDate;

  
    private LocalDate endDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
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


	public String getTopicsCovered() {
		return topicsCovered;
	}


	public void setTopicsCovered(String topicsCovered) {
		this.topicsCovered = topicsCovered;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", title=" + title + ", description=" + description
				+ ", topicsCovered=" + topicsCovered + ", duration=" + duration + ", level=" + level + ", language="
				+ language + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

    // No getters and setters as requested
}