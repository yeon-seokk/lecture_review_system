package myProject.first_project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity //  Jpa가 관리하는 엔티티임을 선언
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 데이터 구분을 위한 시스템 아이디
    private String courseName;      // 강의명
    private String professor;       // 교수님 성함
    private int rating;             // 별점 (1~5점)
    private String comment;         // 한 줄 평

    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
