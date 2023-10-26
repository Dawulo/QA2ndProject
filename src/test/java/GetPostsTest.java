import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostsTest extends BaseTest {

    @Test
    public void getPosts() {
        given().spec(reqSpec).
                when().get().
                then().spec(resSpec).assertThat().body("title[0]", equalTo("First")).
                assertThat().body("author[0]", equalTo("Matt")).
                and().assertThat().body("title[1]", equalTo("Second")).
                assertThat().body("author[1]", equalTo("Sam")).
                and().assertThat().body("title[2]", equalTo("Third")).
                assertThat().body("author[2]", equalTo("John"));
    }
}
