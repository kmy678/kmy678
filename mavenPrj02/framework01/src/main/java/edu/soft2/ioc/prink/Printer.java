//package edu.soft2.ioc.prink;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class Printer {
//    private Ink ink;
//    private Paper paper;
//
//
//
//    @Autowired
//    @Qualifier("b5Paper")
//    public void setInk(Ink ink) {
//        this.ink = ink;
//    }
//
//    @Autowired
//    @Qualifier("colorInk")
//    public void setPaper(Paper paper) {
//        this.paper = paper;
//    }
//
//    public Paper getPaper() {
//        return paper;
//    }
//
//    public Ink getInk() {
//        return ink;
//    }
//
//    public void print(){
//        System.out.println("用"+ink.getType()+"墨盒打印一张"+paper.getSize()+"纸上面");
//    }
//}
