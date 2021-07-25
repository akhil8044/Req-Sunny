package com.demo.service;

import com.demo.dao.PlansDao;
import com.demo.exceptions.ErrorMessage;
import com.demo.exceptions.PlanExceptions;
import com.demo.model.PlanType;
import com.demo.model.Plans;
import com.demo.model.Price;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlansService {
    private int counter;

    private RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(new HttpHost("localhost", 9200, "http")));

    private final PlansDao plansDao;

    public List<Plans> getPlans(PlanType planType) {
        switch (planType) {
            case SIMO:
                return plansDao.getPlans();
            case PHONE:
            default:
                throw new PlanExceptions(ErrorMessage.WRONG_PLAN_TYPE.getMessage());
        }
    }

    public void createIndex(String indexName) throws IOException {

        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 1));
        System.out.println(request);
        CreateIndexResponse createIndexResponse = client.indices()
                .create(request, RequestOptions.DEFAULT);
        System.out.println("response id: " + createIndexResponse.index());
    }

  public void addEntry(Plans plans, String indexName) throws IOException {

         counter++;

      plans.setTotalPrice(getPrice(plans.getTotalPrice().getNet()));
      plans.setId(UUID.randomUUID());

      getPrice(plans.getTotalPrice().getNet());
      IndexRequest indexRequest = new IndexRequest(indexName)
            .id(String.valueOf(counter))
            .source(new ObjectMapper().writeValueAsString(plans), XContentType.JSON);
    IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
    System.out.println("response id: " + indexResponse.getId());
    System.out.println("response name: " + indexResponse.getResult().name());
  }
    private Price getPrice(final Double net) {
        Double cGst = (net * 9) / 100;
        Double sGst = (net * 9) / 100;
        Double totalGst = sGst + cGst;
        Double totalPrice = net + totalGst;
        return new Price(net, totalPrice, totalGst, cGst, sGst);
    }
}
