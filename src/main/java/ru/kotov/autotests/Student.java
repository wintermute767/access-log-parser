package ru.kotov.autotests;

import lombok.*;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Student {
    Integer id;
    String name;
    List<Integer> marks = new ArrayList();

    public Student() {
    }

    public Student(Integer id, String name, Integer... marks) {
        this.id = id;
        this.name = name;
        this.marks.addAll(Arrays.asList(marks));
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return this.marks;
    }

    public double average() {
        return this.marks.stream().mapToInt((x) -> {
            return x;
        }).average().orElse(-1.0);
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public String toString() {
        return "Student{id=" + this.id + ", name=" + this.name + ", marks=" + this.marks + '}';
    }

    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Student other = (Student)obj;
            return Objects.equals(this.id, other.id);
        }
    }
}