package pl.larys.jba.service;

import org.junit.Before;
import org.junit.Test;
import pl.larys.jba.entity.Item;
import pl.larys.jba.exception.RssException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by piotr on 15.05.16.
 */
public class RssServiceTest {

    private RssService rssService;

    @Before
    public void setUp() throws Exception {
        rssService = new RssService();
    }

    @Test
    public void getItems() throws RssException {
        List<Item> items = rssService.getItems(new File("test-rss/javavids.xml"));
        assertEquals(10, items.size());

        Item firstItem = items.get(0);
        assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getTitle());
        assertEquals("22 06 2014 22:35:49", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
    }

}