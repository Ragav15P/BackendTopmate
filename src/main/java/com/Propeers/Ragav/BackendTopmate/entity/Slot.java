package com.Propeers.Ragav.BackendTopmate.entity;

import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
@Entity
public class Slot 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User mentor;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    private boolean isBooked = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getMentor() {
		return mentor;
	}

	public void setMentor(User mentor) {
		this.mentor = mentor;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Slot(Long id, User mentor, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, boolean isBooked) {
		super();
		this.id = id;
		this.mentor = mentor;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isBooked = isBooked;
	}

	public Slot() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Slot [id=" + id + ", mentor=" + mentor + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", isBooked=" + isBooked + "]";
	}
    
    
    

}
