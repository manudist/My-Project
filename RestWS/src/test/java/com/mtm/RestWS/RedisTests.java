package com.mtm.RestWS;
import com.mtm.library.model.Author;
import com.mtm.library.model.Manga;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RedisTests {
    @Autowired
    public RedisTemplate<String,Object> redisTemplate;

    @Test
    public void testManga(){
        Manga manga=new Manga();
        manga.setTitle("Prova");
        redisTemplate.opsForValue().set("Key",manga);
        assertThat(((Manga)redisTemplate.opsForValue().get("Key")).getTitle()).isEqualTo(manga.getTitle());
    }
    @Test
    public void testAuthor(){
        Author author=new Author();
        author.setName("Prova");
        redisTemplate.opsForValue().set("Key",author);
        assertThat(((Author)redisTemplate.opsForValue().get("Key")).getName()).isEqualTo(author.getName());
    }
}
