package com.jiajun.starter.web;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.file.Paths;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: 影风
 * @Date: 2019-08-02 16:27
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {WebStarterApplication.class})
@AutoConfigureMockMvc
public class SwaggerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void generateAsciiDocsToFile() throws Exception {
        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");

        RequestBuilder builder = MockMvcRequestBuilders.get("/v2/api-docs");

        MvcResult mvcResult = mockMvc.perform(builder).andReturn();

        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
        Swagger2MarkupConverter.from(swaggerJson)
                .withConfig(config)
                .build()
                .toFile(Paths.get(outputDir + "/swagger"));
    }
}
