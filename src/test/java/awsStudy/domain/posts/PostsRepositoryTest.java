package awsStudy.domain.posts;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest extends TestCase {

    @Autowired
    PostsRepository postsRepository;

    @After//JUnit 에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정.
          //배초 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용.
    public void cleanup(){
        postsRepository.deleteAll();;
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content="테스트 본문";

        postsRepository.save(Posts.builder()// 테이블 posts에 insert/update 쿼리르 실행.
                                            //id 값이 있다면 update, 없다면 insert 쿼리 실행.
                .title(title)
                .content(content)
                .author("ahtnwl1004@gmail.com")
                .build() );

        //when
        List<Posts> postsList = postsRepository.findAll();// 테이블 posts 에 있는 모든 데이터를 조회.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}