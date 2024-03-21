package ir.miri.shop.app.helper.ui;

import ir.miri.shop.app.enums.ResponseStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceResponse <T> implements Serializable {
    private List<T> dataList;
    private ResponseStatus status;
    private boolean hasError;
    private String message;
    private long totalCount;

    public ServiceResponse(List<T> dataList, ResponseStatus status) {
        this.dataList = dataList;
        this.status = status;
        this.message="";
        this.hasError=status!=ResponseStatus.SUCCESS;
        this.totalCount=0;
    }
    public ServiceResponse(List<T> dataList, ResponseStatus status,long totalCount) {
        this.dataList = dataList;
        this.status = status;
        this.message="";
        this.hasError=status!=ResponseStatus.SUCCESS;
        this.totalCount=totalCount;
    }
    public ServiceResponse(T data, ResponseStatus status) {
        this.dataList = new ArrayList<>();
        this.dataList.add(data);
        this.status = status;
        this.message="";
        this.hasError=status!=ResponseStatus.SUCCESS;
        this.totalCount=0;
    }
    public ServiceResponse( ResponseStatus status,String message) {
        this.dataList = new ArrayList<>();
        this.status = status;
        this.message=message;
        this.hasError=status!=ResponseStatus.SUCCESS;
        this.totalCount=0;
    }
    public ServiceResponse( Exception exception) {
        this.dataList = new ArrayList<>();
        this.status = ResponseStatus.EXCEPTION;
        this.message=exception.getMessage();
        this.hasError=true;
        this.totalCount=0;
    }

    public ServiceResponse(ResponseStatus success, List<T> list) {
        this.dataList=list;
        this.status = ResponseStatus.SUCCESS;
        this.hasError=false;
        this.totalCount=0;
        this.message="Array size  ="+list.size();
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
