package com.dream.DBUtil;


public class Title {
    String title;
    String que1;
    String que2;
    String que3;
    String que4;
    String answer1;
    String answer2;
    String answer3;
    String answer4;

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", que1='" + que1 + '\'' +
                ", que2='" + que2 + '\'' +
                ", que3='" + que3 + '\'' +
                ", que4='" + que4 + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQue1() {
        return que1;
    }

    public void setQue1(String que1) {
        this.que1 = que1;
    }

    public String getQue2() {
        return que2;
    }

    public void setQue2(String que2) {
        this.que2 = que2;
    }

    public String getQue3() {
        return que3;
    }

    public void setQue3(String que3) {
        this.que3 = que3;
    }

    public String getQue4() {
        return que4;
    }

    public void setQue4(String que4) {
        this.que4 = que4;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
}
