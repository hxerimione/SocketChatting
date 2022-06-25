package chatting.chat.vo;

public class User {
    String Id;
    Object session;
    Grade grade;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Object getSession() {
        return session;
    }

    public void setSession(Object session) {
        this.session = session;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public User(String id, Object session, Grade grade) {
        Id = id;
        this.session = session;
        this.grade = grade;
    }
}
