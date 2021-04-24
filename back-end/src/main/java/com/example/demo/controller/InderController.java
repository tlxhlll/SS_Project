package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class InderController {
    @GetMapping("/request")
    public String index(String userName){
        System.out.print(userName);
        return "收到请求！";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello,I'm Gavin";
    }

    @GetMapping("/title0")
    public String title0(){
        String lineTxt = null;
        try{
            File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\0-省委统筹疫情防控督导组到德州运河新区督导疫情防控工作.txt");
            if(file.isFile() && file.exists()){
                InputStreamReader read = null;//考虑到编码格式
                try {
                    read = new InputStreamReader(
                            new FileInputStream(file),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader bufferedReader = new BufferedReader(read);
                while(true){
                    try {
                        if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(lineTxt);
                    break;
                }
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            System.out.print("error");
        }
        return lineTxt;
    }
    @GetMapping("/article0")
    public String article(){
        String lineTxt = null;
        try {
            File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\0-省委统筹疫情防控督导组到德州运河新区督导疫情防控工作.txt");
            if(file.isFile() && file.exists()){
                InputStreamReader read = null;//考虑到编码格式
                try {
                    read = new InputStreamReader(
                            new FileInputStream(file),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader bufferedReader = new BufferedReader(read);
                while(true){
                    try {
                        if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                        lineTxt= bufferedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(lineTxt);
                    break;
                }
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            System.out.print("error");
        }
        return lineTxt;
        }
        @GetMapping("/title1")
        public String title1(){
            String lineTxt = null;
            try{
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\1-疫情通报2021年4月19日新冠肺炎疫情信息.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/article1")
        public String article1(){
            String lineTxt = "";
            try {
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\1-疫情通报2021年4月19日新冠肺炎疫情信息.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (bufferedReader.readLine() == null) break;
                            String linshi="";
                            while((linshi= bufferedReader.readLine())!=null) lineTxt+=linshi;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/title2")
        public String title2(){
            String lineTxt = null;
            try{
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\2-疫情通报2021年4月19日广州市新冠肺炎疫情情况全国疫情风险地区最新汇总.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/article2")
        public String article2(){
            String lineTxt = "";
            try {
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\2-疫情通报2021年4月19日广州市新冠肺炎疫情情况全国疫情风险地区最新汇总.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (bufferedReader.readLine() == null) break;
                            String linshi="";
                            while((linshi= bufferedReader.readLine())!=null) lineTxt+=linshi;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/title3")
        public String title3(){
            String lineTxt = null;
            try{
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\3-东吴证券给予传智教育买入评级疫情下收入-31期待疫情后业绩恢复.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/article3")
        public String article3(){
            String lineTxt = "";
            try {
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\3-东吴证券给予传智教育买入评级疫情下收入-31期待疫情后业绩恢复.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (bufferedReader.readLine() == null) break;
                            String linshi="";
                            while((linshi= bufferedReader.readLine())!=null) lineTxt+=linshi;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/title4")
        public String title4(){
            String lineTxt = null;
            try{
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\4-新冠疫情夺走全球300万人生命.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/article4")
        public String article4(){
            String lineTxt = "";
            try {
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\4-新冠疫情夺走全球300万人生命.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (bufferedReader.readLine() == null) break;
                            String linshi="";
                            while((linshi= bufferedReader.readLine())!=null) lineTxt+=linshi;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/title5")
        public String title5(){
            String lineTxt = null;
            try{
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\5-海天味业海外销售受疫情的影响较大.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/article5")
        public String article5(){
            String lineTxt = "";
            try {
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\5-海天味业海外销售受疫情的影响较大.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (bufferedReader.readLine() == null) break;
                            String linshi="";
                            while((linshi= bufferedReader.readLine())!=null) lineTxt+=linshi;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/title6")
        public String title6(){
            String lineTxt = null;
            try{
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\6-印度疫情告急　新德里全城封锁.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (!((lineTxt = bufferedReader.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
        @GetMapping("/article6")
        public String article6(){
            String lineTxt = "";
            try {
                File file=new File("D:\\tjcFiles\\lecture\\third2\\FuWuKeXueDaoLun\\SS_proj\\6-印度疫情告急　新德里全城封锁.txt");
                if(file.isFile() && file.exists()){
                    InputStreamReader read = null;//考虑到编码格式
                    try {
                        read = new InputStreamReader(
                                new FileInputStream(file),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while(true){
                        try {
                            if (bufferedReader.readLine() == null) break;
                            String linshi="";
                            while((linshi= bufferedReader.readLine())!=null) lineTxt+=linshi;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(lineTxt);
                        break;
                    }
                    try {
                        read.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                System.out.print("error");
            }
            return lineTxt;
        }
    }
