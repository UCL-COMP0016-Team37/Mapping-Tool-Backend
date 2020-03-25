package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQuery;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.Organisation;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityDisplayItem;
import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;
import uk.ac.ucl.mappingtool.v2.repository.PublisherRepository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.text.html.Option;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void testRequestURL(){
        StringBuilder sb = new StringBuilder();
        sb.append("https://iatidatastore.iatistandard.org/api/activities/?"); // base url
        sb.append("format=json&");  // format
        sb.append("fields=title&"); // fields

        sb.append("recipient_country=");
        sb.append("AF");
        sb.append("&");
        sb.append("page=");
        sb.append("2");

        String url = sb.toString();

        String json = HttpRequest.requestJson(url);
        Type countryType = new TypeToken<ListView<ActivityDisplayItem>>(){}.getType();

        Gson gson = new Gson();
        ListView<ActivityDisplayItem> countryListView = gson.fromJson(json, countryType);

        System.out.println(countryListView.getResults());
    }

    @Test
    public void testFlowMap() throws Exception{
        String url = "https://iatidatastore.iatistandard.org/api/transactions/aggregations/?group_by=reporting_organisation&aggregations=activity_count,value&format=json&recipient_country=AF";

        String json = HttpRequest.requestJson(url);

        Type queryType = new TypeToken<BudgetQuery<Organisation>>(){} .getType();

        Gson gson = new Gson();
        BudgetQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<Organisation>> results = budgetQueryObject.getResults();


        for(BudgetQueryItem<Organisation> item: results){
            String orgId = item.getGroup().getId();

            Optional<Publisher> optional = publisherRepository.findById(orgId);
            Publisher publisher = optional.get();

            String countryCode = publisher.getCountryCode();

            item.getGroup().setCountryCode(countryCode);

        }

        System.out.println(results);



    }
}
