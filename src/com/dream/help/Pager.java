package com.dream.help;

public class Pager {
    private int total;//总共条数
    private int pageSize;//每页显示的条数
    private int currentPage;//当前页数

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //构造方法
    public Pager(int total,int pageSize,int currentPage){
        this.total=total;
        this.pageSize=pageSize;
        setCurrentPage(currentPage);
    }

    //构造方法
    public Pager(int total,int pageSize){
        this(total,pageSize,1);
    }

    //获取最大页数
    public int getPageCount(){
        if(total%pageSize!=0){
            return total/pageSize+1;
        }else{
            return total/pageSize;
        }
    }

    //起始索引，从哪一条开始显示
    public int getIndex(){
        return (currentPage-1)*pageSize;
    }
    //当前页
    public int getCurrentPage() {
        return currentPage;
    }
    //共多少条信息
    public int getTotal() {
        return total;
    }

    @Override
	public String toString() {
		return "Pager [total=" + total + ", pageSize=" + pageSize + ", currentPage=" + currentPage + "]";
	}

	public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    //下一页
    public int getNext(){
        return currentPage +1;
    }
    //前一页
    public int getAhead(){
        return currentPage-1;
    }
    //第一页
    public int getFirst(){
        return 1;
    }
}
