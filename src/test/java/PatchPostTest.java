import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PatchPostTest extends BaseTest {

    @Test
    public void patchPost() {
        Post post = new Post("Update");
        Post createdPost = given().spec(reqSpec).pathParam("postId", 5).body(post).
                when().patch("{postId}").
                then().spec(resSpec).extract().body().as(Post.class);

        assertEquals(createdPost.getTitle(), "Update");
        assertEquals(createdPost.getAuthor(), "Tom");
    }
}
