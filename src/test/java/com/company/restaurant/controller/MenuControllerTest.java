package com.company.restaurant.controller;


import com.google.gson.*;
import com.system.restaurant.controller.*;
import com.system.restaurant.domain.*;

import com.system.restaurant.mapper.*;
import org.junit.*;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.restdocs.*;
import org.springframework.restdocs.mockmvc.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import java.util.*;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
//        "classpath:servlet-context.xml",
//        "classpath:root-context.xml"
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
})
@WebAppConfiguration
public class MenuControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext context;

    @Autowired
    MenuController menuController;


    private MockMvc mockMvc;
    private RestDocumentationResultHandler document;

    @Before
    public void setUp() {
        this.document = document("{class-name}/{method-name}",
                preprocessResponse(prettyPrint())
        );
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation)
                        .uris().withScheme("https").withHost("kingcjy.com").withPort(443))
                .alwaysDo(document)
                .build();
    }

    @Test
    public void 등록() throws Exception {

        Menu menu = new Menu();
        menu.setMenuName("자장면");
        menu.setMenuPrice(5000);
        menu.setCookingTime(10);

        String jsonString = new GsonBuilder().setPrettyPrinting().create().toJson(menu);
        Map<String, Object> data = new Gson().fromJson(jsonString, Map.class);

        mockMvc.perform(
                post("/menus")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("menuName", "자장면")
                        .param("menuPrice", "4000")
                        .param("cookingTime", "10"))
//                        .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document.document(
                        responseFields(
                                fieldWithPath("menuId").description("상품 이름"),
                                fieldWithPath("menuName").description("상품 이름"),
                                fieldWithPath("menuPrice").description("상품 설명"),
                                fieldWithPath("cookingTime").type(Integer.class).description("상품 수량")
                        )
                ));
    }




}
