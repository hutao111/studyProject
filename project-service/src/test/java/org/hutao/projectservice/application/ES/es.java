package org.hutao.projectservice.application.ES;

//import io.searchbox.client.JestClient;
//import io.searchbox.core.Index;
//import io.searchbox.core.Search;
//import io.searchbox.core.SearchResult;
import org.hutao.projectapi.domain.DocumentClassify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class es {

//    @Autowired
//    JestClient jestClient;

//    @Test
//    public void test(){
//        DocumentClassify documentClassify = new DocumentClassify();
//        documentClassify.setName("taoge");
//        documentClassify.setId(1l);
//        documentClassify.setCode(1);
//        Index build = new Index.Builder(documentClassify).index("study").type("classify").build();
//        try {
//            jestClient.execute(build);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void test2(){
//
//        String json = "{\n" +
//                "    \"query\" : {\n" +
//                "        \"match\" : {\n" +
//                "            \"id\" : \"1\"\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//        Search builder = new Search.Builder(json).addIndex("study").addType("classify").build();
//
//
//        try {
//            SearchResult result = jestClient.execute(builder);
//            System.out.println(result.getJsonString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
