import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class AddPostTest extends BaseTest {

    @Test
    public void addPost() {
        Post post = new Post("Unknown", "New");
        Post createdPost = given().spec(reqSpec).body(post).
                when().post().
                then().statusCode(201).contentType(ContentType.JSON).extract().body().as(Post.class);

        assertEquals(post, createdPost);
    }
}
