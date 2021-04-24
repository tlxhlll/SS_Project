package com.example.demo.SpiderJsoup;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Spider {
    public static void main(String[] args) throws IOException,InterruptedException{
        Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        WebClient webClient=new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(50000);
        String [] Title=new String[20];
        String [] Article=new String[20];
        int TitleNum=0;
        Spider spider=new Spider();
        /*Document document=Jsoup.connect("https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_aladin_banner")
                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
        System.out.print(document);*/
        HtmlPage htmlPage=webClient.getPage("https://search.sina.com.cn/?q=%e7%96%ab%e6%83%85&c=news&by=&from=home&t=&sort=rel&range=all");
        webClient.waitForBackgroundJavaScript(10000);
        Document document=Jsoup.parse(htmlPage.asXml());
        //System.out.print(document);
        //InternalData internalData=new InternalData();
        //国内数据
        String regEx="[\n|→： `~!@#$%^&*()+=|{}':;'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        //需要剔除的字符
        String white=" ";
        //需要剔除的字符我们用空白代替
        //internalData.Summary1=document.select("div[class=VirusSummarySix_1-1-300_2ZJJBJ]").text().replaceAll(regEx,white).replaceAll(",","").split(" ");
        //System.out.print(internalData.Summary1[1]);
        //internalData.Summary2[0]=document.select("span[class=VirusSummarySix_1-1-300_nfO6Mw]").text().replaceAll(regEx,white).replaceAll("/+"," ");
        //System.out.print(internalData.Summary2[0]);
        Elements allUrl=document.getElementsByClass("r-img");
        for(Element url:allUrl){
            String link=url.getElementsByTag("a").eq(0).attr("href");
            //System.out.print(link+"\n");
            HtmlPage htmlPage1=webClient.getPage(link);
            webClient.waitForBackgroundJavaScript(10000);
            Document doc=Jsoup.parse(htmlPage1.asXml());
            //System.out.print(doc);
            String title=doc.select("h1[class=main-title]").text().replaceAll(regEx,"");
            //title.replaceAll(regEx,"");
            Title[TitleNum]=title;
            System.out.print(title+"\n");
            String article="";
            article=doc.select("p[cms-style=font-L]").text();
            if(article.equals("")) article=doc.select("div[class=article]").text();
            System.out.print(article+"\n");
            Article[TitleNum]=article;
            TitleNum++;
        }
        int i=0;
        for(i=0;i<TitleNum-1;i++){
            spider.WriteString(String.valueOf(i)+"-"+Title[i]+".txt",Title[i],Article[i]);
        }

    }

    public void WriteString(String filePath, String title,String article) {
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println(title);// 往文件里写入字符串
            ps.println(article);
            ps.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

