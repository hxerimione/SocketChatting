package chatting.chat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String Id;
    Object session;
    Grade grade;

    public User(String id, Object session, Grade grade) {
        this.Id = id;
        this.session = session;
        this.grade = grade;
    }
}
