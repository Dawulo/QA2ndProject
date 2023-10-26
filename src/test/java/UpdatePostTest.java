import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class UpdatePostTest extends BaseTest {

    @Test
    public void updatePost() {
        Post post = new Post("Dave", "Hello world");
        Post createdPost = given().spec(reqSpec).pathParam("postId", 4).body(post).
                when().put("{postId}").
                then().spec(resSpec).extract().body().as(Post.class);

        assertEquals(post, createdPost);
    }
}
