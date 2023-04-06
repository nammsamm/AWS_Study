package awsStudy.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //롬복의 어노테이션. 클래스 내 모든 필드의 Getter 메소드를 자동 생성.
@NoArgsConstructor//롬복의 어노테이션. 기본 생성자 자동 추가.
@Entity// JPA의 어노테이션. 필수이기 때문에 클래스와 가까이 두기. 테이블과 링크될 클래스임을 의미.
public class Posts {
    @Id// 해당 테이블의 PK필드를 의미.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼 의미. 필수 X.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성.
    public Posts(String title, String content , String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }

}
