package com.example.presentation;

import com.example.domain.Employee;
import com.example.usecase.Employees;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.example.TestUtils.*;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void GETでエンドポイントにemployeesが指定された場合全件検索が実行される() throws Exception {
        // assert
        mockMvc.perform(get("/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json(readFrom("test-json/select-all.json")));
    }

    @Test
    void GETでエンドポイントにidが指定された場合指定のidの従業員の名前が返される() throws Exception {
        // assert
        mockMvc.perform(get("/v1/employees/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(readFrom("test-json/select-id.json")));
    }

    @Test
    void POSTでエンドポイントにemployeesが指定された場合新規にデータが追加される() throws Exception {
        // setup
        mockMvc.perform(post("/v1/employees")
                        .content(readFrom("test-json/post-ok.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
//    @Test
//    void PATCHでエンドポイントにidが指定された場合指定のidの従業員の名前が更新される() throws Exception {
//        // assert
//        mockMvc.perform(patch("/v1/employees/101").content(readFrom("test-json/patch-before.json")))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(readFrom("test-json/patch-after.json")));
//    }
}
