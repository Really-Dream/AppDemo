package com.dream.help;

public class Pager {
    private int total;//�ܹ�����
    private int pageSize;//ÿҳ��ʾ������
    private int currentPage;//��ǰҳ��

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //���췽��
    public Pager(int total,int pageSize,int currentPage){
        this.total=total;
        this.pageSize=pageSize;
        setCurrentPage(currentPage);
    }

    //���췽��
    public Pager(int total,int pageSize){
        this(total,pageSize,1);
    }

    //��ȡ���ҳ��
    public int getPageCount(){
        if(total%pageSize!=0){
            return total/pageSize+1;
        }else{
            return total/pageSize;
        }
    }

    //��ʼ����������һ����ʼ��ʾ
    public int getIndex(){
        return (currentPage-1)*pageSize;
    }
    //��ǰҳ
    public int getCurrentPage() {
        return currentPage;
    }
    //����������Ϣ
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
    //��һҳ
    public int getNext(){
        return currentPage +1;
    }
    //ǰһҳ
    public int getAhead(){
        return currentPage-1;
    }
    //��һҳ
    public int getFirst(){
        return 1;
    }
}
