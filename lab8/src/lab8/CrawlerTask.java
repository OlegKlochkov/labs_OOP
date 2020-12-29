package lab8;
import java.util.*;

//через интерфейс Runnable реализуетс€ многопоточность
//также могопоточность можно реализовать, наследу€ класс Thread
public class CrawlerTask implements Runnable {
    

    public URLDepthPair depthPair;
    

    public URLPool myPool;
    
    public CrawlerTask(URLPool pool) {
        myPool = pool;
    }
    

    //выполн€етс€ поиск ссылок на странице в отдельном потоке
    public void run() {

        depthPair = myPool.get();

        int myDepth = depthPair.getDepth();

        LinkedList<String> linksList = new LinkedList<String>();
        linksList = Crawler.getAllLinks(depthPair);

        for (int i=0;i<linksList.size();i++) {
            String newURL = linksList.get(i);

            URLDepthPair newDepthPair = new URLDepthPair(newURL, myDepth + 1);
            myPool.put(newDepthPair);
        }
    }
    
}
