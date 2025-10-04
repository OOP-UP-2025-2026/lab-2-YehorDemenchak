package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Student newStudent = new Student("Єгор Деменчак", 2);
        newStudent.addCourse("Теорія ймовірностей та мат. статистика");
        newStudent.addCourse("Об'єктно-орієнтоване програмування");

        System.out.println(newStudent.getName() + ": кількість вивчаємих дисциплін - " + newStudent.getCourseCount());
        System.out.println(newStudent.getName() + ": рік навчання - " + newStudent.getYear());
        System.out.println(newStudent.getName() + ": заплатив за навчання - " + newStudent.getTuition());
    }
}