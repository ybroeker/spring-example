package gpse.example.web;
// tag::test[]

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class) //<1>
@SpringBootTest //<2>
@AutoConfigureMockMvc //<3>
class BlogControllerIT {

    @Autowired
    private MockMvc mvc;  //<4>

    @Test
    void showBlog() throws Exception {
        this.mvc.perform(get("/"))  //<5>
                .andExpect(status().isOk())  //<6>
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //<7>
                .andExpect(content().string(containsString("A magnificent Article")))  //<8>
                .andExpect(content().string(containsString("Another Article")));
    }
}
// tag::test[]
