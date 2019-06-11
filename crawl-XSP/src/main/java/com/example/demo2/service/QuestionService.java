package com.example.demo2.service;

import com.example.demo2.dao.QuestionDao;
import com.example.demo2.dao.QuestionMapper;
import com.example.demo2.entity.Answer;
import com.example.demo2.entity.Question;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {


    @Autowired
    QuestionDao questionDao;

    public void question_crawl() {
        try {
            int x = 1;
            int status = 1;

            while (x <2) {
                String url = "https://www.xinshipu.com/question?page=" + x;
                Document doc = Jsoup.connect(url).get();
                //获取页面问题
                Elements elementsByClass = doc.getElementsByClass("bpannel qandahr p15").select("ul").select("li");
               // System.out.println("个数：" + elementsByClass.size());
                for (Element element : elementsByClass) {
                    String attr = element.getElementsByClass("fl w410").select("a").attr("href");
                    show(attr, status);
                }
                x++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示内容方法
     */
    public void show(String attr, int status) throws Exception {
        Document document = Jsoup.connect("https://www.xinshipu.com/" + attr).get();
        String text1 = document.getElementsByClass("font16").select("p").text();
        //问题
        String[] text = text1.split("回答问题");
        Question po = new Question();
        po.setType(1);
        po.setStatus(1);
        po.setUrl("https://www.xinshipu.com/" + attr);
        po.setText(text[0]);
        System.out.println("问题："+text[0]);
//        questionDao.insertQuestion(po);
        /**
         * 显示答案
         */
        Elements select = document.getElementsByClass("cg1").select("span[style]");//选择class"cg1 "+带有style属性的span元素
        for (Element element : select) {
            //System.out.println("\nanswer:" + element.text().trim());
            Answer answer=new Answer();
            answer.setText(element.text().trim());//trim删除空格
            answer.setStatus(1);
            answer.setQuestionid(po.getId());
            System.out.println("答案："+element.text().trim());
//            questionDao.insertAnswer(answer);
        }
    }
}