package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test.Student;
import test.Subject;
import test.Teacher;
import test.Class;

import javax.sql.DataSource;

public class DBFetch {
	
	private DataSource dataSource;

	public DBFetch(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();

			String sql = "SELECT * FROM students";
			Stmt = Conn.createStatement();

			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				String firstName = Rs.getString("fname");
				String lastName = Rs.getString("lname");
				int age = Rs.getInt("age");
				int aclass = Rs.getInt("class");

				Student tempStudent = new Student(id, firstName, lastName, age, aclass);

				students.add(tempStudent);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return students;

	}

	public List<Teacher> getTeachers() {

		List<Teacher> teachers = new ArrayList<>();

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();

			String sql = "SELECT * FROM teachers";
			Stmt = Conn.createStatement();

			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				String firstName = Rs.getString("fname");
				String lastName = Rs.getString("lname");
				int age = Rs.getInt("age");

				Teacher temp = new Teacher(id, firstName, lastName, age);

				teachers.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return teachers;

	}

	public List<Subject> getSubjects() {

		List<Subject> subjects = new ArrayList<>();

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();
			String sql = "SELECT * FROM subjects";
			Stmt = Conn.createStatement();
			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				String name = Rs.getString("name");
				String shortcut = Rs.getString("shortcut");
				
				Subject temp = new Subject(id, name,shortcut);

				subjects.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return subjects;

	}

	public List<Class> getClasses() {

		List<Class> classes = new ArrayList<>();

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();

			String sql = "SELECT * FROM classes";
			Stmt = Conn.createStatement();

			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				int section = Rs.getInt("section");
				int subject = Rs.getInt("subject");
				int teacher = Rs.getInt("teacher");
				String time = Rs.getString("time");

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();

				Class temp = new Class(id, section, teacher_name, tempSubject.getName(), time);

				classes.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return classes;

	}

	public Teacher loadTeacher(int teacherId) {

		Teacher theTeacher = null;

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();

			String sql = "SELECT * FROM teachers WHERE id = " + teacherId;
			Stmt = Conn.createStatement();

			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				String fname = Rs.getString("fname");
				String lname = Rs.getString("lname");
				int age = Rs.getInt("age");
				theTeacher = new Teacher(id, fname, lname, age);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return theTeacher;

	}

	public Subject loadSubject(int subjectId) {

		Subject theSubject = null;

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();

			String sql = "SELECT * FROM subjects WHERE id = " + subjectId;
			Stmt = Conn.createStatement();

			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				String name = Rs.getString("name");
				String shortcut = Rs.getString("shortcut");

				theSubject = new Subject(id, name,shortcut);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return theSubject;

	}

	public Class loadClass(int classId) {

		Class theClass = null;

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();

			String sql = "SELECT * FROM clasess WHERE id = " + classId;
			Stmt = Conn.createStatement();

			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				int section = Rs.getInt("section");
				int subject = Rs.getInt("subject");
				int teacher = Rs.getInt("teacher");
				String time = Rs.getString("time");

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return theClass;

	}

	public List<Student> loadClassStudents(int classId) {

		List<Student> students = new ArrayList<>();

		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			Conn = dataSource.getConnection();

			String sql = "SELECT * FROM students WHERE class = " + classId;
			Stmt = Conn.createStatement();

			Rs = Stmt.executeQuery(sql);

			while (Rs.next()) {

				int id = Rs.getInt("id");
				String firstName = Rs.getString("fname");
				String lastName = Rs.getString("lname");
				int age = Rs.getInt("age");
				int aclass = Rs.getInt("class");

				Student tempStudent = new Student(id, firstName, lastName, age, aclass);
				students.add(tempStudent);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(Conn, Stmt, Rs);
		}
		return students;

	}

	private void close(Connection Conn, Statement Stmt, ResultSet Rs) {

		try {
			if (Rs != null) {
				Rs.close();
			}
			if (Stmt != null) {
				Stmt.close();
			}
			if (Conn != null) {
				Conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
